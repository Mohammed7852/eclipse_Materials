
public class raised_and_fed_on_natural_food extends Spanish_Meal
{

	raised_and_fed_on_natural_food(){}
	
	raised_and_fed_on_natural_food(double p , double w  ,int  t  , String s)
	{
		super(p , w , t , s);
	}
	
	public  String toString()
	{
		return  "shipment of type (2) -raised_and_fed_on_natural_food- ::\n"
				+ "price  is  :"+getprice()+"\n"
						+ "weigth is  :"+getweight()+"\n"
											+ "supplier is  :"+getsupplier() + "\n"
												+ "";
	}
}
