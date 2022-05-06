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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mostafa gado
 */
public class DB_Connection_Gado {

    private final String userName = "root";
    private final String password = "";
    private final String dbName = "food_ordering_system";

    private Connection con;

     public DB_Connection_Gado(){
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

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/food_ordering_system", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return conn;
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
        } catch (Exception e) {
            System.err.println("DATABASE Menu item ADDITION ERROR: " + e.toString());
        }
    }
    
    public void removeMenuItem(int id){
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from menu_item where MenuItem_ID = '" + id + "'");
            JOptionPane.showMessageDialog(null, "Menu item is deleted");
            
            
        } catch (Exception e) {
            System.err.println("DATABASE Menu item DELETION ERROR: " + e.toString());
        }
    }

    
//    public void viewMenuItem (int id){
//        PreparedStatement ps;
//        
//        
//        String query = "SELECT * FROM `menu_item` WHERE id = id";
//        
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            
//            while(rs.next()){
//                String ID = String.valueOf(rs.getInt("id"));
//                String name = rs.getString("Item_Name");
//                String desc = rs.getString("Item_Desc");
//                String categ = rs.getString("Item_Categ");
//                String price = rs.getString("Item_Price");
//                String avail = rs.getString("Item_Avail");
//                
//                String menuData[] = {ID,name,desc,categ,price,avail};
////                DefaultTableModel tblModel = {DefaultTable}
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DB_Connection_Gado.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    
    public void updateData(String phone, String address, String user, String password, int id){
        String sql = "UPDATE `customer` SET `Phone`= '"+phone+"',`Address`='"+address+"',`Username`='"+user+"',`Password`= '"+password+"'WHERE ID = '"+id+"'";
          PreparedStatement ps;
        try {
            ps = DB_Connection_Gado.getConnection().prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "User updated");
        } catch (Exception e) {
            System.err.println("DATABASE USER DATA Update ERROR: " + e.toString());
        }
    }
    
    public JTable displayMenuItems(JTable tbl, int rest) {
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `Item_Name`, `Item_Desc`, `Item_Categ`, `Item_Price` FROM `menu_item`  WHERE Rest_ID = '"+rest+"'   ");

            DefaultTableModel model;
            model = (DefaultTableModel) tbl.getModel();
            Object rowData[] = new Object[4];

            while (rs.next()) {
                rowData[0] = rs.getString("Item_Name");
                rowData[1] = rs.getString("Item_Desc");
                rowData[2] = rs.getString("Item_Categ");
                rowData[3] = rs.getString("Item_Price");
                
                model.addRow(rowData);
            }
        } catch (Exception e) {
            System.err.println("DATABASE DISPLAY CART ITEMS QUERY ERROR: " + e.toString());
        }
        return tbl;
    }
    
    public JTable displayRestuarant (JTable tbl) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `Rest_ID`,`Rest_Loc`, `Rest_Categ`, `Rest_Name`, `Rest_Rating` FROM `restaurant` ");

            DefaultTableModel model;
            model = (DefaultTableModel) tbl.getModel();
            Object rowData[] = new Object[5];

            while (rs.next()) {
                rowData[0] = rs.getString("Rest_Loc");
                rowData[1] = rs.getString("Rest_Categ");
                rowData[2] = rs.getString("Rest_Name");
                rowData[3] = rs.getString("Rest_Rating");
                rowData[4] = rs.getInt("Rest_ID");
                
                model.addRow(rowData);
            }
        } catch (Exception e) {
            System.err.println("DATABASE DISPLAY CART ITEMS QUERY ERROR: " + e.toString());
        }
        return tbl;
    }
    public ArrayList displayRestuarant2 () {
        ArrayList<Restaurant> rest = new ArrayList<Restaurant>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `restaurant` ");
            
            //int Rest_Id, String Rest_Location, String Rest_Categ, String Rest_Name, boolean Rest_Open
            while (rs.next()) {
                rest.add(new Restaurant(rs.getInt("Rest_ID"), rs.getString("Rest_Loc"),rs.getString("Rest_Categ"),  rs.getString("Rest_Name"),rs.getBoolean("Rest_Open"),rs.getDouble("Rest_Rating")));
            }
        } catch (Exception e) {
            System.err.println("DATABASE DISPLAY CART ITEMS QUERY ERROR: " + e.toString());
        }
        return rest;
    }
    
    public void customerSignUp(String Name, String Email, String PhoneNumber, String address, String userName, String password, String Gender){
        PreparedStatement ps;
        String query = "INSERT INTO `customer`( `Name`, `Email`, `Phone`, `Address`, `Username`, `Password`, `Gender`) VALUES (?,?,?,?,?,?,?)";

        try {
            ps = DB_Connection_Gado.getConnection().prepareStatement(query);
            ps.setString(1, Name);
            ps.setString(2, Email);
            ps.setString(3, PhoneNumber);
            ps.setString(4, address);
            ps.setString(5, userName);
            ps.setString(6, password);
            ps.setString(7, Gender);
            
            
            if(ps.executeUpdate()>0){
//                CustomerLogin.setVisible(true);
//                this.dispose(); 
                JOptionPane.showMessageDialog(null, "New User is added");
                
            }
        } catch (Exception e) {
            System.err.println("DATABASE CUSTOMER SIGNUP ERROR: " + e.toString());
        }
    }
}
