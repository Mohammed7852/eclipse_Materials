package project1;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
/**
 *
 * @author c w
 */

import  java.util.*;

public class TasteModel {
String tastename;
String descp;
List<User_model> usermodeltaste  = new  ArrayList();

 public TasteModel(){
    
}

 public void adduser(User_model user){
     usermodeltaste .add(user);
     
 }
public void setName(String name){
 tastename=name;   
}
public void setdescp(String des){

descp=des;
}
public String getName(){
return tastename;
}

public String getdescp(){
return descp;
}



    public void  addnewtaste (){
        
    }
}
