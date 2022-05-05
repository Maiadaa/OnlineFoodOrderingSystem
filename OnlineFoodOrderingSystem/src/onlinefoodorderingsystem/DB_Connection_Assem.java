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
public class DB_Connection_Assem 
{
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
        } catch (Exception e) 
        {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
        }
    }
     public static Connection getConnection() 
     {

        Connection con = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/food_ordering_system", "root", "");
        } catch (Exception ex) 
        {
            System.out.println(ex.getMessage());
        }

        return con;
    }
    public void CreateValidCoupon(Coupon c)
    {
        try 
        {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO coupon(Coupon_code, Coupon_desc, Expiry_date) values('" + c.getCoupon_Code() + "',' " + c.getCoupon_Desc() + "', '" + c.getCoupon_ExpiryDate() + "')");
            System.out.println("Coupon Added");
        } catch (Exception e) 
        {
            System.err.println("DATABASE COUPON INSERTION ERROR: " + e.toString());
        }
    }
     public JTable displayCoupons(JTable tbl) 
     {
        try 
        {
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
            stmt.executeUpdate("DELETE FROM `coupon` WHERE Coupon_code = '" +code+ "'");
            System.out.println("Coupon Added");
        } catch (Exception e) 
        {
            System.err.println("DATABASE COUPON DELETION ERROR: " + e.toString());
            JOptionPane.showMessageDialog(null, "Invalid Coupon Code, please insert a valid one");
        }
    }
 
    public void UpdateCoupon(int code , Coupon c)
    {
         try 
        {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `coupon` SET `Coupon_code`='" + c.getCoupon_Code() + "',`Coupon_desc`='" + c.getCoupon_Desc() + "',`Expiry_date`='" + c.getCoupon_ExpiryDate() + "',`discountVal`='" + c.getCoupon_Discount_Val() + "'");
            System.out.println("Coupon Updated");
        } catch (Exception e) 
        {
            System.err.println("DATABASE COUPON UPDATE ERROR: " + e.toString());
            JOptionPane.showMessageDialog(null, "Invalid Coupon Code, please insert a valid one");
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
                result.add(new Coupon(rs.getInt("Coupon_code"),rs.getString("Coupon_desc"),rs.getString("Expiry_date"),rs.getInt("discountVal")));
            }
            System.out.println("Coupons Read");
            
        } catch (Exception e) 
        {
            System.err.println("DATABASE COUPON RETRIVAL QUERY ERROR: " + e.toString());
        }
        return result; 
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
    public boolean ValidateCouponUpdate(int code)
    {
        ArrayList<Coupon> array = new ArrayList<Coupon>();
        array = getAllCoupons();
        for(int i = 0 ; i<array.size();i++)
        {
            System.out.println(array.get(i).getCoupon_Code());
            if(array.get(i).getCoupon_Code() == code)
            {
                System.out.println("Coupon found successfully");
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;   
    }
}
