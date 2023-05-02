package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
    @Test
    public void createUser()
	{
		//Assert.fail();
		System.out.println("createUser");
	}
    
    @Test(dependsOnMethods = "createUser")
    public void modifyUser()
	{
		
		System.out.println("modifyUser");
	}
    
    @Test(enabled = false)
    public void deleteUser()
	{
		
		System.out.println("deleteUser");
	}

}
