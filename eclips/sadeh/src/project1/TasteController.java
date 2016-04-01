package project1;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.ArrayList;
import  java.awt.*;
import javax.swing.*;


public class TasteController extends  JFrame{
	
private ArrayList<User_model> usermodellist=new ArrayList<User_model>();

private ArrayList<BrandModel> brand=new ArrayList<BrandModel>() ;
private  Place_Model  placemodel ;


public TasteController(){
    
}
public void addNewTastetoUser(BrandModel br,TasteModel tast ){

	br.addNewTaste(tast);
    brand.add(br);
}

public void addNewTastetoplace(Place_Model pm){
	
	
	
	
   // pl.addNewTate(tast);
   //place.add(pl);
    
}

public void addNewTastetoUser(User_model user ,TasteModel tast){
    
   tast.adduser(user);
    usermodellist.add(user);

}


public ArrayList<User_model>getUserwithTate(String taste){

	ArrayList<User_model>UserithTaste=new ArrayList<User_model>();
    for(int i=0;i<usermodellist.size();i++){
        for(int j=0;j<usermodellist.get(i).getTaste().size();j++){
        if(usermodellist.get(i).getTaste().get(j).getName().equals(taste))
            UserithTaste.add(usermodellist.get(i));
    }
}
    
    return UserithTaste;
}

public ArrayList<Place_Model>getPlacewithTate(String taste){
    ArrayList<Place_Model>placeithTaste=new ArrayList<Place_Model>();
    
//    for(int i=0;i<place.size();i++){
//        for(int j=0;j<place.get(i).getTaste().size();j++){
//        if(place.get(i).getTaste().get(j).getName().equals(taste))
//            placeithTaste.add(user.get(i));
//    }

//    
//}
 
    return placeithTaste;
}

public ArrayList<BrandModel>getBrandwithTate(String taste){
    ArrayList<BrandModel>brandithTaste=new ArrayList<BrandModel>();
    for(int i=0;i<brand.size();i++){
        for(int j=0;j<brand.get(i).getTaste().size();j++){
        if(brand.get(i).getTaste().get(j).getName().equals(taste))
            brandithTaste.add(brand.get(i));
    }
}
    return brandithTaste;

}

}//class