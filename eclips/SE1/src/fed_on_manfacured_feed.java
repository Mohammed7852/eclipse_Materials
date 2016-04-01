
public class fed_on_manfacured_feed extends Spanish_Meal
{

	fed_on_manfacured_feed(){}
	
	fed_on_manfacured_feed(double p , double w  ,int  t  , String  s)
	{
		super(p , w , t , s);
	}
	
	
	public  String toString()
	{
		return  "shipment  of type (4) -fed_on_manfacured_feed- ::\n"
				+ "price  is  :"+getprice()+"\n"
						+ "weigth is  :"+getweight()+"\n"
											+ "supplier is  :"+getsupplier() + "\n"
												+ "";
	}
}
