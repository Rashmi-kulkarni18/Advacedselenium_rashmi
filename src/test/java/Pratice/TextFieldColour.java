package Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextFieldColour {

	public static void main(String[] args) {
		//launching browser
		String key="webdriver.chrome.driver";
		//String value="./src/main/resourceschromedriver.exe";
		String value="C:\\Users\\sachin joshi\\eclipse-workspace\\Framework\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		WebElement email=driver.findElement(By.name("email"));
		WebElement password=driver.findElement(By.name("pass"));
		String Email=email.getCssValue("color");
		String Password=password.getCssValue("color");
		System.out.println(Email);
		System.out.println(Password);
		

	}

}
