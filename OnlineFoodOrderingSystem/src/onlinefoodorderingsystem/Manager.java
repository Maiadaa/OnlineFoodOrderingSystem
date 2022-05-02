package onlinefoodorderingsystem;
import java.util.ArrayList;


public class Manager extends Admin {

	private static Manager theSuperAdmin;
	
	public FoodOrderingSysRests sysRests;
        public RestAdminsData sysRestsAdmins;

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
            return theSuperAdmin;
	}


	public void Add_Rest_Admin(){
            Restaurant_Admin a = new Restaurant_Admin();
            a.setUsername("Hardees");
            a.setPassword("hardees1234");
            sysRestsAdmins.Add_Rest_Admin(a);
	}


	public boolean Remove_Rest_Admin(Restaurant_Admin ra){
            return sysRestsAdmins.Remove_Rest_Admin(ra);
	}
        
}


