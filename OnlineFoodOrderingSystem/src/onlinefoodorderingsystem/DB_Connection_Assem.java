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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mostafa gado
 */
public class DB_Connection_Assem {

    private final String userName = "root";
    private final String password = "";
    private final String dbName = "food_ordering_system";

    private Connection con;

    public DB_Connection_Assem() {
        try {
            //Loading the jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Get a connection to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
        } catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
        }
    }

    public static Connection getConnection() {

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/food_ordering_system", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return con;
    }

    public int Add_Observer(Customer c) {
        ArrayList<Premium_Customer> result = new ArrayList();
        result = getAllPremCustomers();
        try {
            for (int i = 0; i < result.size(); i++) {
                if (c.getUsername().equals(result.get(i).getUsername())) {
                    System.out.println("This customer is already premium");
                    return 0;
                }
            }
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO premium_customer(Name, Email, Phone  , Address , Username , Password, Gender) values('" + c.getName() + "',' " + c.getEmail() + "', '" + c.getPhone_number() + "', '" + c.getAddress() + "', '" + c.getUsername() + "', '" + c.getPassword() + "', '" + c.getGender() + "')");
            System.out.println("Customer added as a premium customer");
        } catch (Exception e) {
            System.err.println("DATABASE COUPON INSERTION ERROR: " + e.toString());
        }
        return 0;
    }

    public ArrayList<Premium_Customer> getAllPremCustomers() {
        ArrayList<Premium_Customer> result = new ArrayList();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from premium_customer");
            while (rs.next()) {
                result.add(new Premium_Customer(rs.getInt("ID"), rs.getString("Name"), rs.getString("Email"), rs.getString("Phone"), rs.getString("Address"), rs.getString("Username"), rs.getString("Password"), rs.getString("Gender").charAt(0)));
            }
        } catch (Exception e) {
            System.err.println("DATABASE PREMIUM CUSTOMERS RETRIVAL QUERY ERROR: " + e.toString());
        }
        return result;
    }

    public boolean checkForPremCustomer(String uname) {
        ArrayList<Premium_Customer> result = new ArrayList();
        result = getAllPremCustomers();
        for (int i = 0; i < result.size(); i++) {
            if (uname.equals(result.get(i).getUsername())) {
                System.out.println("Customer found as a premium customer");
                return true;
            }
        }
        return false;
    }

    public ArrayList<Order> getAllOrder() {
        ArrayList<Order> result = new ArrayList();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from order");
            while (rs.next()) {
                result.add(new Order(rs.getInt("Order_ID"), rs.getString("Order_Date"), rs.getDouble("Order_Price"), rs.getString("Order_Status")));
            }
        } catch (Exception e) {
            System.err.println("DATABASE ORDERS RETRIVAL QUERY ERROR: " + e.toString());
        }
        return result;
    }

    public void CreateValidCoupon(Coupon c) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO coupon(Coupon_code, Coupon_desc, Expiry_date, discountVal) values('" + c.getCoupon_Code() + "',' " + c.getCoupon_Desc() + "', '" + c.getCoupon_ExpiryDate() + "', '" + c.getCoupon_Discount_Val() + "')");
            System.out.println("Coupon Added");

        } catch (Exception e) {
            System.err.println("DATABASE COUPON INSERTION ERROR: " + e.toString());
        }
    }

    public JTable displayOrders(JTable tbl, Customer c) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `order` WHERE `Customer_ID` = '" + c.getID() + "'");

            DefaultTableModel model;
            model = (DefaultTableModel) tbl.getModel();
            Object rowData[] = new Object[7];

            while (rs.next()) {
                rowData[0] = rs.getInt("Order_ID");
                rowData[1] = rs.getInt("Customer_ID");
                rowData[2] = rs.getInt("Rest_ID");
                rowData[3] = rs.getString("Order_Date");
                rowData[4] = rs.getDouble("Order_Price");
                rowData[5] = rs.getString("Order_PayMethod");
                rowData[6] = rs.getString("Order_Status");

                model.addRow(rowData);
            }
        } catch (Exception e) {
            System.err.println("DATABASE DISPLAY ORDERS ERROR: " + e.toString());
        }
        return tbl;
    }

    public void insertCouponNotification(String desc) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO couponnotifications(msg) values('" + desc + "')");
            System.out.println("Notification Added Successfullyd");

        } catch (Exception e) {
            System.err.println("DATABASE COUPON INSERTION ERROR: " + e.toString());
        }
    }
        public ArrayList<Coupon> getAllCoupons() 
    {
        ArrayList<Coupon> result = new ArrayList();
        try 
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from coupon");
            while (rs.next()) 
            {
                result.add(new Coupon(rs.getInt("Coupon_code"), rs.getString("Coupon_desc"), rs.getString("Expiry_date"), rs.getInt("discountVal")));
            }
            System.out.println(result.toString());

        } catch (Exception e) 
        {
            System.err.println("DATABASE COUPON RETRIVAL QUERY ERROR: " + e.toString());
        }
        return result;
    }
    public JTable displayCouponMsgs(JTable tbl) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT msg FROM couponnotifications");

            DefaultTableModel model;
            model = (DefaultTableModel) tbl.getModel();
            Object rowData[] = new Object[1];

            while (rs.next()) {
                rowData[0] = rs.getString("msg");

                model.addRow(rowData);
            }
        } catch (Exception e) {
            System.err.println("DATABASE DISPLAY COUPONS ERROR: " + e.toString());
        }
        return tbl;
    }

    public JTable displayCoupons(JTable tbl) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from coupon");

            DefaultTableModel model;
            model = (DefaultTableModel) tbl.getModel();
            Object rowData[] = new Object[5];

            while (rs.next()) {
                rowData[0] = rs.getInt("Coupon_ID");
                rowData[1] = rs.getString("Coupon_code");
                rowData[2] = rs.getString("Coupon_desc");
                rowData[3] = rs.getString("Expiry_date");
                rowData[4] = rs.getInt("discountVal");

                model.addRow(rowData);
            }
        } catch (Exception e) {
            System.err.println("DATABASE DISPLAY COUPONS ERROR: " + e.toString());
        }
        return tbl;
    }

    public void DeleteCoupon(int code) 
    {
                try 
                {
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate("DELETE FROM `coupon` WHERE Coupon_code =" + code);
                    System.out.println("Coupon Deleted Successfullyyyyy");
                    JOptionPane.showMessageDialog(null, "Coupon Deleted Successfullyyyyyyy");
                } 
                catch (Exception e) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Coupon Code, please insert a valid one");  
                    System.err.println("DATABASE COUPON DELETION ERROR: " + e.toString());
                }
    }
  

    public void UpdateCoupon(int code, Coupon c) {
        try 
        {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `coupon` SET `Coupon_code`='" + c.getCoupon_Code() + "',`Coupon_desc`='" + c.getCoupon_Desc() + "',`Expiry_date`='" + c.getCoupon_ExpiryDate() + "',`discountVal`='" + c.getCoupon_Discount_Val() + "' WHERE `Coupon_code` ='" + c.getCoupon_Code() + "' ");
            System.out.println("Coupon Updated");
        } 
        catch (Exception e) 
        {
            System.err.println("DATABASE COUPON UPDATE ERROR: " + e.toString());
            JOptionPane.showMessageDialog(null, "Invalid Coupon Code, please insert a valid one");
        }
    }

    

    public ArrayList<Admin> getAllAdmins() {
        ArrayList<Admin> result = new ArrayList();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from admin");
            while (rs.next()) 
            {
                result.add(new Admin(rs.getInt("ID"), rs.getString("Name"), rs.getString("Email"), rs.getString("Phone"), rs.getString("Address"), rs.getString("Username"), rs.getString("Password"), rs.getString("Gender").charAt(0)));
            }
        } catch (Exception e) 
        {
            System.err.println("DATABASE ADMIN RETRIVAL QUERY ERROR: " + e.toString());
        }
        return result;
    }

    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> result = new ArrayList();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer");
            while (rs.next()) 
            {
                result.add(new Customer(rs.getInt("ID"), rs.getString("Name"), rs.getString("Email"), rs.getString("Phone"), rs.getString("Address"), rs.getString("Username"), rs.getString("Password"), rs.getString("Gender").charAt(0)));
            }
        } catch (Exception e) 
        {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return result;
    }

    public ArrayList<Restaurant_Admin> getAllRestaurantAdmins() {
        ArrayList<Restaurant_Admin> result = new ArrayList();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from rest_admin");
            while (rs.next()) {
                result.add(new Restaurant_Admin(rs.getInt("ID"), rs.getString("Name"), rs.getString("Email"), rs.getString("Phone"), rs.getString("Address"), rs.getString("Username"), rs.getString("Password"), rs.getString("Gender").charAt(0)));
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return result;
    }

    public Restaurant_Admin RestaurantAdminLogin(String uname, String pw) {
        ArrayList<Restaurant_Admin> result = getAllRestaurantAdmins();
        for (int i = 0; i < result.size(); i++) {
            if (uname.equals(result.get(i).getUsername()) && pw.equals(result.get(i).getPassword())) {
                return result.get(i);
            }
        }
        return null;
    }

    public Customer CustomerLogin(String uname, String pw) {
        ArrayList<Customer> result = getAllCustomers();
        for (int i = 0; i < result.size(); i++) {
            if (uname.equals(result.get(i).getUsername()) && pw.equals(result.get(i).getPassword())) {
                return result.get(i);
            }
        }
        return null;
    }

    public Admin AdminLogin(String uname, String pw) {
        ArrayList<Admin> result = getAllAdmins();
        for (int i = 0; i < result.size(); i++) {
            if (uname.equals(result.get(i).getUsername()) && pw.equals(result.get(i).getPassword())) {
                return result.get(i);
            }
        }
        return null;

    }

    public boolean ValidateCouponUpdate(int code)
    {
        ArrayList<Coupon> array = new ArrayList<>();
        array = getAllCoupons();
        for (int i = 0; i <= array.size(); i++) 
        {
            if (array.get(i).getCoupon_Code() == code) 
            {
                System.out.println("Coupon found successfully");
                return true;
            } else 
            {
                return false;
            }
        }
        return false;
    }
}
