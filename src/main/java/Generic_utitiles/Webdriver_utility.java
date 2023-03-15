package Generic_utitiles;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

public class Webdriver_utility {
	public void switchWindow(WebDriver driver, String PartialWindowTitle)
	{
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> it = allid.iterator();
		while(it.hasNext())
		{
			String wid= it.next();
			driver.switchTo().window(wid);
			String title = driver.getTitle();
			if(title.contains(PartialWindowTitle))
			{
				break;
			}
		}
	}
		public void window_mode(WebDriver driver, Boolean maximize)
		{
			if(maximize.booleanValue()==true)
			{
				driver.manage().window().maximize();
				System.out.println("Started windows in maximized mode");
		}
		
	}

}
