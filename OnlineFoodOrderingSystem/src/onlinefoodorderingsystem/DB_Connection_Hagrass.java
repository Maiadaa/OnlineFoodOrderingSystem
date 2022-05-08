 package onlinefoodorderingsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mostafa gado
 */
public class DB_Connection_Hagrass {
  private final String userName = "root";
    private final String password = "";
    private final String dbName = "food_ordering_system";

    private Connection con;

     public DB_Connection_Hagrass(){
        try {
            //Loading the jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Get a connection to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
        } catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
        }
    }   
    
    public void createNewFeedback(int customerID, int OrderID, Feedback feedback){
        System.out.println(feedback.getFeedbackDate());
        try {
            Statement stmt = con.createStatement();

            stmt.executeUpdate("INSERT INTO feedback (`Feedback_ID`,`Customer_ID`, `Order_ID`, `Feedback_Date`, `Feedback_Type`, `Feedback_Desc`, `Feedback_State`, `Rate`) VALUES ('"+ feedback.getFeedback_Id() +"','"+ customerID +"','" + feedback.getOrder_Id() + "','" + feedback.getFeedbackDate() +"','"+ feedback.getFeedback_Type() +"','"+ feedback.getFeedback_Desc() +"','"+ feedback.getFeedback_State() +"','"+ feedback.getRate() + "')");
            System.out.println("feedback added");
            //return true;
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
            //return false;
        }
    }
    
    public boolean Edit_Admin_Account(Admin admin){
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `admin` SET `Name`='" + admin.getName() + "',`Email`='" + admin.getEmail() + "',`Phone`='" + admin.getPhone_number() + "',`Address`='" + admin.getAddress() + "',`Username`='" + admin.getUsername() + "',`Password`='" + admin.getPassword() + "',`Gender`='" + admin.getGender() + "' where ID = " + admin.getID() + "");
            System.out.println("admin Updated");
            return true;
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
            return false;
        }
    }
    
    public JTable selectAllComplaintFeedback(JTable table){
        try {
            Statement stmt = con.createStatement();
            ResultSet selectFeedbacks = stmt.executeQuery("SELECT * FROM `feedback` Where Feedback_Type = 'complaint'");
            DefaultTableModel model;
            model = (DefaultTableModel) table.getModel();
            Object rowData[] = new Object[7];

            while (selectFeedbacks.next()) {
                rowData[0] = selectFeedbacks.getInt("Feedback_ID");
                rowData[1] = selectFeedbacks.getInt("Customer_ID");
                rowData[2] = selectFeedbacks.getInt("Order_ID");
                rowData[3] = selectFeedbacks.getString("Feedback_Date");
                rowData[4] = selectFeedbacks.getString("Feedback_Type");
                rowData[5] = selectFeedbacks.getString("Feedback_Desc");
                rowData[6] = selectFeedbacks.getString("Feedback_State");


                model.addRow(rowData);
            }

        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return table;
    }
    
    public Admin SelectAdminData(int AdminID){
         try {
            Statement stmt = con.createStatement();
            ResultSet selectData = stmt.executeQuery("SELECT * FROM `admin` WHERE ID = '" + AdminID + "'");
            if (selectData.first()) {
                return new Admin(selectData.getInt("ID"), selectData.getString("Name"), selectData.getString("Email"), selectData.getString("Phone"), selectData.getString("Address"), selectData.getString("Username"), selectData.getString("Password"), selectData.getString("Gender").charAt(0));
            }else{
                return null;
            }
            } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
            return null;
        }
    }
    
    public Restaurant_Admin SelectRestAdminData(int RestAdmin) {

        try {
            Statement stmt = con.createStatement();
            ResultSet selectData = stmt.executeQuery("SELECT * FROM `rest_admin` WHERE ID = '" + RestAdmin + "'");
            if (selectData.first()) {
                System.out.println("restadmin get");
                return new Restaurant_Admin(selectData.getInt("ID"), selectData.getString("Name"), selectData.getString("Email"), selectData.getString("Phone"), selectData.getString("Address"), selectData.getString("Username"), selectData.getString("Password"), selectData.getString("Gender").charAt(0));
            }else{
                return null;
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
            return null;
        }   
    }
    public boolean Edit_RestAdmin_Account(Restaurant_Admin restAdmin) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `rest_admin` SET `Name`='" + restAdmin.getName() + "',`Email`='" + restAdmin.getEmail() + "',`Phone`='" + restAdmin.getPhone_number() + "',`Address`='" + restAdmin.getAddress() + "',`Username`='" + restAdmin.getUsername() + "',`Password`='" + restAdmin.getPassword() + "',`Gender`='" + restAdmin.getGender() + "' where ID = " + restAdmin.getID() + "");
            System.out.println("rest admin Updated");
            return true;
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
            return false;
        }
    }
    
    public void EditFeedbackStatus(Feedback feedback){
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `feedback` SET `Feedback_State`='" + feedback.getFeedback_State() + "' WHERE Feedback_ID = '" + feedback.getFeedback_Id() + "'");
            System.out.println("feedback Updated");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }

    public int selectRestAdminID(int OrderID){
        try {
            Statement stmt = con.createStatement();
            ResultSet selectData = stmt.executeQuery("SELECT `RestAdmin_ID` FROM `restaurant`, `order` WHERE restaurant.Rest_ID = order.Rest_ID AND order.Order_ID = '" + OrderID + "'");
            if (selectData.first()) {
                System.out.println("select rest admin id");
                return selectData.getInt("RestAdmin_ID");
            }else {
                return 0;
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
            return 0;
        } 
    }
    
    public void editRestRating(int restID, double rate){
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `restaurant` SET `Rest_Rating`='" + rate + "' WHERE Rest_ID = ' " + restID + "'");
            System.out.println("restaurant Updated");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }
    
    public Restaurant selectRestaurant(int OrderID){
        try {
            Statement stmt = con.createStatement();
            ResultSet selectData = stmt.executeQuery("SELECT `restaurant`.`Rest_ID`, `restaurant`.`Rest_Rating` FROM `restaurant`, `order` WHERE restaurant.Rest_ID = order.Rest_ID AND order.Order_ID = '" + OrderID + "'");
            if (selectData.first()) {
                return new Restaurant(selectData.getInt("Rest_ID"), selectData.getDouble("Rest_Rating"));
            }else{
                return null;
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
            return null;
        }
    }
    
    public void create_Order(Customer cust,Order order){
         try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO `order`(`Order_ID`,`Customer_ID`, `Rest_ID`, `Order_Date`, `Order_status`) VALUES ('"+ order.getOrder_Id() + "','" + cust.getID() + "','" + order.getOrder_Rest().getRest_Id() + "','" + order.getOrder_Date() + "','" + order.getOrderstatus() + "')");
            System.out.println("Order Created");
            //return true;
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
            //return false;
        }
    }
    
    public int selectOrderID(){
        try {
            Statement stmt = con.createStatement();
            ResultSet selectData = stmt.executeQuery("SELECT * FROM `order` WHERE 1");
            if (selectData.last()) {
                return selectData.getInt("Order_ID");
            }else {
                return 0;
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
            return 0;
        }
    }
}
