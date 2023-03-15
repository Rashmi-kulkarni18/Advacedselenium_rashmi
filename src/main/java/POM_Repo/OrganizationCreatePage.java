package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreatePage {
	
	public OrganizationCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusImg;
	
	@FindBy(name="accountname")
	private WebElement OrgName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getPlusImg() {
		return plusImg;
	}

	public WebElement getOrgName() {
		return OrgName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//+img
	public void clickOrganization()
	{
		plusImg.click();
	}
	//orgName
	public void organizationName(String orgname)
	{
		OrgName.sendKeys(orgname);
	}
	//save
	public void saveButton()
	{
		saveButton.click();
		
	}

}
