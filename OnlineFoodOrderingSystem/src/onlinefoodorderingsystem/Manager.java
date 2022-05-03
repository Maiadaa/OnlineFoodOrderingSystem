package onlinefoodorderingsystem;

import java.util.ArrayList;

public class Manager extends Admin {

    private static Manager theManager;

    private FoodOrderingSysRests sysRests;
    private RestAdminsData sysRestsAdmins;

    private Manager() {
        theManager.setID(203398);
        theManager.setUsername("manager");
        theManager.setPassword("m1234");
        theManager.setName("Maiada");
        theManager.setGender('F');
        theManager.setEmail("mai@gmail.com");
        theManager.setPhone_number("01010101010");
        theManager.setAddress("Rehab");
    }

    public static Manager getTheManager() {
        return theManager;
    }

    public static boolean ManagerLogin(String username, String pw) {
        if (username.equals("manager") && pw.equals("m1234")) {
            return true;
        }
        return false;
    }

    public void Add_Rest_Admin(Restaurant_Admin ra) {
        /* test:
            Restaurant_Admin ra = new Restaurant_Admin();
            ra.setUsername("Hardees");
            ra.setPassword("hardees1234");
         */

        sysRestsAdmins.Add_Rest_Admin(ra);
        sysRests.Add_Rest(ra.getRest());
    }

    public boolean Remove_Rest_Admin(Restaurant_Admin ra) {
        if (sysRestsAdmins.Remove_Rest_Admin(ra)) {
            sysRests.Remove_Rest(ra.getRest());
            return true;
        }
        return false;
    }

    public FoodOrderingSysRests getSysRests() {
        return sysRests;
    }

    public void setSysRests(FoodOrderingSysRests sysRests) {
        this.sysRests = sysRests;
    }

    public RestAdminsData getSysRestsAdmins() {
        return sysRestsAdmins;
    }

    public void setSysRestsAdmins(RestAdminsData sysRestsAdmins) {
        this.sysRestsAdmins = sysRestsAdmins;
    }

}
