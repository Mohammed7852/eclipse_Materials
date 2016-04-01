
public class Supplier 
{

	private  String name  ;
	private int ID   ;
	private static  int counter= 0 ;
	
	
	public Supplier(){}
	public Supplier(String  n , int  i )
	{
		setname(n);
		setid(i);
		counter++ ;
	}
	
	public void setcount(){counter++;}
	public static int getcounter(){return counter;}
	
	public void  setname(String name  )
	{
		name=name  ;
	}
	public  String  getname()
	{
		return name  ;
	}
	
	public  void setid(int  id  )
	{
		ID=id;
	}
	public  int getid()
	{
		return ID;
	}
	
	public String toString()
	{
		return "Supplier info ::"
				+ "name   ::"+getname()+"\n"
						+ "id  : "+getid()+"\n"
								+ "number of shipments : "+counter+"\n";
	}
	
	

	
	
}
