package Code8;

/**
 * DEMO of TEMPLATE METHOD DESIGN PATTERN
 * This class represents an abstract report class with a 
 * template method print that describes how all reports 
 * are printed
 * @author      El-Ramly
 * @version     1.0
 */
public abstract class AbstractReportGenerator {
   public void printReport () {
      printHeader();
      printBody();
      printFooter();
   }
   public abstract void printHeader();
   public abstract void printBody();
   public abstract void printFooter();
}