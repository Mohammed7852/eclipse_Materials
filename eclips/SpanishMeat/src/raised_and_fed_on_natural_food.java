/**
 * 
 * @author mohamed ali shabanah
 *class of  the second type  of  meals  
 */
public class raised_and_fed_on_natural_food extends Spanish_Meal
{

	/**
	 * def. constructor  
	 * initialize super attributes 
	 */
	raised_and_fed_on_natural_food()
	{
		super(0 , 0  , 0 , null);
	}
	
	/**
	 * parameterizes constructor  assigns  values to meal attributes 
	 * @param p is  shipment minimum price 
	 * @param w is the weight of  shipment
	 * @param t is the shipment type
	 * @param s is the shipment supplier 
	 */
	raised_and_fed_on_natural_food(double p , double w  ,int  t  , Supplier s)
	{
		super(p , w , t , s);
	}
	
	 /**
	  * toString Method ::this method returns all shipment information needed 
	  * @return string  of all shipment information 
	  */
	
	public  String toString()
	{
		return  "Shipment of Type(2) ((raised_and_fed_on_natural_food)) with :\n"
				+ "Price = "+getprice()+"\n"
						+ "Weigth = "+getweight()+"\n"
											+ "Supplier is  :-"+getsupplier() + "\n"
												+ "";
	}
}
