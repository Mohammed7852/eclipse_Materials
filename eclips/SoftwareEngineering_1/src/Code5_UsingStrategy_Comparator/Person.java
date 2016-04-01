package Code5_UsingStrategy_Comparator;

import java.util.*;

public class Person {
    String    name;
    int       age;
    double    weight;
    Date dateOfBirth;

    public Person(String name, double weight, Date dateOfBirth) {    
        this.name        = name;
        this.weight      = weight;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
     return name;
    }
    
    public double getWeight() {
     return weight;
    }

    public Date getDoB() {
     return dateOfBirth;
    }
    public String toString() {
     return name + ": DoB " + dateOfBirth.toGMTString().substring
       (0,11) + " & Weight " + weight ;
    }

	public Integer getAge() {
		// TODO Auto-generated method stub
		return age;
	}
}