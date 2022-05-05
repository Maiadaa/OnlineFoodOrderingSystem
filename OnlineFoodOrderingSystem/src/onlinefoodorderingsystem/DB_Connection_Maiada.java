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
public class DB_Connection_Maiada {

    private final String userName = "root";
    private final String password = "";
    private final String dbName = "food_ordering_system";

    private Connection con;

    public DB_Connection_Maiada() {
        try {
            //Loading the jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Get a connection to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
        } catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
        }
    }

    public void addRestAdmin(Restaurant_Admin ra) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO rest_admin (`Username`, `Password`)"
                    + "VALUES ('" + ra.getUsername() + "', '" + ra.getPassword() + "')");
            System.out.println("Restaurant Admin added");

            this.addRest(ra.getRest(), ra.getUsername());
        } catch (Exception e) {
            System.err.println("RESTAURANT ADMIN INSERTION ERROR: " + e.toString());
        }
    }

    public void addRest(Restaurant rest, String uname) {
        int id = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select ID from rest_admin where Username = '" + uname + "'");
            if (rs.first()) {
                id = rs.getInt("ID");
            }
        } catch (Exception e) {
            System.err.println("DATABASE ADD RESTAURANT QUERY ERROR: " + e.toString());
        }

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO restaurant (`Rest_Name`, `RestAdmin_ID`, `Rest_Loc`, `Rest_Categ`)"
                    + "VALUES ('" + rest.getRest_Name() + "', '" + id + "', '" + rest.getRest_Location() + "', '" + rest.getRest_Categ() + "')");
            System.out.println("Restaurant added");
        } catch (Exception e) {
            System.err.println("RESTAURANT INSERTION ERROR: " + e.toString());
        }
    }

    public ArrayList<Restaurant> getAllRests() {
        ArrayList<Restaurant> result = new ArrayList();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from restaurant");
            while (rs.next()) {
<<<<<<< HEAD
                result.add(new Restaurant(rs.getInt("Rest_ID"), rs.getString("Rest_Name"), rs.getInt("RestAdmin_ID")));
=======
                rowData[0] = rs.getInt("Rest_ID");
                rowData[1] = rs.getString("Rest_Name");
                rowData[2] = rs.getInt("ID");
                rowData[3] = rs.getString("Name");
                
                model.addRow(rowData);
>>>>>>> parent of 5fa5e76 (view notifications DONE)
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return result;
    }

<<<<<<< HEAD
    public int getRestAdminID(String restName) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select RestAdmin_ID from restaurant where Rest_Name = '" + restName + "'");
            while (rs.next()) {
                return rs.getInt("RestAdmin_ID");
            }
        } catch (Exception e) {
            System.err.println("DATABASE GET REST ADMIN ID QUERY ERROR: " + e.toString());
        }
        return 0;
    }
=======
>>>>>>> parent of 5fa5e76 (view notifications DONE)
    
    public void deleteRestAdmin(int id) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from rest_admin where ID = '" + id + "'");
            System.out.println("Restaurant Admin deleted");
            
        } catch (Exception e) {
            System.err.println("DATABASE RESTAURANT ADMIN DELETION ERROR: " + e.toString());
        }
    }

    public void deleteRest(String restName) {
        try {
            this.deleteRestAdmin(this.getRestAdminID(restName));
            
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from restaurant where Rest_Name = '" + restName + "'");
            System.out.println("Restaurant deleted");
            
        } catch (Exception e) {
            System.err.println("DATABASE RESTAURANT DELETION ERROR: " + e.toString());
        }
    }

}
