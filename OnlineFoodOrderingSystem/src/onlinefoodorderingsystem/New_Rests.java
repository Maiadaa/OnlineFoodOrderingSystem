package onlinefoodorderingsystem;
import java.util.ArrayList;


public interface New_Rests {

	public void Add_RObserver(New_Rests_Observer subs);

	public boolean Remove_RObserver(New_Rests_Observer subs);

	public void Notify_All(Restaurant rest);

}