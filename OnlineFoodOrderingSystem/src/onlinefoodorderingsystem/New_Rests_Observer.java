package onlinefoodorderingsystem;
import java.util.ArrayList;


public interface New_Rests_Observer {

        ArrayList<String> NewRestsNotifs = new ArrayList<String>();

	public void Update(String msg);
        
        public ArrayList<String> getNewRestsNotifs();



}