package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	
	public ContactInfoPage(WebDriver driver) //test script
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}

	//Business Library
	/**
	 * This method will get the contact header
	 * @return
	 */
	public String getContactText() {
		return ContactHeaderText.getText();
	}
}
