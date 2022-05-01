package onlinefoodorderingsystem;
import java.util.ArrayList;


public class Order {

	private int Order_Id;
	private Restaurant Order_Rest;
	private ArrayList<Order_Item> Ordered_Items;
	private String Order_Date;
	private Coupon Order_Promo;
	private double Order_Price;
	private Status Order_status;
	public Order_Item m_Order_Item;
	public Payment_Method m_Payment_Method;
	public Status m_Status;

	public Order(){

	}

	public void finalize() throws Throwable {

	}
	public void View_Order_Details(){

	}

	/**
	 * 
	 * @param item
	 */
	public void Add_To_Cart(Order_Item item){

	}

	/**
	 * 
	 * @param item
	 */
	public boolean Remove_From_Cart(Order_Item item){
		return false;
	}

	/**
	 * 
	 * @param item
	 * @param new_quant
	 */
	public void Modify_Cart_Item(Order_Item item, int new_quant){

	}

	/**
	 * 
	 * @param c
	 */
	public void Redeem_Coupon(Coupon c){

	}

	public void Checkout(){

	}

	public void setters(){

	}

	/*public getters(){

	}*/
}//end Order