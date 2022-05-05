package onlinefoodorderingsystem;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Customer extends Person implements New_Rests_Observer {

	private ArrayList<Order> Orders_History;
	public Feedback m_Feedback;
	public Order m_Order;
	public SysRests_Interface m_SysRests ;
        public static CustomersData custdata = new CustomersData();
        
	public Customer(){

	}

    public Customer(int ID, String Name, String Email, String Phone_number, String Address, String Username, String Password, char Gender) 
    {
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
    
    

        

//	public void Sign_Up(Customer cust){
//            custdata.SignUp(this);
//            
//	}


	public Customer CustomerLogin(String Username, String Pwd)
        {
            for (Customer sysCust : CustomersData.getSysCusts()) 
            {
                if(sysCust.getUsername().equals(Username) && sysCust.getPassword().equals(Pwd))
                {
                    return sysCust;
                }
            }
		return null;
	}


	public void Manage_Account(Customer acc){
            
	}


	public void Create_Feedback(int customerID ,int Order_Id, Feedback feedback){
            DB_Connection_Hagrass db = new DB_Connection_Hagrass();
            db.createNewFeedback(customerID, Order_Id, feedback);
            
            feedback.getF_Type().Handle_Feedback(feedback);
            
	}

	public void Create_Order(){

	}


	public void Cancel_Order(Order o){

	}


	public void Reorder(Order o){

	}

	public ArrayList<Order> getOrders_History(){
		return null;
	}

	public void View_Notifications(){

	}


	public void Update(String msg){

	}

    @Override
    public ArrayList<String> getNewRestsNotifs() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}