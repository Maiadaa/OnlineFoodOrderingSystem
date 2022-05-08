package onlinefoodorderingsystem;

import java.util.ArrayList;

public class RestAdminsData {

    private static ArrayList<Restaurant_Admin> restAdmins = new ArrayList<Restaurant_Admin>();

    DB_Connection_Maiada db = new DB_Connection_Maiada();

    public RestAdminsData() {

    }

    // done
    public void Add_Rest_Admin(Restaurant_Admin ra) {
        /*// --- USING ARRAYLISTS --- //
            restAdmins.add(ra);
            System.out.println("Restaurant Admin Added Successfully");
         */
        // --- USING DATABASE --- //
        DB_Connection_Maiada db = new DB_Connection_Maiada();

        db.addRestAdmin(ra);
    }

    // done
    public void Remove_Rest_Admin(Restaurant_Admin ra) {
        /*// --- USING ARRAYLISTS --- //
            for(Restaurant_Admin RA : restAdmins){
                if(ra == RA){
                    restAdmins.remove(RA);
                }
            }
         */

        // --- USING DATABASE --- //
        db.deleteRestAdmin(ra.getID());
    }

    public static ArrayList<Restaurant_Admin> getRestAdmins() {
        return restAdmins;
    }

}
