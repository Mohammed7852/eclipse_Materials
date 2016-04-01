
/**
 * 
 * @author mohamed ali shabanah
 *this class is  of  type  4 
 */
public class fed_on_manfacured_feed extends Spanish_Meal
{
	/**
	 * default constructor to initialize super attributes 
	 */
	fed_on_manfacured_feed(){}
	
	/**
	 * parameterizes constructor  assigns  values to meal attributes 
	 * @param p is  shipment minimum price 
	 * @param w is the weight of  shipment
	 * @param t is the shipment type
	 * @param s is the shipment supplier 
	 */
	fed_on_manfacured_feed(double p , double w  ,int  t  , Supplier  s)
	{
		super(p , w , t , s);
	}
	
	
	public  String toString()
	{
		return  "Shipment of Type(4) ((fed_on_manfacured_feed)) with :\n"
				+ "Price = "+getprice()+"\n"
						+ "Weigth = "+getweight()+"\n"
											+ "Supplier is  :-"+getsupplier() + "\n"
												+ "";
	}

}
