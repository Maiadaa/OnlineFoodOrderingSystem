package onlinefoodorderingsystem;
import java.util.ArrayList;


public class FoodOrderingSysCoupons implements Premium_Coupon {

	private ArrayList<Coupon_Observer> Applicable_Custs;
	private ArrayList<Coupon> Coupons_Avail;
	public Coupon m_Coupon;
        DB_Connection_Assem conn = new DB_Connection_Assem();
        Premium_Coupon prem;
        

       
	public FoodOrderingSysCoupons(){

	}
        
	public void View_Coupons()
        {
            
	}
        @Override
        public void Notify_All(String msg)
        {
            ArrayList<Premium_Customer> premCusts = new ArrayList();
            premCusts = conn.getAllPremCustomers();
            for(int i = 0;i<premCusts.size();i++)
            {
                premCusts.get(i).Update(msg);
            }
        }
        
	public void Create_Coupon(Coupon C)
        {
            conn.CreateValidCoupon(C);
            this.Notify_All(C.getCoupon_Desc());
            
	}
	public void Remove_Coupon(int code)
        {
            conn.DeleteCoupon(code);
	}
        public void Update_Coupon(int code , Coupon c)
        {
            conn.UpdateCoupon(code, c);
        }

	public void Add_Observer(Customer c)
        {
            conn.Add_Observer(c);
	}


	public void Remove_Observer(Coupon_Observer subs)
        {

	}

}//end FoodOrderingSysCoupons