package onlinefoodorderingsystem;

import java.util.ArrayList;
import java.util.HashMap;

public class FoodOrderingSysRests implements SysRests_Interface, New_Rests {

    private ArrayList<New_Rests_Observer> Customers;
    private ArrayList<Restaurant> Rests_Avail;
    private SysRests_Interface RestsInterface;

    public FoodOrderingSysRests() {

    }

    public void Add_Rest(Restaurant rest) {
        this.Rests_Avail.add(rest);
        this.Notify_All(rest.toString());
    }

    /**
     *
     * @param rest
     */
    public boolean Remove_Rest(Restaurant rest) {
        for (Restaurant R : Rests_Avail) {
            if (rest == R) {
                Rests_Avail.remove(R);
                return true;
            }
        }
        return false;
    }

    public HashMap Generate_Sales_Report() {
        HashMap<Restaurant, Double> salesRepo = new HashMap<>();
        for (Restaurant R : Rests_Avail) {
            double restRevenue = 0;
            for (Order o : R.getRest_Accepted_Orders_History()) {
                restRevenue += o.getOrder_Price();
            }
            salesRepo.put(R, restRevenue);
        }
        return salesRepo;
    }

    public void View_Sales_Report() {

    }


    public void Add_RObserver(New_Rests_Observer newSubscriber) {
        Customers.add(newSubscriber);
    }


    public boolean Remove_RObserver(New_Rests_Observer subs) {
        for(New_Rests_Observer currObs: Customers){
            if(currObs == subs){
                Customers.remove(currObs);
                return true;
            }
        }
        return false;
    }


    public void Notify_All(String notif_msg) {
        for(New_Rests_Observer currObs : Customers){
            //currObs.Update(notif_msg);
        }
    }

    @Override
    public void getRests_Avail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}//end FoodOrderingSysRests
