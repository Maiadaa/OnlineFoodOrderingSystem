package onlinefoodorderingsystem;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Credit_Card implements Payment_Method {

	public Credit_Card(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param amt
	 */
	public void pay(double amt){
            JOptionPane.showMessageDialog(null, "You paied using credit card");
	}
}//end Credit_Card