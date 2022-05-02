package onlinefoodorderingsystem;
import java.util.ArrayList;

public class RestAdminsData {

	private static ArrayList<Restaurant_Admin> restAdmins;

	public RestAdminsData(){

	}

	public static void Add_Rest_Admin(Restaurant_Admin ra){
            restAdmins.add(ra);
	}

	public static boolean Remove_Rest_Admin(Restaurant_Admin ra){
            for(Restaurant_Admin RA : restAdmins){
                if(ra == RA){
                    restAdmins.remove(RA);
                    return true;
                }
            }
            return false;
	}

        public static ArrayList<Restaurant_Admin> getRestAdmins() {
            return restAdmins;
        }
        
        

}