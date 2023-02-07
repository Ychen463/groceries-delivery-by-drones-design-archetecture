package edu.gatech.cs6310;

public class Store {
    private String storeName;
    private Integer revenue;

    public void Store(String storeName, Integer revenue) {
        /* initiator */
        this.storeName = storeName;
        this.revenue = revenue;
    }
    // setters
    public void setRevenue(Integer revenue) {this.revenue = revenue;}
    public void setStoreName(String storeName) {this.storeName = storeName;}

    // getters
    public Integer getRevenue(String storeName) {return this.revenue;}
    public String getStoreName() {return this.storeName;}

    // make_store
    public void make_store(String storeName, Integer revenue) {
        this.setStoreName(storeName);
        this.setRevenue(revenue);
        System.out.println("OK:change_completed");
    }

}

