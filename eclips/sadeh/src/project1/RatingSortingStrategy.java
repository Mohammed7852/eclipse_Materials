package project1;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author mohmmed
 */
public class RatingSortingStrategy extends SortingStrategy implements Comparator<Place_Model>{
    
    @Override
    public void sort(){
    
    }

    @Override
    public int compare(Place_Model o1, Place_Model o2) {
       Double rate1=o1.gettotalRate();
       Double rate2=o2.gettotalRate();
       return rate1.compareTo(rate2);
    }
    
}
