import java.util.List;
import java.util.ArrayList;

public class customer
{

	private int  customer_id ;
	private String customer_name  ;
	private int shipment_type ;
	private  static int  counter =0 ; 
	
	private  List<Integer> l = new  ArrayList() ;
	
	public customer(){l = new ArrayList();}
	
	public customer(String  n , int  i , int  t )
	{
		
		setname(n);
		setid(i);
		settype(t);
		setcounter();
		l.add(t);
	}
	
	public List<Integer>  getlist()
	{
		return  l ;
	}
	
	public void  setname(String n ){customer_name  = n ;}
	public  String  getname(){return customer_name  ;}
	
	public  void setid(int  i ){customer_id=i;}
	public int  getid(){return customer_id;}
	
	public void settype(int t)
	{
		l.add(t);
 	}
	public int gettype(){return shipment_type;}
	
	public void setcounter(){counter++;}
	public static  int getcounter(){return counter;}
	
	
	
	
	
}