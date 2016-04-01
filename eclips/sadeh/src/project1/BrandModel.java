package project1;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author c w
 */
public class BrandModel {
    ArrayList<TasteModel>taste=new ArrayList<TasteModel>();
    String name;
    String TwitterLink;
    String FacebookLink;
    public BrandModel(BrandModel b){
    	
    }
public  ArrayList<TasteModel>getTaste(){
    return taste;
}    
public void setBrandName(String bname){
    name=bname;
}
public void setTwitterLink(String link){
    TwitterLink=link;
}
public void setFacebookLink(String link){
    FacebookLink=link;
}
public String getFacebookLink(){
    return FacebookLink;
}

public String getBrandName(){
    return name;
}

public String getTwitterLink(){
    return TwitterLink;
}

public void addNewTaste(TasteModel tast){
    taste.add(tast);
}




}
