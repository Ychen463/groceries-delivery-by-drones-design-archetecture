package edu.gatech.cs6310;

import java.util.ArrayList;

public class Items {
    private String storeName;
    private String itemName;
    private Integer quantity;

    public void Items(String storeName, String itemName, Integer quantity) {
        /* initiator */
        this.storeName = storeName;
        this.itemName = itemName;
        this.quantity = quantity;
    }
    // setters
    public void setStoreName(String storeName) {this.storeName = storeName;}
    public void setItemName(String itemName) {this.itemName = itemName;}
    public void setQuantity(Integer quantity) {this.quantity = quantity;}
    // getters
    public String getStoreName() {return this.storeName;}
    public String getItemName(String storeName) {return this.itemName;}
    public Integer getQuantity() {return this.quantity;}

    // make_store
    public void sell_item(String storeName, String itemName, Integer quantity) {
        this.setStoreName(storeName);
        this.setItemName(itemName);
        this.setQuantity(quantity);
        System.out.println("OK:change_completed");
    }


}

