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


	public void Add_Rest_Admin(Restaurant_Admin ra){
            /* test:
            Restaurant_Admin ra = new Restaurant_Admin();
            ra.setUsername("Hardees");
            ra.setPassword("hardees1234");
            */
            sysRestsAdmins.Add_Rest_Admin(ra);
            sysRests.Add_Rest(ra.getRest());
	}


	public boolean Remove_Rest_Admin(Restaurant_Admin ra){
            if(sysRestsAdmins.Remove_Rest_Admin(ra)){
                 sysRests.Remove_Rest(ra.getRest());
                 return true;
            }
            return false;
	}
        
}


