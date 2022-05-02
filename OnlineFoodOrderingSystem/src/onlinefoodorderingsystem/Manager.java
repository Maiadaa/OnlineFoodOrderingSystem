package onlinefoodorderingsystem;
import java.util.ArrayList;


public class Manager extends Admin {

	private static Manager theSuperAdmin;
	
        private ArrayList<Restaurant_Admin> Rest_Admins;
	public FoodOrderingSysRests sysRests;
	public Restaurant_Admin restAdmin;

	private Manager(){
            theSuperAdmin.setID(203398);
            theSuperAdmin.setUsername("manager");
            theSuperAdmin.setPassword("m1234");
            theSuperAdmin.setName("Maiada");
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