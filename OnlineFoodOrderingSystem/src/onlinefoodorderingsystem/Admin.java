package onlinefoodorderingsystem;
import java.util.ArrayList;
import javax.swing.JTable;

public class Admin extends Person implements Feedback_Detector {
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

    public boolean Manage_Account(Admin newchange){
        DB_Connection_Hagrass db = new DB_Connection_Hagrass();
        return db.Edit_Admin_Account(newchange);
    }

    public JTable View_Feedbacks(JTable table){
        DB_Connection_Hagrass  db = new DB_Connection_Hagrass();
        return db.selectAllComplaintFeedback(table);
    }
     
    public void setNextinchain(Feedback_Detector x){
        this.nextinchain = x;
    }

    @Override
    public void Handle_Feedback(Feedback f){
        if(f.getFeedback_Type().equals("Complaint")){
            f.setFeedback_State("Working on it(accepted)");
            DB_Connection_Hagrass db = new DB_Connection_Hagrass();
            db.AdminEditFeedbackStatus(f);
        }else if(f.getFeedback_Type().equals("Rating")){
            DB_Connection_Hagrass db = new DB_Connection_Hagrass();
            Restaurant_Admin restAdmin = db.SelectRestAdminData(db.selectRestAdminID(f.getOrder_Id()));
            this.setNextinchain(restAdmin);
            nextinchain.Handle_Feedback(f);
        }
    }
    


}