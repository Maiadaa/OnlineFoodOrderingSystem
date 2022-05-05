package onlinefoodorderingsystem;
import java.util.ArrayList;


public interface New_Rests_Observer {

    /* --- implemented using newRestsNotif & Customer table in DATABASE 
        Where all customers in system are notified with inserted messages on addition of new restaurant --- */
    
        ArrayList<String> NewRestsNotifs = new ArrayList<String>();

	public void Update(String msg);
        
        public ArrayList<String> getNewRestsNotifs();



}