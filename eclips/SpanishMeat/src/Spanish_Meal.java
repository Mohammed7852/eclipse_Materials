
/**
 * @author mohamed ali shabanah......
 * Super class Spanish Meat 
 * 
  */

public class Spanish_Meal 
{
	
	private double  price  ;
	private double  weight ;
	private  String  supplier  ;
	private  int  type ;
	private  boolean  is_sold ;
	private Supplier S = new Supplier();
	/**
	 *this  is  a default constructor to initialize class attributes 
	 */
	
	public Spanish_Meal()
	{
		 price = weight =0 ;
		 supplier = "";
		 type =0 ;
		 is_sold = false; 	
		 S= null ;
 	}
	
	/**
	 * parameterized constructor  to assign values to class attributes 
	 
	 * @param p takes the  price value 
	 * @param w takes the weight value
	 * @param t takes the type value 
	 * @param s takes the supplier value  
	 */
	
	Spanish_Meal(double p , double w  ,int  t  , Supplier S)
	{
		setprice(p);
		setweight(w); 
		settype(t); 
		setsupplier(S);
	}

	/**
	 * method setflag :: sets flg by  true  if   
	 * the shipment sold otherwise will be false by default
	 */
	public void set_flag()
	{
		 is_sold = true;
	}
	/**
	 * get flag method 
	 * 
	 * @return boolean that indicate  if the shippment sold or  not .
	 * 
	 */
	public boolean is_paid()
	{
		return is_sold  ;
	}
	
	/**
	 * this  method assigns the smallest  price of the shipment  by supplier 
	 * @param p takes  value to the price 
	 * 
	 */
	public void setprice(double p)
	{
		this.price=p;
	}
	
	/**
	 * this  method that gives the value of price 
	 * @return returns a double value
	 */
	
	public double getprice()
	{
		return price;
	}
	
	/**
	 * @param w takes  the value  of the  shipment weight 
	 * a method assigns value to the weight attribute
 	 */
	public void setweight(double w)
	{
		this.weight=w;
	}
	
	/**
	 * this  method returns the value of price 
	 * @return returns a double value
	 */
	public double getweight()
	{
		return weight ;
	}
	
	
	/**
	 * this method assigns type to shipment 
	 * @param t  is the type  of  shipment 
	 */
	public void settype(int t)
	{
		type=t ; 
	}
	
	/**
	 * this method return the type  of the desired shipment 
	 * @return integer number 
	 */
	public int gettype()
	{
		return type ;
	}
	
	/**
	 * this method assigns name to supplier 
	 * @param s is the shipment supplier 
	 */
	public void setsupplier(Supplier s)
	{
		S = s ;
	}
	
	/**
	 * this method returns  the supplier name
	 * @return String name of supplier 
	 */
	public Supplier getsupplier()
	{
		  return S ;
	}
	 
	/**
	 * method to string returns all shipment  information 
	 * @return string 
	 */
	public  String toString()
	{
		return  "The Shipment  Information :"
				+ "rice  is  :"+getprice()+"\n"
						+ "weigth is  :"+getweight()+"\n"
								+ "type  is  :"+gettype()+"\n"
										+ "supplier is  :"+getsupplier() + "\n"
												+ "";
	}
	
}
