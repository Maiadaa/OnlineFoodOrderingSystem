package onlinefoodorderingsystem;

import java.util.ArrayList;

/**
 * @author LENOVO
 * @version 1.0
 * @updated 01-May-2022 16:47:12
 */
public class Restaurant {

    private int Rest_Id;
    private ArrayList<Order> Rest_Incoming_Orders;
    private ArrayList<Order> Rest_Accepted_Orders_History;
    private String Rest_Location;
    private String Rest_Categ;
    private String Rest_Name;
    private boolean Rest_Open;
    private Menu Rest_Menu;
    private double Rest_Rating;
    
    // for db query purposes in Manager_RemoveRest_GUI
    private int restAdminID;

    public Restaurant() {

    }

    public Restaurant(int Rest_Id, String Rest_Location, String Rest_Categ, String Rest_Name, boolean Rest_Open) {
        this.Rest_Id = Rest_Id;
        this.Rest_Location = Rest_Location;
        this.Rest_Categ = Rest_Categ;
        this.Rest_Name = Rest_Name;
        this.Rest_Open = Rest_Open;
    }
    

    // For database query purposes in Manager_RemoveRest_GUI
    public Restaurant(int Rest_Id, String Rest_Name, int restAdminID) {
        this.Rest_Id = Rest_Id;
        this.Rest_Name = Rest_Name;
        this.restAdminID = restAdminID;
    }
    
    // For database query purposes in Cust_Notifications_GUI
    public Restaurant(int Rest_Id) {
        this.Rest_Id = Rest_Id;
    }    

    public void View_Menu() {
        for (int i = 0; i < Rest_Menu.getItems_In_Menu().size(); i++) {
            System.out.println(Rest_Menu.getItems_In_Menu().get(i));
        }
    }

    /**
     *
     * @param o
     */
    public void Accept_Order(Order o) {

        for (int i = 0; i < Rest_Incoming_Orders.size(); i++) {
            if (Rest_Incoming_Orders.get(i).getOrder_Id() == o.getOrder_Id()) {
                Rest_Accepted_Orders_History.add(o);
            }
        }
    }

    /**
     *
     * @param
     */
    public void Handle_Feedback(Feedback f) {
        //this.setRest_Rating(this.getRest_Rating() + f.getRating());

        // mehtag attribute f class feedback esmo rating double
    }

    public void setRest_Id(int Rest_Id) {
        this.Rest_Id = Rest_Id;
    }

    public void setRest_Incoming_Orders(ArrayList<Order> Rest_Incoming_Orders) {
        this.Rest_Incoming_Orders = Rest_Incoming_Orders;
    }

    public void setRest_Accepted_Orders_History(ArrayList<Order> Rest_Accepted_Orders_History) {
        this.Rest_Accepted_Orders_History = Rest_Accepted_Orders_History;
    }

    public void setRest_Location(String Rest_Location) {
        this.Rest_Location = Rest_Location;
    }

    public void setRest_Categ(String Rest_Categ) {
        this.Rest_Categ = Rest_Categ;
    }

    public void setRest_Name(String Rest_Name) {
        this.Rest_Name = Rest_Name;
    }

    public void setRest_Open(boolean Rest_Open) {
        this.Rest_Open = Rest_Open;
    }

    public void setRest_Menu(Menu Rest_Menu) {
        this.Rest_Menu = Rest_Menu;
    }

    public void setRest_Rating(double Rest_Rating) {
        this.Rest_Rating = Rest_Rating;
    }

    public int getRest_Id() {
        return Rest_Id;
    }

    public ArrayList<Order> getRest_Incoming_Orders() {
        return Rest_Incoming_Orders;
    }

    public ArrayList<Order> getRest_Accepted_Orders_History() {
        return Rest_Accepted_Orders_History;
    }

    public String getRest_Location() {
        return Rest_Location;
    }

    public String getRest_Categ() {
        return Rest_Categ;
    }

    public String getRest_Name() {
        return Rest_Name;
    }

    public boolean isRest_Open() {
        return Rest_Open;
    }

    public Menu getRest_Menu() {
        return Rest_Menu;
    }

    public double getRest_Rating() {
        return Rest_Rating;
    }

}//end Restaurant
