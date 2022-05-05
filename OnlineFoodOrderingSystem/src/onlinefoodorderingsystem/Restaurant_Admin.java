package onlinefoodorderingsystem;

import java.util.ArrayList;

public class Restaurant_Admin extends Person implements Feedback_Detector {

    private Restaurant Rest = new Restaurant();
    public static RestAdminsData restAdminData = new RestAdminsData();

    public Restaurant_Admin() {

    }

    public Restaurant_Admin(int ID, String Name, String Email, String Phone_number, String Address, String Username, String Password, char Gender) {
        super(ID, Name, Email, Phone_number, Address, Username, Password, Gender);
    }

    public Restaurant_Admin RestAdminLogin(String Username, String Pwd) {
        for (Restaurant_Admin sysRestAdmin : RestAdminsData.getRestAdmins()) {
            if (sysRestAdmin.getUsername().equals(Username) && sysRestAdmin.getPassword().equals(Pwd)) {
                return sysRestAdmin;
            }
        }
        return null;
    }

    /**
     *
     * @param f
     */
    public void Handle_Feedback(Feedback f) {
        Rest.Handle_Feedback(f);
    }

    public void setRest(Restaurant Rest) {
        this.Rest = Rest;
    }

    public Restaurant getRest() {
        return Rest;
    }
    
    public void setNextinchain(Restaurant_Admin x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}//end Restaurant_Admin
