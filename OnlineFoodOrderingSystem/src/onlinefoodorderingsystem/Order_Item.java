package onlinefoodorderingsystem;
import java.util.ArrayList;


public class Order_Item {

	private Menu_Item Item;
	private int Item_Quantity;
	private double Item_Total_Price;

    public Order_Item(){

	}

    public Order_Item(Menu_Item Item, int Item_Quantity, double Item_Total_Price) {
        this.Item = Item;
        this.Item_Quantity = Item_Quantity;
        this.Item_Total_Price = Item_Total_Price;
    }

    public Menu_Item getItem() {
        return Item;
    }

    public int getItem_Quantity() {
        return Item_Quantity;
    }

    public double getItem_Total_Price() {
        return Item_Total_Price;
    }

    public void setItem(Menu_Item Item) {
        this.Item = Item;
    }

    public void setItem_Quantity(int Item_Quantity) {
        this.Item_Quantity = Item_Quantity;
    }

    public void setItem_Total_Price(double Item_Total_Price) {
        this.Item_Total_Price = Item_Total_Price;
    }
        
    

    public void finalize() throws Throwable {

	}

	/*public getters(){

	}*/
}//end Order_Item