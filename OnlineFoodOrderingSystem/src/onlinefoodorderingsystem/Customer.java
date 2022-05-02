package onlinefoodorderingsystem;
import java.util.ArrayList;


public class Customer extends Person implements New_Rests_Observer {

	private ArrayList<Order> Orders_History;
	public Feedback m_Feedback;
	public Order m_Order;
	public SysRests_Interface m_SysRests;

	public Customer(){

	}

	public void Sign_Up(String Username, String Pwd){

	}


	public Customer Login(String Username, String Pwd){
		return null;
	}


	public void Manage_Account(Customer acc){

	}


	public void Create_Feedback(int Order_Id){

	}

	public void Create_Order(){

	}


	public void Cancel_Order(Order o){

	}


	public void Reorder(Order o){

	}


	public void View_Order_Details(Order o){

	}

	public ArrayList<Order> getOrders_History(){
		return null;
	}

	public void View_Notifications(){

	}


	public void Update(String msg){

	}

}