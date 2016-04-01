/**
 * @author mohamed ali shabanah
 * Client  class toallow  dealing  with customers  of  the  bank 
 * 
 */
import java.lang.*;


public class Client
{

	private String Client_name , Client_address;
	private int Client_id  ,Client_phone;
	private  Account Client_Account;
	
	/**
	default constructor
	*/
	
	Client(){}
	
	 /**
	  * parameterized constructor 
	  * 
	  * @param name value  of   client  name 
	  * @param address  takes client  address 
	  * @param id  client national id  
	  * @param phone  client  phone  
	  * @param a takes  client  account  
	  */
	Client(String  name , String address , int  id  ,int  phone , Account a)
	{
		setaccount(a);
		setaddres(address);
		setid(id);
		setname(name);
		setphone(phone);
	}
	
 	/**
 	 *  
 	 * 
	 * method  set account  assigns value to account attribute
	 * @return  does not return values
 	 * @param a  sets  client  account  
 	 * 
 	 */
	public void setaccount(Account a)
	{
		this.Client_Account=a;
	}
	
	 /**
	  * method get account  returns clinet  account  
	 * @return returns  values of type account 
	  
	  */
	public String getaccount()
	{
		 return Client_Account.toString();
	}
	
	/**
	 * set name  ssigns  value to name  of clinet  
	 * @param name takes  name value from user  
	 */
	public void setname(String name)
	{
		this.Client_name=name;
	}
	/**
	 * get name  gives  user  the  name  of the  client 
	 * @return name  of  the  client  
	 */
	public String getname  ()
	{
		return this.Client_name;
	}
	
	/**
	 * method  set address  assigns  value  to the client  address  
	 * @param address  takes  the  address  value 
	 */
	public void setaddres(String  address)
	{
		this.Client_address=address;
	}
	/**
	 * method getaddress  returns  address  
	 * @return the  client  address  to the  user  
	 */
	public String getsddress()
	{
		return this.Client_address;
	}
	
	/**
	 * method  assigns value  to the  client  national id  
	 * @param id takes the value  of  national id  
	 */
	public void setid(int id)
	{
		this.Client_id=id ;
	}
	/**
	 * method  returns  value  of  client  id  
	 * @return the  client national id  
	 */
	public int getid()
	{
		return this.Client_id;
	}
	
	/**
	 * method  sets  value  to the  client  phone  
	 * @param ph takes  the  value  of phone  number  
	 */
	public void setphone(int  ph)
	{
		this.Client_phone=ph; 
	}
	/**
	 * method  return the  client  phone  
	 * @return the  client  phone  
	 */
	public int  getphone()
	{
		return this.Client_phone;
	}
	
	@Override
	
	/**
	 * method  toString  overrides  method from object class 
	 * return all class information 
	 */
	public String toString()
	{
		return 
				"this Client info. is  ::\n"+
	             "Client  name  ::"+getname()+"\n"+
	             "Client id  :"+getid()+"\n"+
	             "Client address:"+getsddress()+"\n"
	            + "Client phone  ::"+getphone()+"\n"+
	             "Client Account :"+getaccount()+"\n"+
	            "";
		
	}
	
}
