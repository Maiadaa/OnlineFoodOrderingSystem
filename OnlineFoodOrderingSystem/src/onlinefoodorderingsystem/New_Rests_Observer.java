package onlinefoodorderingsystem;
import java.util.ArrayList;


public interface New_Rests_Observer {

        ArrayList<String> NewRestsNotifs = new ArrayList<String>();

	/**
	 * 
	 * @param msg
	 */
	public void Update(String msg);

	/*public getters(){

	}*/

}