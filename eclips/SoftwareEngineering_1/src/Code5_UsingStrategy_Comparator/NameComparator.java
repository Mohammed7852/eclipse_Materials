package Code5_UsingStrategy_Comparator;

import java.util.*;
public class NameComparator implements Comparator<Person> {
  @Override
  
  public int compare(Person person1, Person person2) {
    String name1 = person1.getName();
    String name2 = person2.getName();
    return name1.compareTo(name2);
  }
}
 