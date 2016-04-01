package Code5_UsingStrategy_Comparator;

import java.util.*;
public class DoBComparator implements Comparator<Person> {
  @Override
  public int compare(Person person1, Person person2) {
    Date dateOfBirth1 = person1.getDoB();
    Date dateOfBirth2 = person2.getDoB();
    return dateOfBirth1.compareTo(dateOfBirth2);
  }
}
 