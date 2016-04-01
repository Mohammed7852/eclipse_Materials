import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author mohamed ali shabanah
  *@category class Bank  test all  classes  :: Accounts and  Clients  
  *
 */
public class Bank 
{

	private String  Bank_name  , Bank_address   ;
	private  int Bank_phone;
	
	/**
	 * List of Accounts  in bank 
	 */
    private List<Account> Account_List = new ArrayList<Account>();
    
    /**
     * List of  bank clients  
     * 
     */
    private   List<Client> Client_List = new ArrayList<Client>();
    
    ////////////////////////////////////////////////////////////////////
    /**
     * default  constructor  
     */
	Bank()
	{}
	
	/**
	 * parameterizes   constructor  assigns  values  to bank attributes  
	 * 
	 * @param name takes  value  of  bank name 
	 * @param address bank address  
	 * @param phone bank phone  
	 * @param ac  bank account addes to list of accounts 
	 * @param cl  bank client addes  to bank clients  
	 */
	Bank(String  name ,String  address , int phone , Account ac , Client cl)
	{
		setname(name);
		setphone(phone);
		setaddress(address);
	}
	
	/////////////////////////////////
	
	/**
	 * set accounts  method assigns  one  account to the  list of accounts  in the  bank 
	 * @return no return type 
	 */
	public void setaccount(Account A)
	{
		Account_List.add(A);
	}
	
	/**
	 * display accounts method will display all accounts  information within the  bank 
	 * @return no return type  
	 */
	
	public void displayaccounts()
	{
		System.out.println("Your Bank  includes this accounts ::\n");
		for(Account A : Account_List)
		{
 			System.out.println(A+"\n");
		}
	}
	
	///////////////////////////////
	/** 
	 * @param c  is  the  client  added to bank clients 
	 * @category setclient   method will assigns one  client  to the  list of clients  in the  bank 
	 * @return does  not  return value 
	 * @ 
	 */
	public void setclient(Client c)
	{
		Client_List.add(c);
	}
	
	/**
	 * method  in bank class displays  all clients  information 
	 * @return does not  return any  values 
	 */
	public void displayclients()
	{
		 System.out.println("All Bank clients are ::\n");
		
		for(Client c  : Client_List)
		{
			System.out.println(c+"\n");
		}
	}
	///////////////////////////////
	/**
	 * setname  method assigns  value  to bank name 
	 * @param name is bank name  
	 */
	public void setname(String name)
	{
		this.Bank_name=name ;
	}
	
	/**
	 * getname  method  returns  bank name  
	 * @return String  value  which is  the  bank name  
	 */
	public  String  getname()
	{
		return Bank_name;
	}
	
	////////////////////////////////
	
	/**
	 * set phone method  assigns  value  to the bank phone  
	 * @param ph is  the  bank phone  
	 */
	public  void  setphone(int  ph)
	{
		Bank_phone=ph;
	}
	/**
	 * getphone  method  
	 * @return integer  value  which is the bank phone  
	 */
	public  int  getphone()
	{
		return Bank_phone;
	}
	
	////////////////////////////////////////
	/**
	 * setaddress  method  assigns  value  to the  bank address  
	 * @param address  is  the  bank address  
	 */
	public  void setaddress(String  address)
	{
		this.Bank_address=address;
	}
	/**
	 * getaddress  method  returns  bank address  
	 * @return String  value  which is the  bank address  
	 */
	public  String  getaddress ()
	{
		return Bank_address;
	}
	//////////////////////////////////////////
}
