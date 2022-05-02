package onlinefoodorderingsystem;
import java.util.ArrayList;


public class Menu_Item {

	private int Item_Id;
	private String Item_Name;
	private String Item_Desc;
	private String Item_Categ;
	private double Item_Price;
	private boolean Item_Availability;
	public Order_Item m_Order_Item;

	public Menu_Item(){

	}

        public Menu_Item(int Item_Id, String Item_Name, String Item_Desc, String Item_Categ, double Item_Price, boolean Item_Availability, Order_Item m_Order_Item) {
            this.Item_Id = Item_Id;
            this.Item_Name = Item_Name;
            this.Item_Desc = Item_Desc;
            this.Item_Categ = Item_Categ;
            this.Item_Price = Item_Price;
            this.Item_Availability = Item_Availability;
            this.m_Order_Item = m_Order_Item;
        }
        
	
        public void setItem_Id(int Item_Id) {
            this.Item_Id = Item_Id;
        }

        public void setItem_Name(String Item_Name) {
            this.Item_Name = Item_Name;
        }

        public void setItem_Desc(String Item_Desc) {
            this.Item_Desc = Item_Desc;
        }

        public void setItem_Categ(String Item_Categ) {
            this.Item_Categ = Item_Categ;
        }

        public void setItem_Price(double Item_Price) {
            this.Item_Price = Item_Price;
        }

        public void setItem_Availability(boolean Item_Availability) {
            this.Item_Availability = Item_Availability;
        }

        public void setM_Order_Item(Order_Item m_Order_Item) {
            this.m_Order_Item = m_Order_Item;
        }

        public int getItem_Id() {
            return Item_Id;
        }

        public String getItem_Name() {
            return Item_Name;
        }

        public String getItem_Desc() {
            return Item_Desc;
        }

        public String getItem_Categ() {
            return Item_Categ;
        }

        public double getItem_Price() {
            return Item_Price;
        }

        public boolean isItem_Availability() {
            return Item_Availability;
        }

        public Order_Item getM_Order_Item() {
            return m_Order_Item;
        }
        
        
}//end Menu_Item