package onlinefoodorderingsystem;
import java.util.ArrayList;


public interface New_Rests {

	public New_Rests_Observer restsObs ;
	/**
	 * 
	 * @param subs
	 */
	public void Add_RObserver(New_Rests_Observer subs);

	/**
	 * 
	 * @param subs
	 */
	public boolean Remove_RObserver(New_Rests_Observer subs);

	/**
	 * 
	 * @param notif_msg
	 */
	public void Notify_All(String notif_msg);

}