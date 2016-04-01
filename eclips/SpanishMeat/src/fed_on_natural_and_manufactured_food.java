/**
 * 
 * @author mohamed ali shabanah
 *this class is of the third type  of  meat 
 */
public class fed_on_natural_and_manufactured_food extends Spanish_Meal
{

	
	/**
	 * default constructor to initialize super attributes 
	 */
	fed_on_natural_and_manufactured_food(){}
	
	/**
	 * parameterizes constructor  assigns  values to meal attributes 
	 * @param p is  shipment minimum price 
	 * @param w is the weight of  shipment
	 * @param t is the shipment type
	 * @param s is the shipment supplier 
	 */
	fed_on_natural_and_manufactured_food(double p , double w  ,int  t  , Supplier  s)
	{
		super(p , w , t , s);
	}
	 /**
	  * toString Method ::this method returns all shipment information needed 
	  * @return string  of all shipment information 
	  */
	
	public  String toString()
	{
		return  "Shipment of Type(3) ((fed_on_natural_and_manufactured_food )) with :\n"
				+ "Price = "+getprice()+"\n"
						+ "Weigth = "+getweight()+"\n"
											+ "Supplier is  :-"+getsupplier() + "\n"
												+ "";
	}

}
