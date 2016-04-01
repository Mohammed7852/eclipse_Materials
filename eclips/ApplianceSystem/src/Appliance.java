/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
  * @author Shimaa  Abdelkader  
 */
public abstract  class  Appliance {
    
    private String make,model;
    protected double price,warranty;

    /**
     * parameterized constructor  assigns values  to  appiences  attributes 
     * 
     * @param make means  the  made  of  appliance  
     * @param mode  is the  model 
     * @param price the  price  of  appliance  
     * @param warranty takes  the  warrenty off  appliance  
     */
    
    public Appliance(String make, String mode, double price, double warranty) {
        this.make = make;
        this.model = mode;
        this.price = price;
        this.warranty = warranty;
    }

    /**
     *  get make  method  returns  the  made  of  appliance  
     * @return String  the  made  of  appliance 
     */
    public String getMake() {
        return make;
    }

    /**
     *  getmodel method 
     * @return string valriable  which is  the appliance model 
     */
    public String getMode() {
        return model;
    }

    /**
     * setmake  method   assigns value to made company 
     * @param make value  of  made 
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * set model method  assigns  value  to model of  appliance  
     * @param mode is the  model of  appliance 
     */
    public void setMode(String mode) {
        this.model = mode;
    }

    /**
     * setprice  method assigns  value  to appliance  price 
     * @param price is  the  price  of appliance 
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Assigns waarenty to appliance 
     * @param warranty takes  the  warrenty value  
     */
    public void setWarranty(double warranty) {
        this.warranty = warranty;
    }

    /**
     *  getprice  method to return price 
     * @return  double value  which is  the  price  of appliance 
     */
    public double getPrice() {
        return price;
    }

    /**
     * getwarrenty  method to return the  warrenty information 
     * @return sting value  which os  the  warrenty information 
     */
    public double getWarranty() {
        return warranty;
    }
    
    
    
    
    
}
