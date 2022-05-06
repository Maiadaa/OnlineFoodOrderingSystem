package onlinefoodorderingsystem;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.JTable;

public class Customer extends Person implements New_Rests_Observer {

    private ArrayList<Order> Orders_History;
    public Feedback m_Feedback;
    public Order m_Order;
    public SysRests_Interface m_SysRests;
    public static CustomersData custdata = new CustomersData();

    DB_Connection_Maiada db_mai = new DB_Connection_Maiada();

    public Customer() {

    }

    public Customer(int ID, String Name, String Email, String Phone_number, String Address, String Username, String Password, char Gender) {
        super(ID, Name, Email, Phone_number, Address, Username, Password, Gender);
        ID = ID;
        Name = Name;
        Email = Email;
        Phone_number = Phone_number;
        Address = Address;
        Username = Username;
        Password = Password;
        Gender = Gender;
    }

    public Customer(int ID) {
        super(ID);
    }

//	public void Sign_Up(Customer cust){
//            custdata.SignUp(this);
//            
//	}
    public Customer CustomerLogin(String Username, String Pwd) 
    {
        DB_Connection_Assem conn = new DB_Connection_Assem();
        return conn.CustomerLogin(Username, Pwd);
    }

    public void Manage_Account(String Name, String Email,String PhoneNumber, String address, String userName, String password,String Gender) {
        
        DB_Connection_Gado db = new DB_Connection_Gado();
        db.customerSignUp(Name, Email, PhoneNumber, address, userName, password, Gender);
    }

    public void Create_Feedback(int customerID, int Order_Id, Feedback feedback) {
        DB_Connection_Hagrass db = new DB_Connection_Hagrass();
        db.createNewFeedback(customerID, Order_Id, feedback);

        feedback.getF_Type().Handle_Feedback(feedback);

    }

    public void Create_Order(Order order) {
        DB_Connection_Hagrass db = new DB_Connection_Hagrass();
        db.create_Order(this.getID(), order);
    }

    public void Cancel_Order(Order o) {

    }

    public void Reorder(Order o) {

    }

    public ArrayList<Order> getOrders_History() {
        return null;
    }

    // --- USING ARRAY LISTS --- // 
    @Override
    public ArrayList<String> getNewRestsNotifs() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void Update(String msg) {

    }

    // --- THUS ALTERNATIVE IS USING DATABASE WITH THIS FUNCTION: --- //
    public JTable View_Notifications(JTable tbl) {
        return db_mai.displayNotifs(tbl, this);
    }

}
