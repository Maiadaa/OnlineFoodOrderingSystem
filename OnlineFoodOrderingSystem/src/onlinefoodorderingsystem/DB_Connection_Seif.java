/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinefoodorderingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mostafa gado
 */
public class DB_Connection_Seif {
    private final String userName = "root";
    private final String password = "";
    private final String dbName = "food_ordering_system";

    private Connection con;

     public DB_Connection_Seif(){
        try {
            //Loading the jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Get a connection to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
        } catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
        }
    }
     
     public void Add_To_Cart(Order o){
        ArrayList <Order_Item> item = o.getOrdered_Items();
         for(int i =0;i<item.size();i++){
             try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into order_item values('" + item.get(i).getItem().getItem_Id() + "', " + item.get(i).getItem_Quantity() + "', " + item.get(i).getItem_Total_Price() + ")");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
         }
            
    }
     
     public void Modify_Cart_Item(Order_Item item){
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update order_item set Quantity ='" + item.getItem_Quantity() + "where OrderItem_ID ='" + item.getItem().getItem_Id() + ")");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
	}
     }
     
     public void Remove_From_Cart(Order o){
           ArrayList <Order_Item> item = o.getOrdered_Items();
            for(int i =0;i<item.size();i++){
             try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from order_item values('" + item.get(i).getItem().getItem_Id() + "', " + item.get(i).getItem_Quantity() + "', " + item.get(i).getItem_Total_Price() + ")");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
         }
    }
     
}
