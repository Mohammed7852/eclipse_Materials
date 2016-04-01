
public class open_natural_grassland  extends Spanish_Meal
{

	
	open_natural_grassland(){}
	
	open_natural_grassland(double p , double w  ,int  t  , String  s)
	{
		super(p , w , t , s);
	}

	 
	 
	
		public  String toString()
		{
			return  "shipment of type(1) -open_natural_grassland-:\n"
					+ "price  is  :"+getprice()+"\n"
							+ "weigth is  :"+getweight()+"\n"
 											+ "supplier is  :"+getsupplier() + "\n"
													+ "";
		}
	
}
