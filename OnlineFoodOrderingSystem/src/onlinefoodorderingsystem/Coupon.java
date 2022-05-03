package onlinefoodorderingsystem;
import java.util.ArrayList;


public class Coupon 
{

	private int Coupon_Code;
	private int Coupon_Discount_Val;
	private String Coupon_Desc;
	private String Coupon_ExpiryDate;
	private ArrayList<Restaurant> Applicable_Rests;

	public Coupon()
        {

	}

    public void setCoupon_Code(int Coupon_Code) 
    {
        this.Coupon_Code = Coupon_Code;
    }

    public void setCoupon_Discount_Val(int Coupon_Discount_Val) 
    {
        this.Coupon_Discount_Val = Coupon_Discount_Val;
    }

    public void setCoupon_Desc(String Coupon_Desc) 
    {
        this.Coupon_Desc = Coupon_Desc;
    }

    public void setCoupon_ExpiryDate(String Coupon_ExpiryDate) 
    {
        this.Coupon_ExpiryDate = Coupon_ExpiryDate;
    }

    public void setApplicable_Rests(ArrayList<Restaurant> Applicable_Rests) 
    {
        this.Applicable_Rests = Applicable_Rests;
    }
	
    public int getCoupon_Code() 
    {
        return Coupon_Code;
    }

    public int getCoupon_Discount_Val() 
    {
        return Coupon_Discount_Val;
    }

    public String getCoupon_Desc()
    {
        return Coupon_Desc;
    }

    public String getCoupon_ExpiryDate() 
    {
        return Coupon_ExpiryDate;
    }

    public ArrayList<Restaurant> getApplicable_Rests() 
    {
        return Applicable_Rests;
    }

	
}//end Coupon