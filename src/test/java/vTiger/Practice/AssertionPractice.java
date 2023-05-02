package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void aseertPractice()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("step 1");
		
		
		System.out.println("step 2");
		sa.assertEquals(1, 0); //failed
		
		System.out.println("step 3");
		sa.assertTrue(false); //failed
		
		Assert.assertEquals("hi", "hello"); // Fail
		
		System.out.println("step 4");
		sa.assertAll(); // log all the assertion failures
		
	}
	
	@Test
	public void practice()
	{
		System.out.println("second script step 1");
		Assert.assertEquals(true, true);
		System.out.println("second script step 2");
	}

}
