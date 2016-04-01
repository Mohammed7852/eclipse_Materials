/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shimaa  Abdelkader 
  */

public class WashingMachine extends Appliance 
{
    public String type;

    /**
     * parameterizes  constructor  
     * @param type
     * @param make
     * @param mode
     * @param price
     * @param warranty
     */
    public WashingMachine(String type, String make, String mode, double price, double warranty) 
    {
        super(make, mode, price, warranty);
        this.type = type;
    }

    /**
     * default  constructor  intilizes value  of  washing  machine 
     */
    WashingMachine() 
    {
     super(null,null,0,0); //To change body of generated methods, choose Tools | Templates.
    }
    
     public String toString() 
     {
        return (" type"+ type + "make" + getMake() +"mode" + getMode()+"price"+ price+ "warranty"+ warranty);//To change body of generated methods, choose Tools | Templates.
      }
        
    
    
}
