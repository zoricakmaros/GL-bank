/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glbank;

import java.util.Date;

/**
 *
 * @author client
 */
public class Client {
    private int idc;
    private String lastname;
    private String firstname;
    private String email;
    private String street;
    private int housenumber;
    private String postcode;
    private String city;
    private String username;
    private boolean disable;
    private boolean blocked;
    private Date dob;

    public Client(int idc, String lastname, String firstname, String email, String street, int housenumber, String postcode, String username, boolean disable, boolean blocked, Date dob, String city) {
        this.idc = idc;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.street = street;
        this.housenumber = housenumber;
        this.postcode = postcode;
        this.username = username;
        this.disable = disable;
        this.blocked = blocked;
        this.dob = dob;
        this.city=city;
    }

    public Client(int idc, String lastname, String firstname, Date dob) {
       this.idc=idc;
       this.lastname=lastname;
       this.firstname=firstname;
       this.dob=dob;
       this.street=this.username=this.postcode=null;
       this.housenumber=0;
       this.email=null;
       this.disable=false;
       this.blocked=false;
       this.city=null; 
    }

    public int getIdc() {
        return idc;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Date getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getStreet() {
        return street;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getUsername() {
        return username;
    }
    
    
}
