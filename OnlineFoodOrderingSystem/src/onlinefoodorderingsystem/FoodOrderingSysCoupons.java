package onlinefoodorderingsystem;
import java.util.ArrayList;


public class FoodOrderingSysCoupons implements Premium_Coupon {

	private ArrayList<Coupon_Observer> Applicable_Custs;
	private ArrayList<Coupon> Coupons_Avail;
	public Coupon m_Coupon;

	public FoodOrderingSysCoupons(){

	}

	public void finalize() throws Throwable {

	}
	public void View_Coupons(){

	}

	/**
	 * 
	 * @param C
	 */
	public void Create_Coupon(Coupon C)
        {
            Coupons_Avail.add(C);
            System.out.println("Coupoun Added Successfully");

	}
	public void Remove_Coupon(int code)
        {
            for (int i =0; i < Coupons_Avail.size();i++)
            {
                if (Coupons_Avail.get(i).getCoupon_Code() == code)
                {
                    Coupons_Avail.remove(i);
                    System.out.println("Coupon Removed Successfully");
                }
            }
            System.out.println("Coupon code not found");
	}

	/**
	 * 
	 * @param C
	 * @param Cust_toChk
	 */
	public boolean Validate_Coupon(Coupon C, Customer Cust_toChk)
        {
		return false;
	}

	/**
	 * 
	 * @param subs
	 */
	public void Add_Observer(Coupon_Observer subs){

	}

	/**
	 * 
	 * @param subs
	 */
	public void Remove_Observer(Coupon_Observer subs){

	}

	/**
	 * 
	 * @param Notif_Msg
	 */
	public void Notify_All(String Notif_Msg){

	}
}//end FoodOrderingSysCoupons