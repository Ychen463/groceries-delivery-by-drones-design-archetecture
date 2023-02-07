package edu.gatech.cs6310;

import java.util.ArrayList;

public class Order {
    private String storeName;
    private String orderID;
    private String droneID;
    private String custID;


    public void Customer(String storeName, String orderID, String droneID,String custID) {
        /* initiator */
        this.storeName = storeName;
        this.orderID = orderID;
        this.droneID = droneID;
        this.custID = custID;
    }
    // setters
    public void setStoreName(String storeName) {this.storeName = storeName;}
    public void setOrderID(String orderID) {this.orderID = orderID;}
    public void setDroneID(String droneID) {this.droneID = droneID;}
    public void setCustID(String custID) {this.custID = custID;}

    // getters
    public String getOrderID() {return this.orderID;}
    public String getStoreName(String orderID) {return this.storeName;}
    public String getDroneID(String orderID) {return this.droneID;}
    public String getCustID(String orderID) {return this.custID;}

    // start_order
    public void start_order(String storeName, String orderID, String droneID,String custID) {
        this.setOrderID(orderID);
        this.setStoreName(storeName);
        this.setDroneID(droneID);
        this.setCustID(custID);
        System.out.println("OK:change_completed");
    }




}

