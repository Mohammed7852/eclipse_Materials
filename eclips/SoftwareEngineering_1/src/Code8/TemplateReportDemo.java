package Code8;

/**
 * DEMO of TEMPLATE METHOD DESIGN PATTERN
 * This a demo class that shows printing differen kinds of reports
 * using template method print.
 * @author      El-Ramly
 * @version     1.0
 */

public class TemplateReportDemo {
   public static void main(String[] args) {
      AbstractReportGenerator report = new HtmlReportGenerator();
      System.out.println ("Printing HTML Report ....... \n");
      report.printReport();
      report = new TextReportGenerator();
      System.out.println ("\n\nPrinting Text Report ....... \n");
      report.printReport();
   }
}