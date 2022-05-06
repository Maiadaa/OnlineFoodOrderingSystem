package onlinefoodorderingsystem;
import java.util.ArrayList;
import javax.swing.JTable;


public class Premium_Customer extends Customer implements Coupon_Observer {

    public FoodOrderingSysCoupons m_FoodOrderingSysCoupons;    
    DB_Connection_Assem db = new DB_Connection_Assem();

	public Premium_Customer(){

	}

    public Premium_Customer(int ID, String Name, String Email, String Phone_number, String Address, String Username, String Password, char Gender)
    {
        super(ID, Name, Email, Phone_number, Address, Username, Password, Gender);
    }
        

	/*public JTable View_Offers(JTable tbl){
            //return db.viewCoupons(tbl);
	}*/

	public void Update(String msg)
        {
            db.insertCouponNotification(msg);
	}

	public ArrayList<String> getCoupon_Notifs(){
		return Coupon_Notifs;
	}
}//end Premium_Customer