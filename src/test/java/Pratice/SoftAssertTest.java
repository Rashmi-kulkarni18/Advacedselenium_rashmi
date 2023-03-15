package Pratice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void createCntact()
	{
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		SoftAssert soft= new SoftAssert();
		soft.assertEquals(true, false);
		System.out.println("step4");
		System.out.println("step5");
		soft.assertAll();
		
	}
	@Test
	public void modifycontact()
	{
		System.out.println("sten6");
		System.out.println("step7");
	}

}
