/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinefoodorderingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    public DB_Connection_Seif() {
        try {
            //Loading the jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Get a connection to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
        } catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
        }
    }

    public void Add_To_Cart(Order_Item item, Order o) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO `order_item`(`Order_ID`, `MenuItem_ID`, `Quantity`, `Total_ItemPrice`) VALUES('" + o.getOrder_Id() + "', '" + item.getItem().getItem_Id() + "', '1', '" + item.getItem_Total_Price() + "')");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }

    public void Modify_Cart_Item(int id, int amount, int sum) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `order_item` SET `Quantity`='" + amount + "',`Total_ItemPrice`='" + sum + "' where MenuItem_ID = " + id + "");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }

    public Order_Item getMenuITemObjByName(String name) {
        Order_Item item = new Order_Item();
        int menuItemID = 0;
        double menuItemPrice = 0.0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from `menu_item` where Item_Name  = '" + name + "'");
            if (rs.first()) {
                menuItemID = rs.getInt("MenuItem_ID");
                menuItemPrice = rs.getDouble("Item_Price");
                item.getItem().setItem_Id(menuItemID);
                item.setItem_Total_Price(menuItemPrice);
                 return item;
            }
        } catch (Exception e) {
            System.err.println("DATABASE GET REST BY NAME QUERY ERROR: " + e.toString());
        }

       return null;
    }

    public void Remove_From_Cart(int id) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from order_item where OrderItem_ID = '" + id + "'");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }

    public void Cancel_Order(int id) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM `order` WHERE  Order_ID = '" + id + "'");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }

    public void Checkout(Order o) {
        try {
            Statement stmt = con.createStatement();
            String res = "";
            if (o.getM_Payment_Method() instanceof Cash) {
                res = "cash";
            } else {
                res = "credit";
            }
            stmt.executeUpdate("UPDATE `order` SET `Order_Price`='" + o.getOrder_Price() + "',`Order_PayMethod`='" + res + "', Order_status = '" + o.getOrderstatus() + "' where Order_ID = '" + o.getOrder_Id() + "'");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }

    public Coupon Redeem_Coupon(Customer c, int code) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select discountVal, premiumcust_coupon.Coupon_ID, Coupon_code from premiumcust_coupon, coupon where premiumcust_coupon.Premium_Cust_ID = '" + c.getID() + "' and coupon.Coupon_code = '" + code + "' and premiumcust_coupon.Coupon_ID = coupon.Coupon_ID");
            if (rs.first()) { //is premium cust
                return (new Coupon(rs.getInt("Coupon_ID"), rs.getInt("discountVal"))); //sa7
            }
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
        return null;
    }

    public JTable displayCartItems(JTable tbl, Order o) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select `Quantity`, `Total_ItemPrice`,`Item_Name`,`order_item`.`MenuItem_ID` from order_item , menu_item where order_item.MenuItem_ID = menu_item.MenuItem_ID and Order_ID = '" + o.getOrder_Id() + "'");

            DefaultTableModel model;
            model = (DefaultTableModel) tbl.getModel();
            Object rowData[] = new Object[4];

            while (rs.next()) {
                rowData[0] = rs.getInt("MenuItem_ID");
                rowData[1] = rs.getString("Item_Name");
                rowData[2] = rs.getInt("Quantity");
                rowData[3] = rs.getInt("Total_ItemPrice");

                model.addRow(rowData);
            }
        } catch (Exception e) {
            System.err.println("DATABASE DISPLAY CART ITEMS QUERY ERROR: " + e.toString());
        }
        return tbl;
    }

    /*
    public JTable viewOrderHistory(JTable jTable1) {
        try {
            String add = this.getAddress();
            ResultSet rs = null;

            String sql2 = "SELECT * FROM ORDERDETAILS";
            rs = stcat.executeQuery(sql2);

            DefaultTableModel model;
            model = (DefaultTableModel) jTable1.getModel();
            Object rowData[] = new Object[4];

            while (rs.next()) {
                rowData[0] = rs.getInt("PROD_ID");
                rowData[1] = rs.getDouble("PRICE");
                rowData[2] = rs.getString("STATUS");
                rowData[3] = add;

                model.addRow(rowData);
            }
            rs.close();
            stcat.close();
            conncat.close();

        } catch (SQLException ex) {
            System.out.println("werrrrrrrrrr");
        }

        return jTable1;
    }
 
     */
}
