package project1;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.util.ArrayList;

/**
 *
 * @author c w
 */

public class BrandController {
	
ArrayList<BrandModel> brand=new ArrayList<BrandModel>();
ArrayList<User_model> fuser=new ArrayList<User_model>();
private BrandModel obj;
private User_model user;
public BrandController(BrandModel b){
	
  // obj =new BrandModel();
   obj=b;
   
}
public void saveBrand(Premium_User user){
    BrandModel b=user.createBrand();
    brand.add(new BrandModel(b));
}
public void deleteBrand(String name){
    for(int i=0;i<brand.size();i++){
        if(name.equals(brand.get(i).getBrandName()))
            brand.remove(i);
    }
}
    public void updateBrand(String name ,BrandModel m){
         for(int i=0;i<brand.size();i++){
        if(name.equals(brand.get(i).getBrandName())){
            brand.remove(i);
             brand.add(i, m);
        }
    }
    
}
    
public BrandModel getBrand(String name){
     for(int i=0;i<brand.size();i++){
        if(name.equals(brand.get(i).getBrandName())){
            return brand.get(i);
       }
}
     
return null;
}


public void create_Tip(String text,Place_Model place){
	
    //System.out.println("this place "+place.getName()+"has "+text);
}

public void followBrand(User_model user){
    fuser.add(user);
}



}