package test;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class mainTest {

	private  main m = new  main();
	@Test
	public  void testadd() {
		
		Assert.assertEquals(m.add(5, 6), 11);
 	}
	@Test
	public  void  testeven(){
		Assert.assertEquals(m.even(4), true); 
	}
	
	@Test
	public void  testodd(){
		 Assert.assertEquals(m.odd(5), true);
	}
	@Test
	public void  testprime(){
		
		Assert.assertEquals(m.prime(111), true);
	}

//	public  static  void  main(String  []args){
//		mainTest m = new  mainTest();
//		m.testadd();
//		m.testeven();
//		m.testodd();
//		m.testprime();
//		
//	}
}
