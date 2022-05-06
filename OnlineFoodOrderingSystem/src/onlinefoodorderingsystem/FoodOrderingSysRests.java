package onlinefoodorderingsystem;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTable;

public class FoodOrderingSysRests implements SysRests_Interface, New_Rests {

    private ArrayList<New_Rests_Observer> Customers;
    private static ArrayList<Restaurant> Rests_Avail;

    DB_Connection_Maiada db = new DB_Connection_Maiada();

    public FoodOrderingSysRests() {

    }

    // done
    public void Add_Rest(Restaurant rest, String uname) {
        /* // ---USING ARRAYLISTS --- // 
        this.Rests_Avail.add(rest);
        this.Notify_All(rest.toString());
         */

        // --- USING DATABASE --- //
        db.addRest(rest, uname);
        this.Notify_All(rest);
    }

    
    // done
    public void Remove_Rest(Restaurant rest) {
        /*// --- USING ARRAYLISTS --- //
        for (Restaurant R : Rests_Avail) {
            if (rest == R) {
                Rests_Avail.remove(R);
            }
        }
        */
        
        // --- USING DATABASE --- //
        db.deleteRest(rest.getRest_Id());
    }

    /* // --- USING HASHMAPS --- //
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
    }*/
    // --- USING DATABASE --- //
    public JTable View_Sales_Report(JTable tbl) {
        return db.displaySalesTable(tbl);
    }

    // --- EQUIVALENT TO CUSTOMER SIGN UP --- //
    public void Add_RObserver(New_Rests_Observer newSubscriber) {
        Customers.add(newSubscriber);
    }
    
    
    // --- However, customers are not llowed to delete account --- //
    public boolean Remove_RObserver(New_Rests_Observer subs) {
        for (New_Rests_Observer currObs : Customers) {
            if (currObs == subs) {
                Customers.remove(currObs);
                return true;
            }
        }
        return false;
    }
    
    
    // done
    public void Notify_All(Restaurant rest) {
        /* // --- USING ARRAY LISTS --- //
                for (New_Rests_Observer currObs : Customers) {
            currObs.Update(notif_msg);
        }*/

        // --- USING DATABASE --- //
        db.notifyNewRestsObservers(rest);
    }
    
    @Override
    public ArrayList<Restaurant> getRests_Avail() {
//        return Rests_Avail;
        DB_Connection_Gado db = new DB_Connection_Gado();
        return db.displayRestuarant2();
    }
    

}
