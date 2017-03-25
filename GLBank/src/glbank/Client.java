/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glbank;

import java.util.Date;

/**
 *
 * @author Maros
 */
public class Client {
    private int idc;
    private String lastname;
    private String firstname;
    private String email;
    private String street;
    private int housecode;
    private String postcode;
    private String username;
    private boolean disable;
    private boolean blocked;
    private Date dob;

    public Client(int idc, String lastname, String firstname, String email, String street, int housecode, String postcode, String username, boolean disable, boolean blocked) {
        this.idc = idc;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.street = street;
        this.housecode = housecode;
        this.postcode = postcode;
        this.username = username;
        this.disable = disable;
        this.blocked = blocked;
        this.dob= dob;
        
   
    public Client(int idc, String lastname, String firstname,Date dob){
        this.idc=idc;
        this.lastname=lastname;
        this.firstname=firstname;
        this.dob=dob;
        this.street= this.username=this.postcode=null;
        this.housecode=0;
        this.email=null;
        this.disable=false;
        this.blocked=false;
        
    } 
    }

   
 

 
    

