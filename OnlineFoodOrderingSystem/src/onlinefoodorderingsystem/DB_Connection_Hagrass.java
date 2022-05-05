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

            stmt.executeUpdate("INSERT INTO feedback (`Customer_ID`, `Order_ID`, `Feedback_Date`, `Feedback_Type`, `Feedback_Desc`, `Feedback_State`, `Rate`) VALUES ('"+ customerID +"','" + feedback.getOrder_Id() + "','" + feedback.getFeedbackDate() +"','"+ feedback.getFeedback_Type() +"','"+ feedback.getFeedback_Desc() +"','"+ feedback.getFeedback_State() +"','"+ feedback.getRate() + "')");
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
            System.out.println("feedback Updated");
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
                //feedbacks.add(new Feedback(, , selectFeedbacks.getString("Feedback_Type"), selectFeedbacks.getString("Feedback_Desc"), selectFeedbacks.getString("Feedback_State"), selectFeedbacks.getInt("Order_ID")));
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
}
