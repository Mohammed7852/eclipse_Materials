package Code5_UsingStrategy_Comparator;

import java.util.*;
public class TestComparator {
	
	
  public static void main(String[] args) {
	  
     List<Person> people = new ArrayList<Person>();
     people.add( new Person("Sami", 8.3, new Date (1980, 12, 17)));
     people.add( new Person("Lila", 59.1, new Date (1991, 1, 23)));
     people.add( new Person("Amin", 45, new Date (2001, 4, 30)));
     people.add( new Person("Mina", 35.8, new Date (2005, 5, 11)));

     // Sort by natural order
     
     people.sort(new WeightComparator());
     System.out.println("Sort by Weight:");
     int i = 1;
     for (Person p: people)
       System.out.println(Integer.toString(i++) + "- " + p);

     people.sort(new NameComparator());
     System.out.println("\nSort by Name:");
     i = 1;
     for (Person p: people)
       System.out.println((new Integer(i++)).toString() + "- " + p);

       people.sort(new DoBComparator());
     System.out.println("\nSort by DoB:");
     i = 1;
     for (Person p: people)
       System.out.println((new Integer(i++)).toString() + "- " + p);
}  
}