package Generic_utitiles;

import java.util.Random;

public class Java_utility {
	
	public int getRanDomNum()
	{
		Random ran=new Random();
		int ranNum= ran.nextInt(1000);
		return ranNum;
	}
	

}
