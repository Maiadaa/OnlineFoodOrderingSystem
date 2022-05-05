package onlinefoodorderingsystem;

import java.util.ArrayList;

public class Manager extends Admin {

    private static final Manager theManager = new Manager() ;

    private FoodOrderingSysRests sysRests = new FoodOrderingSysRests();
    private RestAdminsData sysRestsAdmins = new RestAdminsData();

    private Manager() {
        super(203398, "Maiada", "mai@gmail.com", "01010101010", "Rehab", "manager", "m12234",'F' );

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

    @Override
    public String toString() {
        return "Manager{" + super.toString() + '}';
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
