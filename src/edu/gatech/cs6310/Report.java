package edu.gatech.cs6310;

import java.util.*;


public class Report {
    private HashMap<String, Store> stores;
    private HashMap<String, Pilot> pilots;
    private HashMap<String, Items> store_items;
    private HashMap<String, Drone> drones;
    private HashMap<String, Customer> customers;
    private HashMap<String, Order> orders;

    public void display_stores() {
        /* Handle Error*/
        if (stores.isEmpty()) {
            System.out.println("ERROR: " + '"' + "store_identifier_does_not_exist" + '"');
        } else {
            // sort by key
            List<String> storesByKey = new ArrayList<>(stores.keySet());
            Collections.sort(storesByKey);
            // iterate
            for (String s : storesByKey) {
                Store each_store = new Store();
                String value1 = s;
                String value2 = String.valueOf(Integer.valueOf(each_store.getRevenue(s)));
                System.out.println("name: " + value1 + ", revenue: " + value2);
            }
            System.out.println("OK:display_completed");
        }
    }

    public void display_items(String storeName) {
        if (!stores.containsKey(storeName)) {
            System.out.println("ERROR: " + '"' + "store_identifier_does_not_exist" + '"');
        } else {
            for (Map.Entry<String, Items> my_items : store_items.entrySet()) {
                String my_items_storeName = my_items.getKey();
                Items my_Item = my_items.getValue();

                if (my_items_storeName == storeName) {
                    System.out.println(my_Item.getItemName(storeName) + ", " + my_Item.getQuantity());
                }
            }
        }
    }

    public void display_pilots() {
        // sort by key
        List<String> pilotsByKey = new ArrayList<>(pilots.keySet());
        Collections.sort(pilotsByKey);
        // iterate
        for (String p : pilotsByKey) {
            Pilot each_pilot = new Pilot();
            String p_id = each_pilot.getPilotId();
            System.out.println("name: " + each_pilot.getPilotName(p_id)
                    + ",phone: " + each_pilot.getPilotPhone(p_id)
                    + ",taxID: " + each_pilot.getPilotTaxID(p_id)
                    + ",licenseID: " + each_pilot.getPilotLicenseID(p_id)
                    + ",experience: " + each_pilot.getNumDeliveredOrders(p_id)
            );

        }
        System.out.println("OK:display_completed");
    }


    public void display_drones(String storeName) {
        if (!stores.containsKey(storeName)) {
            System.out.println("ERROR: " + '"' + "store_identifier_does_not_exist" + '"');
        } else {
            for (Map.Entry<String, Drone> drone : drones.entrySet()) {
                String drone_storeName = drone.getKey();
                Drone my_drone = drone.getValue();

                if (drone_storeName == storeName) {
                    System.out.println("droneID: " + my_drone.getDroneID()
                                    + ",total_cap: " + my_drone.getWeightCapacity(my_drone.getDroneID())
//                        + ",num_orders: " +
//                        + ",remaining_cap: " +
                                    + ",trips_left: " + my_drone.getNumAvailableDeliveries(my_drone.getDroneID())
                    );
                }
            }
        }


    }
    public void display_customers() {
        // sort by key
        List<String> customersByKey = new ArrayList<>(customers.keySet());
        Collections.sort(customersByKey);
        // iterate
        for (String c : customersByKey) {
            Customer each_cust = new Customer();
            String c_id = each_cust.getCustID();
            System.out.println("name: " + each_cust.getName(each_cust.getFirstName(c_id),each_cust.getLastName(c_id))
                    + ",phone: " + each_cust.getCustPhone(c_id)
                    + ",rating: " + each_cust.getCustRating(c_id)
                    + ",credit: " + each_cust.getCustCredits(c_id)
            );

        }
        System.out.println("OK:display_completed");
    }
    public void display_orders(String storeName) {
        if (!stores.containsKey(storeName)) {
            System.out.println("ERROR: " + '"' + "store_identifier_does_not_exist" + '"');
        } else {
            // sort by key
            List<String> ordersByKey = new ArrayList<>(orders.keySet());
            Collections.sort(ordersByKey);
            // iterate
            for (String s : ordersByKey) {
                Order each_order = new Order();
                System.out.println("orderID:" + each_order.getOrderID());
            }
        }
    }

}
