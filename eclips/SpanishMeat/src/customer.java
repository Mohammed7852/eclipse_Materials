import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * @author mohamed ali shabanah
 *class customer 
 */
public class customer
{

	private int  customer_id ;
	private String customer_name  ;
	private int shipment_type  , Array[] = {4 ,3,2,1}  ;
	
	private  static int  counter =0 , summation ;
	
	/**
	 * list of integers 
	 */
	
	private  List<Integer> l = new  ArrayList() ;
	
	public customer()
	{
		setname("");
		setid(0);
		settype(0);
		summation =  0 ;
  	}
	
	/**
	 * 
	 * @param n name of customer
	 * @param i customer id 
	 * @param t shipment type
	 */
	public customer(String  n , int  i , int  t )
	{
		setname(n);
		setid(i);
		settype(t);
		setcounter();
		
	}
	 
	public void fill_information()
	{
		Scanner cin = new Scanner(System.in);
		System.out.print("Enter your Name : ");
		cin.nextLine();
		this.customer_name = cin.nextLine();
		
		System.out.print("Enter your ID : ");
		this.customer_id = cin.nextInt();

	}
	/**
	 * 
	 * @param n  the customer name 
	 */
	public void  setname(String n )
	{
		customer_name  = n ;
	}
	
	/**
	 * 
	 * @return string the customer name 
	 */
	public  String  getname()
	{
		return customer_name  ;
	}
	
	/**
	 * 
	 * @param i the customer id 
	 */
	public  void setid(int  i )
	{
		customer_id=i;
	}
	
	/**
	 * 
	 * @return integer the customer id 
	 */
	public int  getid()
	{
		return customer_id;
	}
	
	/**
	 * set type of shipment the customer buys
	 * @param t the type of shipment( 1 ||  2 ||  3  || 4 )
	 */
	public void settype(int t)
	{
		 if(t == 1 )
		 {
			 summation += 4 ;
		 }else  if(t == 2)
		 {
			 summation += 3 ; 
		 }else if(t == 3)
		 {
			 summation += 2 ;
		 }else if( t == 4 )
		 {
			 summation += 1 ;
		 }
 	}
	
	/**
	 * 
	 * @return integer value the summation of types of customer
	 */
	public int getsummation()
	{
		return summation ;
	}
	/**
	 * sets counter to count number shipments the customer buys 
	 */	
	public void setcounter()
	{
		counter++;
    }
	
	/**
	 * 
	 * @return counter  of number of shipments the customer has bought 
	 */
	public   int getcounter()
	{
		return counter;
	}
	
	
	/**
	 * to String method to print all customer information 
	 * return all customer  information 
	 */
	
	public String toString()
	{
		return ""
				+ "Customer Name :"+getname()+"\n"
				+ "Customer ID :"+getid()+"\n"
				+ "Number of bought shipments :"+getcounter()+"\n"
						+ "Summation of them :"+getsummation()+"\n";
	}
	
	
	
}
