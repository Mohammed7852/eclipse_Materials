package fromsadeh;

 
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.util.ArrayList;

class struct {
    public ArrayList<ArrayList<Integer>>obj;
    public ArrayList<Integer>one;
    public ArrayList<Float>avarage;
    struct() {
        this.obj = new ArrayList<>();
        this.one = new ArrayList<>();
        this.avarage = new ArrayList<>();
    }
public int sizeone(){
    return one.size();
}
public int sizeobj(){
    return obj.size();
}
}
