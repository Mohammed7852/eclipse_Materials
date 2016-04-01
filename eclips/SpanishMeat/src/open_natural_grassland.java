/**
 * 
 * @author mohamed ali shabanah
 *this class   refers to the  best type of  meals  
 */
public class open_natural_grassland  extends Spanish_Meal
{

	/**
	 * default constructor to initialize super attributes 
	 */
	open_natural_grassland()
	{
		super(0 , 0 , 0 , null);
	}
	
	/**
	 * parameterizes constructor  assigns  values to meal attributes 
	 * @param p is  shipment minimum price 
	 * @param w is the weight of  shipment
	 * @param t is the shipment type
	 * @param s is the shipment supplier 
	 */
	open_natural_grassland(double p , double w  ,int  t  , Supplier  s)
	{
		super(p , w , t , s);
	}

	 /**
	  * toString Method ::this method returns all shipment information needed 
	  * @return string  of all shipment information 
	  */
		public  String toString()
		{
			return  "Shipment of Type(1) ((open_natural_grassland)) with :\n"
					+ "Price = "+getprice()+"\n"
							+ "Weigth = "+getweight()+"\n"
 											+ "Supplier is  :-"+getsupplier() + "\n"
													+ "";
		}
	
}
