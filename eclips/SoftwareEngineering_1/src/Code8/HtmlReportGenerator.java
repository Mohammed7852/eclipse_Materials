package Code8;

/**
 * DEMO of TEMPLATE METHOD DESIGN PATTERN
 * This a concrete class report that prints an HTML report 
 * It extends abstract class.
 * @author      El-Ramly
 * @version     1.0
 */
public class HtmlReportGenerator extends AbstractReportGenerator{
   public void printHeader() {
      System.out.println ("<html>\n<head>\n<big>\nTitle of the document <br>\n</big>\n</head>");
   }
   public void printBody(){
      System.out.println ("<body>\nThe content of the document......\n</body>");
   }
   public void printFooter(){
      System.out.println ("</html>");
   }
}