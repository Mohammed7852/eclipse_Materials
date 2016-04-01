package Code5_UsingStrategy_Comparator;


import java.util.*;
public class WeightComparator implements Comparator<Person> {
  @Override
  public int compare(Person person1, Person person2) {
    Double Weight1 = person1.getWeight(); // can you use double instead?
    Double Weight2 = person2.getWeight();
    return Weight1.compareTo(Weight2);
  }
}
 