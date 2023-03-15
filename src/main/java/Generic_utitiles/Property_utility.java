package Generic_utitiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property_utility {
	/**
	 * this method is used for login to application
	 * @param Key
	 * @return
	 * @throws IOException
	 */
	
	public String getKeyValue(String Key) throws IOException
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/Commondata.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String Value = pro.getProperty(Key);
		return Value;
	}
	

}
