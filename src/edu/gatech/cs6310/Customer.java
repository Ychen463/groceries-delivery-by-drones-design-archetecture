package edu.gatech.cs6310;

import java.util.ArrayList;

public class Customer {
    private String custID;
    private String firstName;
    private String lastName;
    private String custPhone;
    private Integer custRating;
    private Integer custCredits;

    public void Customer(String custID, String firstName, String lastName,String custPhone,Integer custRating, Integer custCredits) {
        /* initiator */
        this.custID = custID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.custPhone = custPhone;
        this.custRating = custRating;
        this.custCredits = custCredits;
    }
    // setters
    public void setCustID(String custID) {this.custID = custID;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setCustPhone(String custPhone) {this.custPhone = custPhone;}
    public void setCustRating(Integer custRating) {this.custRating = custRating;}
    public void setCustCredits(Integer custCredits) {this.custCredits = custCredits;}
    // getters
    public String getCustID() {return this.custID;}
    public String getFirstName(String firstName) {return this.firstName;}
    public String getLastName(String lastName) {return this.lastName;}
    public String getName(String firstName, String lastName) {return this.firstName+'_'+this.lastName;}
    public String getCustPhone(String custID) {return this.custPhone;}
    public Integer getCustRating(String custID) {return this.custRating;}
    public Integer getCustCredits(String custID) {return this.custCredits;}

    // make_customer
    public void make_customer(String custID, String firstName, String lastName,String custPhone,Integer custRating, Integer custCredits) {
        this.setCustID(custID);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCustPhone(custPhone);
        this.setCustRating(custRating);
        this.setCustCredits(custCredits);
        System.out.println("OK:change_completed");
    }


}

