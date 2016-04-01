package Code8;

/**
 * DEMO of TEMPLATE METHOD DESIGN PATTERN
 * This a concrete class report that prints a text report 
 * It extends abstract class.
 * @author      El-Ramly
 * @version     1.0
 */
public class TextReportGenerator extends AbstractReportGenerator{
   public void printHeader() {
      System.out.println ("\nReport Header\n---------------");
   }
   public void printBody(){
      System.out.println ("Report Body\nReport Body\nReport Body\n---------------");
   }
   public void printFooter(){
      System.out.println ("Report Footer\n---------------");
   }
}