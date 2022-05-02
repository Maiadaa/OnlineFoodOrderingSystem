package onlinefoodorderingsystem;
import java.util.ArrayList;


public class Premium_Customer extends Customer implements Coupon_Observer {

    public FoodOrderingSysCoupons m_FoodOrderingSysCoupons;

	public Premium_Customer(){

	}

	public void View_Offers(){

	}

	public void Update(String msg){
            
	}

	public ArrayList<String> getCoupon_Notifs(){
		return Coupon_Notifs;
	}
}//end Premium_Customer