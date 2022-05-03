package onlinefoodorderingsystem;
import java.util.ArrayList;


public class Menu  {

	private ArrayList<Menu_Item> Items_In_Menu;
	public Menu_Item m_Menu_Item;

        public Menu(ArrayList<Menu_Item> Items_In_Menu, Menu_Item m_Menu_Item) {
            this.Items_In_Menu = Items_In_Menu;
            this.m_Menu_Item = m_Menu_Item;
            
        }

	
        public ArrayList<Menu_Item> getItems_In_Menu() {
            return Items_In_Menu;
        }

        

        public Menu_Item getM_Menu_Item() {
            return m_Menu_Item;
        }

        
        
	public void Add_Menu_Item(Menu_Item mi){
            
            Items_In_Menu.add(mi);
	}

	
	public boolean Remove_Menu_Item(Menu_Item mi){
            for (int i =0 ;i> Items_In_Menu.size();i++){
                if(Items_In_Menu.get(i).getItem_Id() == mi.getItem_Id()){
                    Items_In_Menu.remove(mi);
                    return true;
                }
            }
            return false;
	}

	
}//end Menu 