package onlinefoodorderingsystem;
import java.util.ArrayList;


public class Manager extends Admin {

	private static Manager theSuperAdmin;
	private ArrayList<Restaurant_Admin> Rest_Admins;
	public Manager m_Manager;
	public FoodOrderingSysRests m_FoodOrderingSysRests;
	public Restaurant_Admin m_Restaurant_Admin;



	public void finalize() throws Throwable {
		super.finalize();
	}
	private Manager(){

	}

	public static Manager getTheSuperAdmin(){
		return null;
	}

	/**
	 * 
	 * @param ra
	 */
	public void Add_Rest_Admin(Restaurant_Admin ra){

	}

	/**
	 * 
	 * @param ra
	 */
	public boolean Remove_Rest_Admin(Restaurant_Admin ra){
		return false;
	}
}//end Manager