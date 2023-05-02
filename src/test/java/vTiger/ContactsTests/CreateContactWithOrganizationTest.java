package vTiger.ContactsTests;

import static org.testng.Assert.fail;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;


@Listeners(vTiger.GenericUtilities.ListenersImplementationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass{

	@Test
	public void createContactWithOrgTest() throws IOException
	 {

		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3) + jUtil.getRandomNumber();

		// Step 3: Navigate to Organizations LInk
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();

		// Step 4: click on Create Organization Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		// Step 5: Create Organization with Mnadatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrg(ORGNAME);

		// Step 7: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		//Assert.fail();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
		/* Create Contact Using the same Organization */
		// Step 9: Navigate  contact link
        hp.clickOnContactLink();		

		// Step 10: click on Create Contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		//Step 11: create conatct
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);

		// Step 17: Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String ContactHeader = cip.getContactText();
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
	
		

	}

}
