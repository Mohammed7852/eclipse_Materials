package project1;

import java.util.ArrayList;

public class ListController {
	ArrayList <Place_Model>place=new ArrayList<>();
    public void showUserCheckIns(SortingStrategy sortingStrategy){
    }
    public ArrayList<Place_Model> sort(String type,String taste){
        if (type.equals("Taste")){
           TasteController temp = new TasteController();
           place=temp.getPlacewithTate(taste);
           place.sort(new TasteSortingStrategy());
           
        }
        else if (type.equals("Rate")){
            Place_Controller temp=new Place_Controller();
            place=temp.getAllPlace();
            place.sort(new RatingSortingStrategy());
            
        }
        else {
           Place_Controller temp=new Place_Controller();
           place=temp.getNearestPlaces();
           place.sort(new NearSortingStrategy());
        }
        return place;
    }
    
}
