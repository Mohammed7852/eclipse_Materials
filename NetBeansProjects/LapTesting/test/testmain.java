
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testinglap.mainclass;

public class testmain {
    
    mainclass m = new mainclass();
    
    public testmain() {
    }

    @Test
    public void testadd(){
        Assert.assertEquals(m.add(5*0+1, 0), 1);
    }
    @Test
    public void testeven(){
        
    }
    @Test
    public void  testodd(){
        
    }
    @Test
    public void testprime(){
        
    }
    @Test
    public void testdevide(){
        Assert.assertEquals(m.devide(5, 2), 2.5);
    }
   
//    @BeforeClass
//    public static void setUpClass() throws Exception {
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//    }
//
//    @BeforeMethod
//    public void setUpMethod() throws Exception {
//    }
//
//    @AfterMethod
//    public void tearDownMethod() throws Exception {
//    }
//    
}
