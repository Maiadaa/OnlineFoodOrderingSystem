package onlinefoodorderingsystem;
import java.util.ArrayList;


public class Premium_Customer extends Customer implements Coupon_Observer {

	public FoodOrderingSysCoupons m_FoodOrderingSysCoupons;

	public Premium_Customer(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public void View_Offers(){

	}

	/**
	 * 
	 * @param msg
	 */
	public void Update(String msg){

	}

	public ArrayList<String> getCoupon_Notifs(){
		return null;
	}
}//end Premium_Customer