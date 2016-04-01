
/**
 * @author mohamed ali shabanah
  */

public class Spanish_Meal 
{
	private double  price  ;
	private double  weight ;
	private  String  supplier  ;
	private  int  type ;
	private  boolean  is_sold ;
	
	/*
	 * @this  is  a default constructor to initialize class attributes 
	 */
	
	public Spanish_Meal() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * parameterized constructor  to assign values to class attributes 
	 */
	
	/**
	 * @param p takes the  price value 
	 * @param w takes the weight value
	 * @param t takes the type value 
	 * @param s takes the supplier value  
	 */
	
	Spanish_Meal(double p , double w  ,int  t  , String  s)
	{
		setprice(p);
		setweight(w); 
		settype(t); 
		setsupplier(s);
		}
//	
	/**
	 * 
	 */
	public void set_flag()
	{
		 is_sold = true;
	}
	public boolean is_paid()
	{
		return is_sold  ;
	}
	
	/**
	 * a method assigns value to the price attribute
 	 */
	
	/**
	 * @param p assigns value to the price 
	 * 
	 */
	public void setprice(double p)
	{
		this.price=p;
	}
	
	/**
	 * a method that gives the value of price 
	 * @return returns a double value
	 */
	public double getprice()
	{
		return price;
	}
	
	/**
	 * @param w
	 * a method assigns value to the weight attribute
 	 */
	public void setweight(double w)
	{
		this.weight=w;
	}
	
	/**
	 * a method that gives the value of price 
	 * @return returns a double value
	 */
	public double getweight()
	{
		return weight ;
	}
	
	
	public void settype(int t)
	{
		type=t ; 
	}
	
	public int gettype()
	{
		return type ;
	}
	
	public void setsupplier(String s)
	{
		supplier = s ;
	}
	
	public String getsupplier()
	{
		  return supplier ;
	}
	/**
	 * 
	 * */
	public  String toString()
	{
		return  "this shipment  information :"
				+ "price  is  :"+getprice()+"\n"
						+ "weigth is  :"+getweight()+"\n"
								+ "type  is  :"+gettype()+"\n"
										+ "supplier is  :"+getsupplier() + "\n"
												+ "";
	}
	
}
