package edu.gatech.cs6310;

import java.util.ArrayList;

public class Pilot {
    private String pilotId;
    private String pilotFirstname;
    private String pilotLastname;
    private String pilotPhone;
    private String pilotTaxID;
    private String pilotLicenseID;
    private Integer numDeliveredOrders;

    public void Items(String pilotId,String pilotFirstname,String pilotLastname,String pilotPhone,String pilotTaxID, String pilotLicenseID, Integer numDeliveredOrders) {
        /* initiator */
        this.pilotId = pilotId;
        this.pilotFirstname = pilotFirstname;
        this.pilotLastname = pilotLastname;
        this.pilotPhone = pilotPhone;
        this.pilotTaxID = pilotTaxID;
        this.pilotLicenseID = pilotLicenseID;
        this.numDeliveredOrders = numDeliveredOrders;
    }
    // setters
    public void setPilotId(String pilotId) {this.pilotId = pilotId;}
    public void setPilotFirstname(String pilotFirstname) {this.pilotFirstname = pilotFirstname;}
    public void setPilotLastname(String pilotLastname) {this.pilotFirstname = pilotLastname;}
    public void setPilotPhone(String pilotPhone) {this.pilotPhone = pilotPhone;}
    public void setPilotTaxID(String pilotTaxID) {this.pilotTaxID = pilotTaxID;}
    public void setPilotLicenseID(String pilotLicenseID) {this.pilotLicenseID = pilotLicenseID;}
    public void setNumDeliveredOrders(Integer numDeliveredOrders) {this.numDeliveredOrders = numDeliveredOrders;}

    // getters
    public String getPilotId() {return this.pilotId;}
    public String getPilotName(String pilotId) {return this.pilotFirstname+'_'+this.pilotLastname;}
    public String getPilotPhone(String pilotId) {return this.pilotPhone;}
    public String getPilotTaxID(String pilotId) {return this.pilotTaxID;}
    public String getPilotLicenseID(String pilotId) {return this.pilotLicenseID;}
    public Integer getNumDeliveredOrders(String pilotId) {return this.numDeliveredOrders;}

    // make_store
    public void make_pilot(String pilotId,String pilotFirstname,String pilotLastname, String pilotPhone,String pilotTaxID, String pilotLiscenseID, Integer NumDeliveredOrders) {
        this.setPilotId(pilotId);
        this.setPilotFirstname(pilotFirstname);
        this.setPilotLastname(pilotLastname);
        this.setPilotPhone(pilotPhone);
        this.setPilotTaxID(pilotTaxID);
        this.setPilotLicenseID(pilotLicenseID);
        this.setNumDeliveredOrders(numDeliveredOrders);
        System.out.println("OK:change_completed");
    }


}

