import java.util.*;

public class Account {

	private   double balance ;
 	private int Account_number  ;
	
 	/**
 	 * 
 	 * @param w assigns  value to the  withdraw 
 	 * @return no return type 
 	 */
	public void withdrow(double w)
	{
		if(balance>=w)
		{
			balance-=w;
		}
		else System.out.println("you Don not have  enough money.\n");
		
	}
	
	/**
	 * 
	 * @param d take  value  to assigns  it to deposit  value  
	 * @return  Does  not return values 
	 */ 
	public void Deposit(double d)
	{
		this.balance+=d;
	}
	
	/**
    *Default  constructor   to initializes the  constructor 
    * @return  no return value*/
	public  Account()
	{
		this.Account_number=0;
		this.balance=0;
	}
	
	/**
	 * 
	 * this  method  is  a copy constructor 
	 * @param   a  
	 */
	public Account(final Account a)
	{
		this.balance=a.balance;
		this.Account_number=a.Account_number;
	}
	
	
	/**
	 * 
	 * parameterized  constructor that  set  values  to variables 
	 * @param no assigns  value to account number
	 * @param b  assigns  value  to the balance  of account 
	 * */
	public  Account(int  no , double  b)
	{
		setAccount_number(no);
		setbalance(b);
	}
	
	/**
	 * method setbalance  assigns value to balance 
	 * this  method assigns  values to the  balance  variable 
	 * @return  no return value  	 
	 * */
	public  void  setbalance(double b)
	{
		this.balance=b ;
	}
	/**
	 * method  getbalance   will gives the  user  the  value  of  balance
	 * @return double value 	
	 *  */
	public  double  getbalance()
	{
		return this.balance;
	}
	
	/**
	 * method setaccount number  assigns  value  to the  account number  
	 * @return  no return value
	 * */
	public  void  setAccount_number(int  no)
	{
	this.Account_number=no;
	}
	/**
	 * 
	 * method get account  number    gives  the  value  of the  account  number  
	 * 
	 */
	public  int  getaccountnumber()
	{
	   return Account_number;	
	}
	
	 
	 
	/**
	 * to String method overrides mthod from object class  to return all contents of the  class 
	 * @Override
	 *  
	 */
	public  String  toString()
	{
		return 
				"the Account information ::\n"+
 	             "Account balance :"+getbalance()+"\n"+
	             "Account Number  :"+getaccountnumber()+"\n";
	}

	
	
	
	
	
	
}
