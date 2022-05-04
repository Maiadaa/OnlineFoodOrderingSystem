/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinefoodorderingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mostafa gado
 */
public class DB_Connection_Hagrass {
  private final String userName = "root";
    private final String password = "";
    private final String dbName = "food_ordering_system";

    private Connection con;

     public DB_Connection_Hagrass(){
        try {
            //Loading the jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Get a connection to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
        } catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
        }
    }   
     
    public ArrayList selectOrderHistory(int customer_ID){
        ArrayList<Order> orders = new ArrayList<Order> ();
        ArrayList<Order_Item> list = new ArrayList<Order>():
        try {
            Statement stmt = con.createStatement();
            ResultSet select_order = stmt.executeQuery("SELECT * FROM `order` WHERE Customer_ID = " + customer_ID);
            ResultSet select_restaurant = stmt.executeQuery("");
            while(select_order.next()){
                orders.add(new Order(select_order.getInt("Order_ID"), , Ordered_Items, userName, customer_ID, userName));
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return null;
    }
}
