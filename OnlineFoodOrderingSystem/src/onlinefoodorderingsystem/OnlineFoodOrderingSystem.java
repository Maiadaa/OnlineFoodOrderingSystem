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
        Admin.adminData.SignUp(a1);
        Admin.adminData.SignUp(a2);
        HomePage home = new HomePage();
        home.setVisible(true);
    }
    
}
