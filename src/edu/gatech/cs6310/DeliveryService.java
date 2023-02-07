package edu.gatech.cs6310;
import java.util.*;

public class DeliveryService {


    public void commandLoop() {
        Scanner commandLineInput = new Scanner(System.in);
        String wholeInputLine;
        String[] tokens;

        /* Initiators */
        HashMap<String, Store> stores = new HashMap<String, Store>();  //storeName, Store()
        HashMap<String, Pilot> pilots = new HashMap<String, Pilot>(); //pilotId, Pilot()
        HashMap<String, Items> store_items = new HashMap<String, Items>();  //storeName, ItemName
        HashMap<String, Drone> drones = new HashMap<String, Drone>(); //storeName, Drone()
        HashMap<String, Customer> customers = new HashMap<String, Customer>(); //custID, Drone()
        HashMap<String, Order> orders = new HashMap<String, Order>(); //orderID, Order()

        Report reports = new Report();

        final String DELIMITER = ",";
        while (true) {
            try {
                // Determine the next command and echo it to the monitor for testing purposes
                wholeInputLine = commandLineInput.nextLine();
                System.out.println("> " + wholeInputLine);
                tokens = wholeInputLine.split(DELIMITER);
                /*
                [25] Comments: If the command is interpreted as a comment, i.e. the line begins with the comment
                indicator “//” your program should print out the comment line & continue to the next input line.
                 */
                if (wholeInputLine.startsWith("//")){
                    continue;
                }

                // 创建对象
                Store my_store = new Store();
                Items my_items = new Items();
                Pilot my_pilot = new Pilot();
                Drone my_drone = new Drone();
                Customer my_customer = new Customer();
                Order my_order = new Order();


                if (tokens[0].equals("make_store")) {
                    my_store.setStoreName(tokens[1]);
                    my_store.setRevenue(Integer.parseInt(tokens[2])) ;
                    /* Handle Error*/
                    if(stores.containsKey(tokens[1])) {
                        System.out.println("ERROR: "+'"'+"store_identifier_already_exists"+'"');
                    }
                    else{
                        /* add new store to stores*/
                        my_store.make_store(tokens[1], Integer.parseInt(tokens[2]));
                        stores.put(tokens[1],my_store);
                    }

                } else if (tokens[0].equals("display_stores")) {
                    reports.display_stores();

                } else if (tokens[0].equals("sell_item")) {
                    my_items.setStoreName(tokens[1]);
                    my_items.setItemName(tokens[2]);
                    my_items.setQuantity(Integer.parseInt(tokens[3]));
                    /* Handle Error*/
                    if(!stores.containsValue(tokens[1])) {
                        if (store_items.containsKey(tokens[1])) {
                            System.out.println("ERROR: " + '"' + "item_identifier_already_exists" + '"');
                        } else {
                            store_items.put(tokens[1],my_items); //storeName, Item()
                            my_items.sell_item(tokens[1], tokens[2],Integer.parseInt(tokens[3]));
                        }
                    } else {System.out.println("ERROR: "+'"'+"store_identifier_does_not_exist"+'"');}
                }

                 else if (!tokens[0].equals("display_items")) {
                    reports.display_stores();

                    System.out.println("store: " + tokens[1]);

                } else if (tokens[0].equals("make_pilot")) {
                    if (pilots.containsKey(tokens[1])){
                        System.out.println("ERROR: " + '"' + "pilot_identifier_already_exists" + '"');
                    }
                    else{
                        if(pilots.containsValue(tokens[6])){
                            System.out.println("ERROR: " + '"' + "pilot_license_already_exists" + '"');
                        }
                        my_pilot.make_pilot(tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6],Integer.valueOf(tokens[7]));
                        pilots.put(tokens[1],my_pilot);
                    }

                } else if (tokens[0].equals("display_pilots")) {
                    reports.display_pilots();

                } else if (tokens[0].equals("make_drone")) {
                    if (!stores.containsKey(tokens[1])){
                        System.out.println("ERROR: " + '"' + "store_identifier_does_not_exist" + '"');
                    }
                    else{
                        if(drones.containsKey(tokens[2])){
                            System.out.println("ERROR: " + '"' + "drone_identifier_already_exists" + '"');
                        }
                        my_drone.make_drone(tokens[1],tokens[2],Integer.valueOf(tokens[3]),Integer.valueOf(tokens[4]));
                        drones.put(my_drone.getDroneID(),my_drone);
                    }
//                    System.out.println("store: " + tokens[1] + ", drone: " + tokens[2] + ", capacity: " + tokens[3] + ", fuel: " + tokens[4]);

                } else if (tokens[0].equals("display_drones")) {
                    reports.display_drones(tokens[1]);

                } else if (tokens[0].equals("fly_drone")) {
//                    System.out.println("store: " + tokens[1] + ", drone: " + tokens[2] + ", pilot: " + tokens[3]);
                    if (!stores.containsKey(tokens[1])){
                        System.out.println("ERROR: " + '"' + "store_identifier_does_not_exist" + '"');
                    }
                    else{
                        if(!drones.containsKey(tokens[2])){
                            System.out.println("ERROR: " + '"' + "drone_identifier_does_not_exist" + '"');
                        } else{
                            if (!pilots.containsKey(tokens[3])){
                                System.out.println("ERROR: " + '"' + "pilot_identifier_does_not_exist" + '"');
                            }
                        }
                        my_drone.fly_drone(tokens[1],tokens[2],tokens[3]);
                        drones.replace(tokens[2],my_drone);
                    }

                } else if (tokens[0].equals("make_customer")) {
//                    System.out.print("account: " + tokens[1] + ", first_name: " + tokens[2] + ", last_name: " + tokens[3]);
//                    System.out.println(", phone: " + tokens[4] + ", rating: " + tokens[5] + ", credit: " + tokens[6]);
                    if (customers.containsKey(tokens[1])){
                        System.out.println("ERROR: " + '"' + "customer_identifier_already_exists" + '"');
                    }
                    else{
                        my_customer.make_customer(tokens[1], tokens[2], tokens[3],tokens[4],Integer.valueOf(tokens[5]), Integer.valueOf(tokens[6]));
                        customers.put(my_customer.getCustID(),my_customer);
                    }
                } else if (tokens[0].equals("display_customers")) {
                     reports.display_customers();

                } else if (tokens[0].equals("start_order")) {
//                    System.out.println("store: " + tokens[1] + ", order: " + tokens[2] + ", drone: " + tokens[3] + ", customer: " + tokens[4]);
                    if (!stores.containsKey(tokens[1])){
                        System.out.println("ERROR: " + '"' + "store_identifier_does_not_exist" + '"');
                    }
                    else {
                        if (orders.containsKey(tokens[2])) {
                            System.out.println("ERROR: " + '"' + "order_identifier_already_exists" + '"');
                        } else {
                            if (!drones.containsKey(tokens[3])){
                                System.out.println("ERROR: " + '"' + "drone_identifier_does_not_exist" + '"');
                            }
                            else {
                                if (!customers.containsKey(tokens[4])){
                                    System.out.println("ERROR: " + '"' + "customer_identifier_does_not_exist" + '"');
                                }else {
                                    my_order.start_order(tokens[1], tokens[2], tokens[3], tokens[4]);
                                    orders.put(my_order.getOrderID(), my_order);
                                }
                            }
                        }
                    }
                } else if (tokens[0].equals("display_orders")) {
//                    System.out.println("store: " + tokens[1]);
                    reports.display_orders(tokens[1]);

                } else if (tokens[0].equals("request_item")) {
//                    System.out.println("store: " + tokens[1] + ", order: " + tokens[2] + ", item: " + tokens[3] + ", quantity: " + tokens[4] + ", unit_price: " + tokens[5]);
                    if (!stores.containsKey(tokens[1])){
                        System.out.println("ERROR: " + '"' + "store_identifier_does_not_exist" + '"');
                    }
                    else {
                        if (!orders.containsKey(tokens[2])) {
                            System.out.println("ERROR: " + '"' + "order_identifier_does_not_exist" + '"');
                        } else {
                            if (!drones.containsKey(tokens[3])){
                                System.out.println("ERROR: " + '"' + "item_identifier_does_not_exist" + '"');
                            }
                            else {
//                                private Order new_o = new Order();
//                                private Items new_i = new Items();
//                                private String new_custID = new_o.getCustID(tokens[2]);

                                Integer unit_price = Integer.valueOf(tokens[5]);
                                Integer quantity = Integer.valueOf(tokens[4]);
                                String itemName = tokens[3];
                                String storeName = tokens[1];
                                String orderID = tokens[2];
                                Customer customer = new Customer();
                                Order order = new Order();
                                Drone drone = new Drone();
                                String droneID = order.getCustID(tokens[2]);
                                Integer customer_credits = customer.getCustCredits(order.getCustID(tokens[2]));
                                Integer drone_available_weight = drone.getWeightCapacity(droneID);



                                Integer order_total_cost = unit_price * quantity;
                                if (customer_credits < order_total_cost){
                                    System.out.println("ERROR: " + '"' + "customer_cant_afford_new_item" + '"');

                                }else {
                                    if (drone_available_weight< quantity){
                                        System.out.println("ERROR: " + '"' + "item_already_ordered" + '"');
                                    }else{
                                        if(false){
                                            System.out.println("ERROR: " + '"' + "drone_cant_carry_new_item" + '"');
                                        }else{

                                        }

                                    }
                                    my_order.start_order(tokens[1], tokens[2], tokens[3], tokens[4]);
                                    orders.put(my_order.getOrderID(), my_order);
                                }
                            }
                        }
                    }
                } else if (tokens[0].equals("purchase_order")) {
                    System.out.println("store: " + tokens[1] + ", order: " + tokens[2]);

                } else if (tokens[0].equals("cancel_order")) {
                    System.out.println("store: " + tokens[1] + ", order: " + tokens[2]);
                    if (!stores.containsKey(tokens[1])){
                        System.out.println("ERROR: " + '"' + "store_identifier_does_not_exist" + '"');
                    }
                    else {
                        if (!orders.containsKey(tokens[2])) {
                            System.out.println("ERROR: " + '"' + "order_identifier_does_not_exist" + '"');
                        } else {
                            orders.remove(tokens[2]);

                        }
                    }
                } else if (tokens[0].equals("stop")) {
                    /*
                    [24] The stop command must cause the (otherwise infinite) interactive loop to halt.
                     */
                    System.out.println("stop acknowledged");
                    break;

                } else {
                    System.out.println("command " + tokens[0] + " NOT acknowledged");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println();
            }
        }

        System.out.println("simulation terminated");
        commandLineInput.close();
    }
}
