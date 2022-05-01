package onlinefoodorderingsystem;
import java.util.ArrayList;


public class Customer extends Person implements New_Rests_Observer {

	private ArrayList<Order> Orders_History;
	public Feedback m_Feedback;
	public Order m_Order;
	public SysRests_Interface m_SysRests;

	public Customer(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param Username
	 * @param Pwd
	 */
	public void Sign_Up(String Username, String Pwd){

	}

	/**
	 * 
	 * @param Username
	 * @param Pwd
	 */
	public Customer Login(String Username, String Pwd){
		return null;
	}

	/**
	 * 
	 * @param acc
	 */
	public void Manage_Account(Customer acc){

	}

	/**
	 * 
	 * @param Order_Id
	 */
	public void Create_Feedback(int Order_Id){

	}

	public void Create_Order(){

	}

	/**
	 * 
	 * @param o
	 */
	public void Cancel_Order(Order o){

	}

	/**
	 * 
	 * @param o
	 */
	public void Reorder(Order o){

	}

	/**
	 * 
	 * @param o
	 */
	public void View_Order_Details(Order o){

	}

	public ArrayList<Order> getOrders_History(){
		return null;
	}

	public void View_Notifications(){

	}

	/**
	 * 
	 * @param msg
	 */
	public void Update(String msg){

	}

	/*public getters(){

	}*/
}//end Customer