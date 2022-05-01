package onlinefoodorderingsystem;
import java.util.ArrayList;


public interface Feedback_Detector {

	public Feedback_Detector Next_In_Chain;
        ArrayList<Feedback> Feedback_History = new ArrayList<Feedback>();

	/**
	 * 
	 * @param f
	 */
	public void Handle_Feedback(Feedback f);

	public void setters();

	/*public getters();*/

}