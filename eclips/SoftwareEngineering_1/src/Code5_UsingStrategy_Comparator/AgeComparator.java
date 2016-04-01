package Code5_UsingStrategy_Comparator;


import java.util.*;
public class AgeComparator implements Comparator<Person> {
  @Override
  public int compare(Person person1, Person person2) {
    Integer age1 = person1.getAge();
    Integer age2 = person2.getAge();
    return age1.compareTo(age2);
  }
}
 