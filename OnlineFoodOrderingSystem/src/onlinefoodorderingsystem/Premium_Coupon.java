package onlinefoodorderingsystem;
import java.util.ArrayList;


public interface Premium_Coupon {

	/**
	 * 
	 * @param subs
	 */
	public void Add_Observer(Coupon_Observer subs);

	/**
	 * 
	 * @param subs
	 */
	public void Remove_Observer(Coupon_Observer subs);

	/**
	 * 
	 * @param Notif_Msg
	 */
	public void Notify_All(String Notif_Msg);

}