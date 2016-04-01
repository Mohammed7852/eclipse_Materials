/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shimaa Abdelkader 
 * 
 */
public class Stove extends Appliance 
{

    
    private String color;

   
    
   /**
    * parametrized  constructor assigns  values  to  Stoev appliance 
    * 
    * @param color
    * @param make
    * @param mode
    * @param price
    * @param warranty
    */
    public Stove(String color, String make, String mode, double price, double warranty) 
    {
        super(make, mode, price, warranty);
        this.color = color;
    }

    /**
     * default constructor initlizes value  of  Stove  
     */
    Stove() 
    {
        super(null,null,0,0); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * methode return color of stove  
     * @return string   value of stoev color 
     */
    public String getColor() {
        return color;
    }

    /**
     * method assigns  collor to stove  
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

     /**
      * method  to show allstove  information 
      * @return string values  
      * overrided from object  class  
      */
    public String toString() 
    {
        return  ("  colorr "+getColor()
        +"make"+getMake() + "  mode "+ getMode() 
        + " price  " +  getPrice()
        +" warranty "+getWarranty()+"\n");
        
	} //To change body of generated methods, choose Tools | Templates.
    
    }
    
    

