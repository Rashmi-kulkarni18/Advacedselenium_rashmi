package POM_Repo;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);

		
	}
	
	public WebElement getOraganizationLink() {
		return oraganizationLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getSignoutImg() {
		return signoutImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	@FindBy(linkText="Organizations")
	private WebElement oraganizationLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	//business logic for Organization
	public void ClickOrganization()
	{
		oraganizationLink.click();
	}

	//business logic for signout
	public void logout(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.moveToElement(signoutImg).perform();
		signoutLink.click();
	}
	
	
	
	
	

	


	
}

