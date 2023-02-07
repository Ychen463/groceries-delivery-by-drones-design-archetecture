package edu.gatech.cs6310;

import java.util.ArrayList;

public class Drone {
    private String storeName;
    private String droneID;
    private Integer weightCapacity;
    private Integer numAvailableDeliveries;

    private String pilotID;




    public void Items(String storeName,String droneID, Integer weightCapacity,Integer numAvailableDeliveries) {
        /* initiator */
        this.storeName = storeName;
        this.droneID = droneID;
        this.weightCapacity = weightCapacity;
        this.numAvailableDeliveries = numAvailableDeliveries;
    }
    // setters
    public void setStoreName(String storeName) {this.storeName = storeName;}
    public void setDroneID(String droneID) {this.droneID = droneID;}
    public void setWeightCapacity(Integer weightCapacity) {this.weightCapacity = weightCapacity;}
    public void setNumAvailableDeliveries(Integer numAvailableDeliveries) {this.weightCapacity = numAvailableDeliveries;}
    public void setPilotID(String pilotID) {
        this.pilotID = pilotID;
    }

    // getters
    public String getStoreName(String droneID) {return this.storeName;}
    public String getDroneID() {return this.droneID;}
    public Integer getWeightCapacity(String droneID) {return this.weightCapacity;}
    public Integer getNumAvailableDeliveries(String droneID) {return this.numAvailableDeliveries;}


    // make_drone
    public void make_drone(String storeName,String droneID, Integer weightCapacity,Integer numAvailableDeliveries) {
        this.setStoreName(storeName);
        this.setDroneID(droneID);
        this.setWeightCapacity(weightCapacity);
        this.setNumAvailableDeliveries(numAvailableDeliveries);
        System.out.println("OK:change_completed");
    }
//    // num_orders
//    public Integer drone_num_orders(String droneID){
//        num_orders = 12
//        return num_orders;
//    }
//    // remaining_cap
//    public Integer drone_num_orders(String droneID){
//        return this.weightCapacity - drone_num_orders(this.droneID) *
//    }
    // fly_drone()
    public void fly_drone(String storeName,String droneID, String pilotID) {
        this.setStoreName(storeName);
        this.setDroneID(droneID);
        this.setPilotID(pilotID);
        System.out.println("OK:change_completed");
    }


}

