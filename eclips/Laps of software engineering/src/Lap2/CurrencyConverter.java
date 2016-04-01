package Lap2;
/** A class to demonestrate the use of static data fields and methods
 *  It is a currency converter from $ dollars to Egyptian pounds
 *  Course: Programming Techniques 2 - SWE102 - 2009/2010 - Lab 5
 *  @author Mohammad El-Ramly 
 *  @version 1.00 2010/4/8
 */	

public class CurrencyConverter 
{
   
   static double dollarToLE = 5.5;
   static double euroToLE   = 8.0;
   
  /** This method converts dollars to equivalent Egyptian pounds
   *  @param  dol is the amount of dollars you like to convert
   *  @return the equivalent amount in Egyptian pounds
   */

   public   double Convert_Euro_to_LE(double euro)
   {
	   return euro*euroToLE ;
   }
   public     double convert_LE_to_euro(double LE)
   {
	   return LE/euroToLE ;
   }
   public static double convertDollarToLE (double dol)
   {
       return dol * dollarToLE; 
   }  
   
  /** This method converts Egyptian pounds to the equivalent dollars
   *  @param  Egy is the amount of Egyptian pounds you like to convert
   *  @return the equivalent amount in dollars
   */

   public static double convertLEToDollar (double Egy) {
       return Egy / dollarToLE; 
   }  
}