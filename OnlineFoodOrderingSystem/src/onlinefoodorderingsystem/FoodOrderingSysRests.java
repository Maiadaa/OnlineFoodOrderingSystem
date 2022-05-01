package onlinefoodorderingsystem;
import java.util.ArrayList;

public class FoodOrderingSysRests implements SysRests_Interface, New_Rests {

	private ArrayList<New_Rests_Observer> Customers;
	private ArrayList<Restaurant> Rests_Avail;
	public SysRests_Interface m_SysRests;

	public FoodOrderingSysRests(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param rest
	 */
	public void Add_Rest(SysRests_Interface rest){

	}

	/**
	 * 
	 * @param rest
	 */
	public boolean Remove_Rest(Restaurant rest){
		return false;
	}

	public void Generate_Sales_Report(){

	}

	public void View_Sales_Report(){

	}

	public void getRests_Avail(){

	}

	/**
	 * 
	 * @param subs
	 */
	public void Add_RObserver(New_Rests_Observer subs){

	}

	/**
	 * 
	 * @param subs
	 */
	public void Remove_RObserver(New_Rests_Observer subs){

	}

	/**
	 * 
	 * @param notif_msg
	 */
	public void Notify_All(String notif_msg){

	}
}//end FoodOrderingSysRests