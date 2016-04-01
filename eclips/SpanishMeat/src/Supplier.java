/**
 * 
 * @author mohamed ali shabanah
 *class supplier 
 */
public class Supplier 
{

	private  String name  ;
	private int ID   ;
	private    int counter  ;
	
	/**
	 * default constructor 
	 * initialize values 
	 */
	public Supplier()
	{
		name = "";
		ID =  0 ;
	   counter =0 ;	
	}
	
	/**
	 * 
	 * parameterizes constructor  assigns values to supplier attributes 
	 * @param n  is the  supplier  name 
	 * @param i  is  the  supplier  id  
	 */
	public Supplier(String  n , int  i , int count  )
	{
		setname(n);
		setid(i);
		setcount(count);
 	}
	/**
	 * this method increments the counter
	 */
	public void setcount(int  count )
	{
		counter = count ;
	}
	/**
	 * 
	 * @return integer value  counter
	 */
	public   int getcounter()
	{
		return counter;
	}
	
	/**
	 * this method assigns to supplier name 
	 * @param name is the supplier name
	 */
	public void  setname(String n   )
	{
		name=n ;
	}
	
	/**
	 * 
	 * @return string  value  the  supplier name 
	 */
	public  String  getname()
	{
		return name  ;
	}
	
	/**
	 * Assigns value to supplier id 
	 * @param id is the supplier id 
	 */
	public  void setid(int  id  )
	{
		ID=id;
	}
	/**
	 * 
	 * @return integer  value   the supplier id 
	 */
	public  int getid()
	{
		return ID;
	}
	
	/**
	 * to string peints  all supplier information 
	 * @return string  value 
	 */
	public String toString()
	{
		return "\n"
				+ "Name : "+getname()+"\n"
						+ "ID : "+getid()+"\n"
								+ "Number of Shipments : "+getcounter()+"\n"
										+ "";
	}
	
	

	
	
}
