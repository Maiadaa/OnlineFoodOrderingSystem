package onlinefoodorderingsystem;
import java.util.ArrayList;

public class Admin extends Person implements Feedback_Detector {

	public FoodOrderingSysCoupons m_FoodOrderingSysCoupons;
	public SysRests_Interface m_SysRests;

	public Admin(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param Username
	 * @param Pwd
	 */
	public Admin Login(String Username, String Pwd){
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