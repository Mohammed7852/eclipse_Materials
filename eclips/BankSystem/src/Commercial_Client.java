/**
 * 
 * @author mohamed ali shabanah
 *class  commercial client  :: is  aspecial cas  of  client types  
 */
public class Commercial_Client  extends Client
{
	
	public int commrecial_id ;
	
	/**
	 * default  constructor  intilizes  values  of class 
	 */
	Commercial_Client(){}
	
	/**
	 * parameterizes constructor  assigns  value  to the commercial client  attributes  
	 * 
	 * @param name assigns  value  to client name 
	 * @param address  value  of  client  address 
	 * @param id  value  of client id   not  the  national id  ,, 
	 * bec it is  for  companies  not  for  persons 
	 * 
	 * @param phone value of client  phone 
	 * @param a client  account 
	 */
	Commercial_Client(String  name , String address , int  id  ,int  phone , Account a)
	{
		super(name , address  , id  , phone  , a);
	}
	
	/**
	 * methode  assigns  value  to commercial client  id  
	 * @param id  take  value  of  client  id 
	 * @return no return type 
	 * national id  =000000000 
	 * 
	 */
	public void  setid(int  id)
	{ 
		super.setid(0000000);
		this.commrecial_id=id;
	}
	
	 /**
	  * method  getod  returns  the commercial client  id 
	  * @return integer  value  which is the  client  id  
	  */
	
	public int getid()
	{
		return this.commrecial_id;
	}
	
	
	/**
	 * to string method  return all class  info.
	 * @return String  value  which is  all class  information 
	 */
	public String tostring()
	{
		return 
				"this Commercial_Client  information ::\n"+
	             "Client  name  ::"+getname()+"\n"+
	             "Client id     ::"+getid()+"\n"+
	             "Client address::"+getsddress()+"\n"+
	             "Client phone  ::"+getphone()+"\n"+
	             "Client Account::"+getaccount()+"\n"+
	            "";
	}
	

}
