package onlinefoodorderingsystem;

import java.util.ArrayList;

public class Restaurant_Admin extends Person implements Feedback_Detector {

    private Restaurant Rest;

    public Restaurant_Admin() {

    }

    public Restaurant_Admin Login(String Username, String Pwd) {
        return null;
    }

    public void Handle_Feedback(Feedback f) {

    }

    public Restaurant getRest() {
        return Rest;
    }

    public void setRest(Restaurant Rest) {
        this.Rest = Rest;
    }
}//end Restaurant_Admin
