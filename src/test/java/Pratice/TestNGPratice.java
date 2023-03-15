package Pratice;

import org.testng.annotations.Test;

public class TestNGPratice {
	
	@Test
	public void createContact()
	{
		System.out.println("created");
		//int[] arr= {1,2,3};
		//System.out.println(arr[5]);
		
	}
	@Test(invocationCount=3)
	public void modify()
	{
		System.out.println("modified");
	}
	@Test(dependsOnMethods="createContact")
	public void delete()
	{
		System.out.println("deleted");
	}
}
