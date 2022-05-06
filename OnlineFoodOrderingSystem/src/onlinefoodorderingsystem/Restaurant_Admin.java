package onlinefoodorderingsystem;

import java.util.ArrayList;

public class Restaurant_Admin extends Person implements Feedback_Detector {

    private Restaurant Rest = new Restaurant();
    public static RestAdminsData restAdminData = new RestAdminsData();

    DB_Connection_Maiada db_mai = new DB_Connection_Maiada();

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

    @Override
    public String toString() {
        return "Restaurant_Admin{" + "Rest=" + Rest.toString() + '}';
    }

    public boolean ManageRestDetails() {
        // --- using database --- //
        return db_mai.Edit_Rest_Details(this.Rest);
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

    @Override
    public void Handle_Feedback(Feedback f) {
        if (f.getFeedback_Type().equals("rating")) {
            f.setFeedback_State("Accepted from Restaurant Admin");
            DB_Connection_Hagrass db = new DB_Connection_Hagrass();
            db.EditFeedbackStatus(f);
            if (f.getRate() <= 3) {
                if (Rest.getRest_Rating() > 0) {
                    db.editRestRating(Rest.getRest_Id(), (Rest.getRest_Rating() - 0.1));
                }
            }else if(f.getRate() > 3){
                if (Rest.getRest_Rating() > 0 && Rest.getRest_Rating() > 3) {
                    db.editRestRating(Rest.getRest_Id(), (Rest.getRest_Rating() + 0.1));
                }
            }
        }
    }
    
    
}//end Restaurant_Admin
