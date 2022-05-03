package onlinefoodorderingsystem;
import java.util.ArrayList;

public class OnlineFoodOrderingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Admin a1 = new Admin(101,"Mahmoud", "mahmoud@gmail.com","01128555666", "Nozha" , "mahmoud123" , "mahmoud123" , 'M');
        Admin a2 = new Admin(102,"Maiada", "maiada@gmail.com","01184841152", "Rehab" , "maiada123" , "maiada123" , 'F');
        Customer c1 = new Customer(201, "Mahmoud" , "mahmoud@gmail.com" , "01128555666" , "Nozha" , "mahmoud123" , "mahmoud123" , 'M');
        Customer c2 = new Customer(202, "Maiada" , "maiada@gmail.com" , "01128555666" , "Rehab" , "maiada123" , "maiad123" , 'F');
        Restaurant_Admin r1 = new Restaurant_Admin(301 , "Mahmoud" , "mahmoud@gmail.com" , "01128555666" , "Nozha" , "mahmoud123" , "mahmoud123" , 'M');
        Restaurant_Admin r2 = new Restaurant_Admin(302 , "Maiada" , "maiada@gmail.com" , "01128555666" , "Rehab" , "maiada123" , "maiada123" , 'F');
        Admin.adminData.SignUp(a1);
        Admin.adminData.SignUp(a2);
        Customer.custdata.SignUp(c2);
        Customer.custdata.SignUp(c1);
        Restaurant_Admin.restAdminData.Add_Rest_Admin(r1);
        Restaurant_Admin.restAdminData.Add_Rest_Admin(r2);
        HomePage home = new HomePage();
        home.setVisible(true);
    }
    
}
