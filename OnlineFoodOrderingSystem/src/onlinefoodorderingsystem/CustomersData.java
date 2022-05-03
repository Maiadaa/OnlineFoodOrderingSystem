package onlinefoodorderingsystem;
import java.util.ArrayList;



public class CustomersData {

	private static ArrayList<Customer> sysCusts = new ArrayList<Customer>();

	public CustomersData(){

	}

        public static ArrayList<Customer> getSysCusts() 
        {
            return sysCusts;
        }
        
	public void SignUp(Customer cust)
        {
            sysCusts.add(cust);
            System.out.println("Customer Added Successsfully");
	}	
}