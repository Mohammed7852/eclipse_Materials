package project1;

import java.util.Comparator;

public class NearSortingStrategy extends SortingStrategy implements Comparator<Place_Model>{

    @Override
    public void sort(){
        
    }
    @Override
    public int compare(Place_Model o1, Place_Model o2) {
       String name1=o1.getPlaceName();
       String name2=o2.getPlaceName();
       return name1.compareTo(name2);
    }

   

}
