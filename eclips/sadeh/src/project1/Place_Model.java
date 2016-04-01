package project1;

public class Place_Model {

	private  int   PlaceID ;
	private  String  Placedescription ,PlaceName  ;
	private  int  RatePlace=0;
        private String taste;
        private int RatingPeople=0;
	private  int  NumberOfCheckIN  = 0; 
	private int numberOfSaving=0;
        private String address="";
	//*****
	public void  SavePlace (String name  , int  ID  , String desc){
	setPlacedescription(desc);
	setPlaceID(ID);
	setPlaceName(name);
  	}//
        public void setAddress(String _address){
            address=_address;
        }
        public String getAddress(){
            return address;
        }
	public int getPlaceID() {
		return PlaceID;
	}
public void setTaste(String _taste){
    this.taste=_taste;
}
public String getTaste(){
    return taste;
}
	public void setPlaceID(int placeID) {
		PlaceID = placeID;
	}

	public String getPlacedescription() {
		return Placedescription;
	}
        public void setPlacedescription(String placedescription) {
		Placedescription = placedescription;
	}
       public String getPlaceName() {
		return PlaceName;
	}

       public void setPlaceName(String placeName) {
		PlaceName = placeName;
	}
       public double getRatePlace() {
		return RatePlace/RatingPeople;
	}
       public void setRatePlace(int  numberOfRate) {
		RatingPeople++;
                RatePlace=RatePlace+numberOfRate;
	}
       public int getNumberOfCheckIN() {
		return NumberOfCheckIN;
	}
       public void setNumberOfCheckIN() {
		NumberOfCheckIN++;
	}
       public void setNumberOfSaving(){
           numberOfSaving++;
       }
       public int getNumberOfSavig(){
           return numberOfSaving;
       }
       public double gettotalRate(){
           return (numberOfSaving+NumberOfCheckIN+getRatePlace())/3;
       }

        @Override
        public String toString (){
    return "Place ID: "+getPlaceID()+"\n"+
            "Place Name: "+getPlaceName()+"\n"+
            "Place Description: "+getPlacedescription()+"\n"+
            "Place Taste: "+getTaste()+"\n"+
            "Place Rate: "+gettotalRate()+"\n";
}

	
	
	
}//class 

