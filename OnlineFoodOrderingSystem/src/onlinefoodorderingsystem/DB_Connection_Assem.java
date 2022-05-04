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
public class DB_Connection_Assem {
    private final String userName = "root";
    private final String password = "";
    private final String dbName = "food_ordering_system";

    private Connection con;

     public DB_Connection_Assem(){
        try {
            //Loading the jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Get a connection to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
        } catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
        }
    }
    public void CreateValidCoupon(Coupon c)
    {
          try 
          {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO coupon(Coupon_code, Coupon_desc, Expiry_date) values('" + c.getCoupon_Code() + "', " + c.getCoupon_Desc() + "', " + c.getCoupon_ExpiryDate() + ")");
            System.out.println("Coupon added");
        } catch (Exception e) 
        {
            System.err.println("DATABASE COUPON INSERTION ERROR: " + e.toString());
        }
    }
    public ArrayList<Admin> getAllAdmins()
    {
        ArrayList<Admin> result = new ArrayList();
        try 
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from admin");
            while (rs.next()) 
            {
                result.add(new Admin(rs.getInt("ID"), rs.getString("Name"),rs.getString("Email"),rs.getString("Phone"),rs.getString("Address"),rs.getString("Username"),rs.getString("Password"),rs.getString("Gender").charAt(0)));
            }
        } catch (Exception e) 
        {
            System.err.println("DATABASE ADMIN RETRIVAL QUERY ERROR: " + e.toString());
        }
        return result;
    }
    
      public ArrayList<Customer> getAllCustomers()
    {
        ArrayList<Customer> result = new ArrayList();
        try 
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer");
            while (rs.next()) 
            {
                result.add(new Customer(rs.getInt("ID"), rs.getString("Name"),rs.getString("Email"),rs.getString("Phone"),rs.getString("Address"),rs.getString("Username"),rs.getString("Password"),rs.getString("Gender").charAt(0)));
            }
        } catch (Exception e) 
        {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return result;
    }
      
    public ArrayList<Restaurant_Admin> getAllRestaurantAdmins()
    {
         ArrayList<Restaurant_Admin> result = new ArrayList();
        try 
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from rest_admin");
            while (rs.next()) 
            {
                result.add(new Restaurant_Admin(rs.getInt("ID"), rs.getString("Name"),rs.getString("Email"),rs.getString("Phone"),rs.getString("Address"),rs.getString("Username"),rs.getString("Password"),rs.getString("Gender").charAt(0)));
            }
        } catch (Exception e) 
        {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return result;
    }
 
     public Restaurant_Admin RestaurantAdminLogin(String uname , String pw)
     {
        ArrayList<Restaurant_Admin> result = getAllRestaurantAdmins();
        for(int i = 0 ;i < result.size();i++)
        {
            if(uname.equals(result.get(i).getUsername()) && pw .equals(result.get(i).getPassword()))
            {
                return result.get(i);
            }
        }
    return null;
     }
      public Customer CustomerLogin(String uname , String pw)
     {
        ArrayList<Customer> result = getAllCustomers();
        for(int i = 0 ;i < result.size();i++)
        {
            if(uname.equals(result.get(i).getUsername()) && pw.equals(result.get(i).getPassword()))
            {
                return result.get(i);
            }
        }
    return null;
     }
       public Admin AdminLogin(String uname , String pw)
     {
        ArrayList<Admin> result = getAllAdmins();
        for(int i = 0 ;i < result.size();i++)
        {
            if(uname.equals(result.get(i).getUsername()) && pw .equals(result.get(i).getPassword()))
            {
                return result.get(i);
            }
        }
    return null;
     
     }
}
