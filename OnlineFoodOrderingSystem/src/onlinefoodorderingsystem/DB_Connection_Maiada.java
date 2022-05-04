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
                result.add(new Restaurant(rs.getInt("Rest_ID"), rs.getString("Rest_Name"), rs.getInt("RestAdmin_ID")));
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return result;
    }
    
}
