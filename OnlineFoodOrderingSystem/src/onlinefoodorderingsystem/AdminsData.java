package onlinefoodorderingsystem;
import java.util.ArrayList;


public class AdminsData 
{

	private static ArrayList<Admin> sysAdmins = new ArrayList<Admin>();
        
	public AdminsData()
        {

	}

        public static ArrayList<Admin> getSysAdmins() 
        {
            return sysAdmins;
        }
	
	public void SignUp(Admin a)
        {
            sysAdmins.add(a);
            System.out.println("Admin added succsessfully");
	}
}