/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shimaa Abdelkader 
 * 
 */
public class Refrigerator extends Appliance 
{
    public int high;

    /**
     * default constructor  intilizes the  vlues  of super class appliance  
     * 
     */
    public Refrigerator()
    {
        super(null, null, 0, 0);
    }

    /**
     * parameterized  constructor  assigns  values  to  attributes  
     * 
     * @param high the high of referigerator 
     * @param make 
     * @param mode
     * @param price
     * @param warranty
     */
    
    public Refrigerator(int high, String make, String mode, double price, double warranty) {
        super(make, mode, price, warranty);
        this.high = high;
    }
/**
 * assigns  value to high 
 * @param high    
 */
    public void setHigh(int high) {
        this.high = high;
    }

    /**
     * return high of  this  appliance 
     * @return integer value  high 
     */
    public int getHigh() {
        return high;
    }

     /**
     * @return string  value which is  all referigrateo information 
     */
    public String toString() 
    {
        return (" high"+ high + "make" + getMake() 
        +"mode" + getMode()+"price"+ getPrice()
        + "warranty"+ getWarranty()+"\n");
     }

    
    
    
}
