package onlinefoodorderingsystem;

import java.util.ArrayList;

public class Restaurant_Admin extends Person implements Feedback_Detector {

    private Restaurant Rest;

    public Restaurant_Admin() {

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

    }

    public void setRest(Restaurant Rest) {
        this.Rest = Rest;
    }

    public Restaurant getRest() {
        return Rest;
    }
    

}//end Restaurant_Admin
