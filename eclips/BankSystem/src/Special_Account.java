import java.util.*;

/**
 * @author mohamed ali shabanah
 *
 */
 
/**
 * @author mohamed ali shabanah
 *
 */
/**
 * @author mohamed ali shabanah
 *
 */
 
public class Special_Account extends Account 
{
	
	public static double count = 1000;
	
	
	/**
	 * default  constructor 
	 */
	public Special_Account(){}
	
	/**
	 * parameterised constructor assigns  values  to parent attributes 
	 * @param no  takes  value to account  number 
	 * @param b  takes  value  to balance 
	 */ 
	public Special_Account(int no ,double b)
	{
		super(no,b);
	}
	
 /**
  * method  withdrow   overrides  method from parent  class to set some  special condition here 
  * @return no return type  
  * @param w take the  ammount   to be withdrawn 
  */
	public void withdrow(double w)
	{
	      double gb = getbalance();
	      
	      if(gb>=w)
	      {
	    	  /**
	    	   * 
	    	   * this method will modify the value of balance  of this  account
	    	   * */
	    	  setbalance(gb-w);
	      }
	      else 
	      {
	    	  double x= gb + count ;
	    	  
	    	  if(x>=w)
	    	  {
	    		  count=x-w;
	    		  
		    	  /**this method will modify the value of balance  of this  account*/
	    		  setbalance(0.0);
	    		  
	    		  System.out.println(x + "   "+count+"you donot have enough money ,, "+
	    		  "but you can withdrow  from over draft.\n");
	    	  }
	    	  else
	    	  {
	    		  System.out.println("we can give you only:"+x+" ,, and request :"+w+
	    				  "  so we are  Sorry.\n");
	    	  }
	      }
	}

}
