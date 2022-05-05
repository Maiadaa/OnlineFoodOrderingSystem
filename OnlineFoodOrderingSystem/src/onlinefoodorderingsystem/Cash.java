package onlinefoodorderingsystem;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Cash implements Payment_Method {

	public Cash(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param amt
	 */
	public void pay(double amt){
            JOptionPane.showMessageDialog(null, "You are going to pay by cash");
	}
}//end Cash