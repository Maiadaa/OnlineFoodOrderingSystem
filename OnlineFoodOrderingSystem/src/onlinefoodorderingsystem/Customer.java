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

        

	public void Sign_Up(String Username, String Pwd){

	}


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


	public void Create_Feedback(int Order_Id){
            for(int i = 0; i < Orders_History.size(); i++){
                System.out.println(Orders_History.get(i).toString());
            }
            int OrderID;
            Scanner Choice = new Scanner(System.in);
            System.out.println("Enter your order ID.");
            OrderID = Choice.nextInt();
            Order_Id = OrderID;
            m_Feedback = new Feedback();
            m_Feedback.setFeedback_Id(Order_Id+20);
            m_Feedback.setFeedback_Date(java.time.LocalDate.now());
            int choice = -1;
            Scanner feedbackTypeChoice = new Scanner(System.in);
            System.out.println("Enter Your feedback Type(Complaint or rating).");
            System.out.println("For complaint press 0.");
            System.out.println("For rating press 1.");
            choice = feedbackTypeChoice.nextInt();
            if(choice == 0){
                m_Feedback.setFeedback_Type("complaint");
            }else if(choice == 1){
                m_Feedback.setFeedback_Type("complaint");
            }
            String description;
            Scanner feedbackdesc = new Scanner(System.in);
            System.out.println("Enter Feedback description.");
            description = feedbackdesc.nextLine();
            m_Feedback.setFeedback_Desc(description);
            m_Feedback.setFeedback_State("Pending");
            m_Feedback.setOrder_Id(Order_Id);
            m_Feedback.getF_Type().Handle_Feedback(m_Feedback);
            if("pending".equals(m_Feedback.getFeedback_State())){
                System.out.println("Still handling it.");
            }else {
                System.out.println("done");
            }
	}

	public void Create_Order(){

	}


	public void Cancel_Order(Order o){

	}


	public void Reorder(Order o){

	}


	public void View_Order_Details(Order o){
            Order orders = new Order();
            orders.setOrder_Id(100);
            orders.setOrder_Price(200);
            orders.setOrder_Date("202132");
            Orders_History.add(orders);
            for(int i = 0; i < Orders_History.size(); i++){
                System.out.println(Orders_History.get(i).toString());
            }
            System.out.println("Select your order.");
            int choice;
            Scanner enterchoice = new Scanner(System.in);
            choice = enterchoice.nextInt();
            System.out.println("Your order ID is " + Orders_History.get(choice).getOrder_Id());
            System.out.println("Your order restaurant is " + Orders_History.get(choice).getOrder_Rest().getRest_Name());
            System.out.println("Your order date is " + Orders_History.get(choice).getOrder_Date());
            System.out.println("Your order coupon is " + Orders_History.get(choice).getOrder_Promo());
            System.out.println("Your order price is " + Orders_History.get(choice).getOrder_Price());
            for (int i = 0; i < Orders_History.get(choice).getOrdered_Items().size(); i++) {
                System.out.println("your order item number " + i + " is " + Orders_History.get(choice).getOrdered_Items().get(i));
            }
            System.out.println("Your order status is " + Orders_History.get(choice).getOrder_status());
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