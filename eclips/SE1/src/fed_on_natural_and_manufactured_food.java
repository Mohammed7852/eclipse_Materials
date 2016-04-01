
public class fed_on_natural_and_manufactured_food extends Spanish_Meal{

	fed_on_natural_and_manufactured_food(){}
	
	
	fed_on_natural_and_manufactured_food(double p , double w  ,int  t  , String  s)
	{
		super(p , w , t , s);
	}
	
	public  String toString()
	{
		return  "shipment of type (3) -fed_on_natural_and_manufactured_food- ::\n"
				+ "price  is  :"+getprice()+"\n"
						+ "weigth is  :"+getweight()+"\n"
											+ "supplier is  :"+getsupplier() + "\n"
												+ "";
	}
}
