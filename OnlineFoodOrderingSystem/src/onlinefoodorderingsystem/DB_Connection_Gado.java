/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinefoodorderingsystem;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author mostafa gado
 */
public class DB_Connection_Gado {
     private final String userName = "root";
    private final String password = "";
    private final String dbName = "food_ordering_system";

    private Connection con;

//     public DB_Connection_Gado(){
//        try {
//            //Loading the jdbc driver
//            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//            //Get a connection to database
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
//        } catch (Exception e) {
//            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
//        }
//    }
     
      public static Connection getConnection(){
     
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/food_ordering_system", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
    
}
