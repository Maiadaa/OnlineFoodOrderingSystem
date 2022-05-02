package onlinefoodorderingsystem;
import java.util.ArrayList;


public class Manager extends Admin {

	private static Manager theSuperAdmin;
	
        private ArrayList<Restaurant_Admin> Rest_Admins;
	public FoodOrderingSysRests sysRests;

	private Manager(){
            theSuperAdmin.setID(203398);
            theSuperAdmin.setUsername("manager");
            theSuperAdmin.setPassword("m1234");
            theSuperAdmin.setName("Maiada");
            theSuperAdmin.setGender('F');
            theSuperAdmin.setEmail("mai@gmail.com");
            theSuperAdmin.setPhone_number("01010101010");
            theSuperAdmin.setAddress("Rehab");
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