package onlinefoodorderingsystem;
import java.util.ArrayList;


public interface Feedback_Detector 
{
        //public Feedback_Detector  Next_In_Chain;
        public ArrayList<Feedback> Feedback_History = new ArrayList<Feedback>();
        
	public void Handle_Feedback(Feedback f);
}