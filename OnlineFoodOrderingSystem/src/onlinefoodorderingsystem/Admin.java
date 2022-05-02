package onlinefoodorderingsystem;
import java.util.ArrayList;

public class Admin extends Person implements Feedback_Detector {

	public FoodOrderingSysCoupons m_FoodOrderingSysCoupons;
	public SysRests_Interface m_SysRests;
        public static AdminsData adminData = new AdminsData();

    public Admin() {
    }

    public Admin(int ID, String Name, String Email, String Phone_number, String Address, String Username, String Password, char Gender)
    {
        super(ID, Name, Email, Phone_number, Address, Username, Password, Gender);
    }
        
	
	
	public Admin AdminLogin(String Username, String Pwd)
        {
            for (Admin sysAdmin : adminData.getSysAdmins()) 
            {
                if(sysAdmin.getUsername().equals(Username) && sysAdmin.getPassword().equals(Pwd))
                {
                    return sysAdmin;
                }
            }
		return null;
	}

	/**
	 * 
	 * @param acc
	 */
	public void Manage_Account(Admin acc){

	}

	public void View_Feedbacks(){

	}

	/**
	 * 
	 * @param f
	 */
	public void Handle_Feedback(Feedback f){

	}

	public void setters(){

	}
        
	/*public getters(){

	}*/

    /*@Override
    public void getters() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}//end Admin