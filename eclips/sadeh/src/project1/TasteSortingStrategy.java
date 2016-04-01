package project1;

import java.util.Comparator;

public class TasteSortingStrategy extends SortingStrategy implements Comparator<Place_Model>{
@Override
public void sort(){
    
}
    @Override
    public int compare(Place_Model o1, Place_Model o2) {
        String taste1=o1.getTaste();
        String taste2=o2.getTaste();
        return taste1.compareTo(taste2);
    }

}
