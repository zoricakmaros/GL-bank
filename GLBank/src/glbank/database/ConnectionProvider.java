/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glbank.database;

import glbank.Account;
import glbank.Client;
import glbank.Employee;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author client
 */
public class ConnectionProvider {
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static final String DBNAME="GLBank";
    private static final String URL="jdbc:mysql://localhost/";
    private static final String DRIVER="com.mysql.jdbc.Driver";
    
    private Connection getConnection(){
        Connection conn=null;
        try {
            conn = DriverManager.getConnection(URL+DBNAME, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.toString());
        }
       return conn; 
    }
    
    public boolean isEmployeePasswordValid(String username, String password){
        String query="SELECT idemp FROM LoginEmployee WHERE login LIKE BINARY ? AND password LIKE BINARY ?";
        Connection conn = getConnection();
        if(conn!=null){
            try {
                 PreparedStatement ps= conn.prepareStatement(query);
                 ps.setString(1, username);
                 ps.setString(2, password);
                 ResultSet rs = ps.executeQuery();
                 boolean ret=rs.next();
                 conn.close();
                 
                 return ret;
                 
            }catch(SQLException ex){
                System.out.println("Error: "+ex.toString());
            }
        }
        return false;
    }
    
    public boolean isEmployeePasswordValid(int idemp, String password){
        String query="SELECT idemp FROM LoginEmployee WHERE idemp = ? AND password LIKE BINARY ?";
        Connection conn = getConnection();
        if(conn!=null){
            try {
                 PreparedStatement ps= conn.prepareStatement(query);
                 ps.setInt(1, idemp);
                 ps.setString(2, password);
                 ResultSet rs = ps.executeQuery();
                 boolean ret=rs.next();
                 conn.close();
                 
                 return ret;
                 
            }catch(SQLException ex){
                System.out.println("Error: "+ex.toString());
            }
        }
        return false;
    }
    
    public int getEmployeeId(String username){
        String query="SELECT idemp FROM LoginEmployee WHERE login LIKE BINARY ?";
        Connection conn = getConnection();
        int id=-1;
        if(conn!=null){
            try {
                 PreparedStatement ps= conn.prepareStatement(query);
                 ps.setString(1, username);
                 ResultSet rs = ps.executeQuery();
                 if(rs.next()){
                     id=rs.getInt("idemp");
                 }
                 
            }catch(SQLException ex){
                System.out.println("Error: "+ex.toString());
            }
        }
        return id;
    }
    
    public void logEmployeeAccess(int id){
        String query="INSERT INTO historyloginemployee(idemp,logindate) "+
                " VALUES (?,?)";
        String date=getDateTime();
        Connection conn = getConnection();
        if(conn!=null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                ps.setString(2, date);
                ps.execute();
                conn.close();
            }catch(SQLException ex){
                 System.out.println("Error: "+ex.toString());
            }
        }
        
    }
    
    public String getDateTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString=sdf.format(date);
        return dateString;
                
    }
    
    public Employee getEmployee(int id){
        String query = "SELECT * FROM Employees WHERE idemp = ?";
        Employee employee = null;
        Connection conn = getConnection();
        if(conn!=null){
            try {
                PreparedStatement ps= conn.prepareStatement(query);
                ps.setInt(1, id);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String email = rs.getString("email");
                    char position = rs.getString("position").charAt(0);
                    
                    employee = new Employee(id, firstname,  lastname, email, position);
                    }
                conn.close();
            }catch(SQLException ex){
                System.out.println("Error: "+ex.toString());
            }
        }
        
        return employee;
    }
    
    public void changePassword(int idemp, String newPassword){
        String query = "UPDATE LoginEmployee SET password=? WHERE idemp=?";
        Connection conn=getConnection();
        if(conn!=null){
            try(PreparedStatement ps=conn.prepareStatement(query)){
            ps.setString(1, newPassword);
            ps.setInt(2, idemp);
            ps.execute();
            conn.close();
            }catch(SQLException ex){
                System.out.println("Error: "+ex.toString());
            }
        }
    }
    
    public List<Client> getListOfAllClients(){
        String query = "SELECT * FROM Clients "+
                " INNER JOIN ClientDetails ON Clients.idc=ClientDetails.idc "+
                " WHERE disable = 'F'"+
                " ORDER BY lastname, firstname";
        Connection conn=getConnection();
        List<Client> list = new ArrayList<>();
        if(conn!=null){
            try(Statement statement = conn.createStatement()){
                ResultSet rs = statement.executeQuery(query);
                while(rs.next()){
                    int idc=rs.getInt("Clients.idc");
                    String firstname=rs.getString("firstname");
                    String lastname=rs.getString("lastname");
                    Date dob = rs.getDate("dob");
                    Client client = new Client(idc, lastname, firstname,dob);
                    list.add(client);
                 
                }
                 conn.close();
            }catch(SQLException ex){
                 System.out.println("Error: "+ex.toString());   
            }
            
        }
        return list;
    }
    
    public boolean existUsername(String username){
        String query="SELECT login FROM LoginClient WHERE login LIKE ?";
        Connection conn = getConnection();
        try ( PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            boolean ret = rs.next();
            conn.close();
            if(ret)
                return true;
            else 
                return false;
        }catch (SQLException ex){
            System.out.println("Error: "+ex.toString()); 
            
        }
        return false;
    }
    
    public void insertNewClient(Client client, String password){
        Connection conn = getConnection();
        int idc=insertDataIntoCliensTable(client,conn);
        if(idc>0){
            client.setIdc(idc);
            insertDataIntoLoginClientTable(client, password,conn);
            insertDataIntoClientDetails(client,conn);
        }
    }

    private int insertDataIntoCliensTable(Client client, Connection conn ) {
        String query="INSERT INTO Clients(firstname, lastname) "+
                " VALUES (?, ?)";
        String querySelect = "SELECT max(idc) AS idc FROM Clients "+
                " WHERE firstname LIKE ? AND lastname LIKE ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, client.getFirstname());
            ps.setString(2, client.getLastname());
            ps.execute();
            
            // SELECT
            ps=conn.prepareStatement(querySelect);
            ps.setString(1, client.getFirstname());
            ps.setString(2, client.getLastname());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int idc=rs.getInt("idc");
                return idc;
            }
        }catch(SQLException ex){
             System.out.println("Error: "+ex.toString());
        }
        return 0;
    }

    private void insertDataIntoLoginClientTable(Client client, String password, Connection conn) {
        String query = "INSERT INTO LoginClient (idc, login, password) "+
                "VALUES (?,?,?)";
        try{
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, client.getIdc());
        ps.setString(2, client.getUsername());
        ps.setString(3, password);
        ps.execute();
        }catch(SQLException ex){
            System.out.println("Error: "+ex.toString());
        }
        
    }

    private void insertDataIntoClientDetails(Client client, Connection conn) {
         String query = "INSERT INTO ClientDetails (idc, street, housenumber, postcode,dob, email, city) "+
                "VALUES (?,?,?,?,?,?,?)";
         try{
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, client.getIdc());
            ps.setString(2, client.getStreet());
            ps.setInt(3, client.getHousenumber());
            ps.setString(4, client.getPostcode());
            ps.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(client.getDob()));
            ps.setString(6, client.getEmail());
            ps.setString(7, client.getCity());
            ps.execute();
            conn.close();
         }catch(SQLException ex){
             System.out.println("Error: "+ex.toString());
         }
    }

    public Client getClient(int idc){
        String query = "SELECT * FROM Clients AS cl "+
                " INNER JOIN ClientDetails AS cd ON cl.idc=cd.idc "+
                " INNER JOIN LoginClient AS lc ON lc.idc=cl.idc "+
                " WHERE cl.idc=?";
        Connection conn=getConnection();
        try{
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setInt(1, idc);
           ResultSet rs=ps.executeQuery();
           if(rs.next()){
               String firstname = rs.getString("firstname");
               String lastname = rs.getString("lastname");
               String email = rs.getString("email");
               String street = rs.getString("street");
               String city = rs.getString("city");
               String postcode = rs.getString("postcode");
               String login = rs.getString("login");
               Date dob = rs.getDate("dob");
               int num = rs.getInt("housenumber");
               boolean disable = rs.getString("disable").toUpperCase().charAt(0)=='T';
               boolean blocked = rs.getString("blocked").toUpperCase().charAt(0)=='T';
                           
               Client client = new Client(idc, lastname, firstname, email, street, num, postcode, login, disable, blocked, dob,city );
               conn.close();
               return client;
           }   
           
        }catch(SQLException ex){
            System.out.println("Error: "+ex.toString());
        }
        return null;
    }
    
    public List<Account> getAccounts(int idc){
        String query = "SELECT * FROM Accounts WHERE idc=?";
        Connection conn=getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idc);
            ResultSet rs= ps.executeQuery();
            List<Account> list = new ArrayList<>();
            while(rs.next()){
                Account account = new Account(rs.getLong("idacc"), idc, rs.getFloat("balance"));
                list.add(account);
            }
            conn.close();
            return list;
        }catch(SQLException ex){
            System.out.println("Error: "+ex.toString());
        }
        return null;
    }
    
    public boolean existsAccount(long idacc){
        String query="SELECT idacc FROM Accounts WHERE idc = ?";
        try {
           Connection conn = getConnection();
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setLong(1, idacc);
           ResultSet rs=ps.executeQuery();
           if(rs.next()){
               conn.close();
               return true;
           }  
           conn.close();
        }catch(SQLException ex){
            System.out.println("Error: "+ex.toString());
        }
        
        return false;
    }

    public void insertNewAccount(int idc, long proposalAccount) {
        String query ="INSERT INTO Accounts VALUES(?,?,?)";
        try{
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setLong(1, proposalAccount);
            ps.setInt(2, idc);
            ps.setFloat(3, 0);
            ps.executeUpdate();
            conn.close();
        }catch(SQLException ex){
            System.out.println("Error: "+ex.toString());
        }
    }

    public void insertCash(long idacc, float value, int idemp) {
        try {
        Connection conn = getConnection();
       
            try {

                conn.setAutoCommit(false);

                updateAccount(idacc,value,conn);
                writeLogTransaction(idacc, value, idemp,conn);
                conn.commit();
            }catch(SQLException ex){
                conn.rollback();
                System.out.println("Error: "+ex.toString());
            }
        }catch(SQLException ex){
            System.out.println("Error: "+ex.toString());
        }
    
    
    }

    private void updateAccount(long idacc, float value, Connection conn) throws SQLException{
        String query="UPDATE accounts SET balance=balance+? WHERE idacc=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setFloat(1, value);
        ps.setLong(2, idacc);
        ps.executeUpdate();
    }

    private void writeLogTransaction(long idacc, float value, int idemp, Connection conn) {
    }
}
