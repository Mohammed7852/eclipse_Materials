package testinglap;


public class mainclass {

    public int  add(int x  , int y){
        return (x+y);
    }
    public double devide(double x  , double y){
        return (double)(x/y) ;
    }
    public boolean even(int x ){
        boolean temp  =false;
        
        if(x%2==0)temp = true;
        return temp ;
    }
    
    public boolean odd(int x){
        boolean temp =false; 
        if(x%2!=0)temp= true;
        return temp ;
    }
    
    public boolean prime(int x){
        boolean temp = true;
        
        for(int  i=2 ;i<x-1 ;i++){
            if(x%i==0){
                temp =false;
                break;
            }
        }
         return temp ;
    }
}
