/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinefoodorderingsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author mostafa gado
 */
public class DB_Connection_Maiada {
  private final String userName = "root";
    private final String password = "";
    private final String dbName = "food_ordering_system";

    private Connection con;

     public DB_Connection_Maiada(){
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
                    + "VALUES ('" + ra.getUsername()+ "', '" + ra.getPassword() + "')");
            this.addRest(ra.getRestaurant());
            System.out.println("Restaurant Admin added");
        } catch (Exception e) {
            System.err.println("RESTAURANT ADMIN INSERTION ERROR: " + e.toString());
        }
    }
     
    public void addRest(Restaurant rest) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from students where name = '" + name + "'");
            if (rs.first()) {
                return new Student(rs.getString("name"), rs.getDouble("gpa"));
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO restaurant (`Name`)"
                    + "VALUES ('" + ra.getRestaurant().getRest_Name() + "')");
            System.out.println("Restaurant added");
        } catch (Exception e) {
            System.err.println("RESTAURANT INSERTION ERROR: " + e.toString());
        }
    }
}
