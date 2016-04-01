package Lap2;

/** A class to demonestrate toString, equals 
 *  and deep copy on class Car.
 *  Course: Programming Techniques 2 - SWE102 - 2009/2010 - Lab 5
 *  @author Mohammad El-Ramly 
 *  @version 1.00 2010/4/8
 */	

public class Car 
{
	
  private String model;
  private String color;
  private int    year;

  public Car(){}
  
  public Car(String model, String color, int year) {
    this.model = model;
    this.color = color;
    this.year = year;
  }

  public String getModel() {
    return this.model;
  }

  public String getColor() {
    return this.color;
  }

  public int getYear() {
    return this.year;
  }

  /**
   *  (non-Javadoc)
  * @see java.lang.Object#equals(java.lang.Object)
 */
public   boolean equals(Object o)
  {
	  Car c = (Car)o;
 
	  return (this.color==c.color||this.model==c.model||this.year!=c.year);
  
  }


public Car DeepCopy()
{
	Car c =new Car(this.model , this.color , this.year) ;
	
	
//	c.color = color; 
//    c.model= model;
//    c.year=year;
//	
    /**
     */
	 // return new Car(this.model , this.color  , this.year);
	 /**/
    
	return c ;
}
  
  @Override
  public   String  toString()
  {
	  return "this Car is ::"
	  		+ "Model ::"+getModel()+"\n"
	  				+ "Color::"+getColor()+"\n"
	  						+ "Year ::"+getYear()+"\n";
  }
    
  public static void main(String[] args) 
  {
 	  Car c = new  Car("1235D","red", 1950)  ;
 	Car n  ;
 	n= c.DeepCopy();
	System.out.print(n);
   
	
   }//end  main 
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}