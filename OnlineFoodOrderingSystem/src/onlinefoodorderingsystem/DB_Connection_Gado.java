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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    
    public void addMenuItem(int id,String name, String description, String category, double price,int availability){
        PreparedStatement ps;
        
        String query = "INSERT INTO `menu_item`(`Rest_ID`, `Item_Name`, `Item_Desc`, `Item_Categ`, `Item_Price`, `Item_Avail`) VALUES (?,?,?,?,?,?)";
        
        try {
            ps = DB_Connection_Gado.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setString(4, category);
            ps.setDouble(5, price);
            ps.setInt(6, availability);
            
            if(ps.executeUpdate()>=0){
                JOptionPane.showMessageDialog(null, "Menu item is added");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB_Connection_Gado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeMenuItem(int id){
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from menu_item where ID = '" + id + "'");
            System.out.println("Restaurant Admin deleted");
            
        } catch (Exception e) {
            System.err.println("DATABASE RESTAURANT ADMIN DELETION ERROR: " + e.toString());
        }
    }

    
    public void viewMenuItem (int id){
        PreparedStatement ps;
        
        
        String query = "SELECT * FROM `menu_item` WHERE id = id";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                String ID = String.valueOf(rs.getInt("id"));
                String name = rs.getString("Item_Name");
                String desc = rs.getString("Item_Desc");
                String categ = rs.getString("Item_Categ");
                String price = rs.getString("Item_Price");
                String avail = rs.getString("Item_Avail");
                
                String menuData[] = {ID,name,desc,categ,price,avail};
//                DefaultTableModel tblModel = {DefaultTable}
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB_Connection_Gado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void updateData(String phone, String address, String user, String password, int id ){
        String sql = "UPDATE `customer` SET `Phone`= '"+phone+"',`Address`='"+address+"',`Username`='"+user+"',`Password`= '"+password+"'WHERE id = '"+id+"'";
          PreparedStatement ps;
        try {
            ps = DB_Connection_Gado.getConnection().prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "User updated");
        } catch (SQLException ex) {
            Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
