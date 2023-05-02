package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	public OrganizationInfoPage(WebDriver driver) //test script
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}

	//Business library
	/**
	 * This method will get the header text and return it to the caller
	 * @return
	 */
	public String getOrgHeader()
	{
		return OrgHeaderText.getText();
	}
	
	
	
}
