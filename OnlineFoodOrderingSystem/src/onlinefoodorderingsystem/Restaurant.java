package onlinefoodorderingsystem;
import java.util.ArrayList;


/**
 * @author LENOVO
 * @version 1.0
 * @updated 01-May-2022 16:47:12
 */
public class Restaurant {

	private int Rest_Id;
	private ArrayList<Order> Rest_Incoming_Orders;
	private ArrayList<Order> Rest_Accepted_Orders_History;
	private String Rest_Location;
	private String Rest_Categ;
	private String Rest_Name;
	private boolean Rest_Open;
	private Menu  Rest_Menu;
	private double Rest_Rating;
	public Menu  m_Menu ;
	public Restaurant_Admin m_Restaurant_Admin;

	public Restaurant(){

	}

	public void finalize() throws Throwable {

	}
	public void View_Menu(){

	}

	/**
	 * 
	 * @param o
	 */
	public void Accept_Order(Order o){

	}

	/**
	 * 
	 * @param f
	 */
	public void Handle_Feedback(Feedback f){

	}

	public void setters(){

	}
}//end Restaurant