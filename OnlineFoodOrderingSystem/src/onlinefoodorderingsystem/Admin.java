package onlinefoodorderingsystem;
import java.util.ArrayList;

public class Admin extends Person implements Feedback_Detector {
    private RestaurantAdminDataAccess restadmin;
    public FoodOrderingSysCoupons m_FoodOrderingSysCoupons;
    public SysRests_Interface m_SysRests;
    public static AdminsData adminData = new AdminsData();
    private Feedback_Detector nextinchain;

    public Admin() {
    }

    public Admin(int ID, String Name, String Email, String Phone_number, String Address, String Username, String Password, char Gender)
    {
        super(ID, Name, Email, Phone_number, Address, Username, Password, Gender);
    }

    public void setM_FoodOrderingSysCoupons(FoodOrderingSysCoupons m_FoodOrderingSysCoupons) {
        this.m_FoodOrderingSysCoupons = m_FoodOrderingSysCoupons;
    }

    public void setM_SysRests(SysRests_Interface m_SysRests) {
        this.m_SysRests = m_SysRests;
    }

    public static void setAdminData(AdminsData adminData) {
        Admin.adminData = adminData;
    }

    public FoodOrderingSysCoupons getM_FoodOrderingSysCoupons() {
        return m_FoodOrderingSysCoupons;
    }

    public SysRests_Interface getM_SysRests() {
        return m_SysRests;
    }

    public static AdminsData getAdminData() {
        return adminData;
    }

    public Admin AdminLogin(String Username, String Pwd)
    {
        for (Admin sysAdmin : adminData.getSysAdmins()) 
        {
            if(sysAdmin.getUsername().equals(Username) && sysAdmin.getPassword().equals(Pwd))
            {
                return sysAdmin;
            }
        }
            return null;
    }

    public void Manage_Account(Admin newchange){
        this.setName(newchange.getName());
        this.setAddress(newchange.getAddress());
        this.setEmail(newchange.getEmail());
        this.setGender(newchange.getGender());
        this.setPhone_number(newchange.getPhone_number());
        this.setUsername(newchange.getUsername());
        this.setPassword(newchange.getPassword());
    }

    public ArrayList View_Feedbacks(){
        return Feedback_History;
    }
    public void setPointOfContact(Feedback_Detector next) {
        //Next_In_Chain = new Restaurant_Admin();
    }
    @Override       
    public void setNextinchain(Restaurant_Admin x){
        this.nextinchain = x;
    }

    @Override
    public void Handle_Feedback(Feedback f){
        if("Complaint".equals(f.getFeedback_Type())){
            f.setFeedback_State("Working on it(accepted)");
        }else if("Rating".equals(f.getFeedback_Type())){
            restadmin.getRestAdmin();
            for(int i = 0; i < restadmin.getRestAdmin().size(); i++){
                for(int j = 0; i < restadmin.getRestAdmin().get(i).getRest().getRest_Accepted_Orders_History().size(); j++ ){
                    if(restadmin.getRestAdmin().get(i).getRest().getRest_Accepted_Orders_History().get(i).getOrder_Id() == f.getOrder_Id()){
                            this.setNextinchain(restadmin.getRestAdmin().get(i));
                            this.nextinchain.Handle_Feedback(f);
                    }
                }
            }
        }
    }


}