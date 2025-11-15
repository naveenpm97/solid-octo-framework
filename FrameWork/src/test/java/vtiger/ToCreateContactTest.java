package vtiger;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ObjectUtility;
import objectrepository.VtigerContactInformantionPage;
import objectrepository.VtigerContactPage;
import objectrepository.VtigerCreateNewContactPage;
import objectrepository.VtigerHomePage;

@Listeners(genericutility.ListnerUtility.class)
public class ToCreateContactTest extends BaseClass {
	
	
	@Test(groups="smoke")
	public void createContactTest() throws IOException {
		VtigerHomePage VHP = new VtigerHomePage(wd);
		
		VtigerContactPage VCP = new VtigerContactPage(wd);
		VtigerCreateNewContactPage VCNCP = new VtigerCreateNewContactPage(wd);
		VtigerContactInformantionPage VCIP = new VtigerContactInformantionPage(wd);
		
		// to verify home page displayed successfully
		Assert.assertTrue(wd.getCurrentUrl().contains("module=Home"), "home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "home page displayed");
		// click on contact link
		VHP.getContactLINK().click();
		// to verify contact page displayed successfully
		Assert.assertTrue(wd.getTitle().contains("Contacts"), "Contacts page not displayed");
		ObjectUtility.getTest().log(Status.INFO,"Contacts page displayed");
		// click on add contact icon
		VCP.getCreateContactICON().click();
		// to verify Create New Contact page is displayed or not
		Assert.assertTrue(VCNCP.getCreateNewContactHedder().getText().contains("Creating New Contact"));		
		ObjectUtility.getTest().log(Status.INFO,"Creating New Contact page displayed");
		// creating new contact with last name
		String lastname = eutil.getDataFromExcel("contact", 1, 0) + jutil.getRandomNumber();
		VCNCP.getLastNameTF().sendKeys(lastname);
		VCNCP.getSaveBTN().click();
		// to verify new contact created successfully
		Assert.assertTrue(VCIP.getContactInfoPageHedder().getText().contains(lastname), "new contact not created");
		ObjectUtility.getTest().log(Status.INFO,"new contact created successfully");
	}

		@Test(groups={"smoke","regression"})
	public void createContactWithDateTest() throws IOException {
		VtigerHomePage VHP = new VtigerHomePage(wd);
		VtigerContactPage VCP = new VtigerContactPage(wd);
		VtigerCreateNewContactPage VCNCP = new VtigerCreateNewContactPage(wd);
		VtigerContactInformantionPage VCIP = new VtigerContactInformantionPage(wd);
		SoftAssert softAssert = new SoftAssert();
		// to verify home page displayed successfully
		Assert.assertTrue(wd.getCurrentUrl().contains("module=Home"), "home page not displayed");
		ObjectUtility.getTest().log(Status.INFO,"home page displayed");
		// click on create new contact icon
		VHP.getContactLINK().click();
		// to verify contact page displayed successfully
		Assert.assertTrue(wd.getTitle().contains("Contacts"), "Contacts page not displayed");
		ObjectUtility.getTest().log(Status.INFO,"Contacts page displayed");
		// to verify Create New Contact page is displayed or not
		VCP.getCreateContactICON().click();
		// to verify Create New Contact page is displayed or not
		Assert.assertTrue(VCNCP.getCreateNewContactHedder().getText().contains("Creating New Contact"),"Creating New Contact page not displayed");		
		ObjectUtility.getTest().log(Status.INFO,"Creating New Contact page displayed");

		// creating new contact with last name
		String lastname = eutil.getDataFromExcel("contact", 1, 0) + jutil.getRandomNumber();
		VCNCP.getLastNameTF().sendKeys(lastname);// entering name
		String PHNO = eutil.getDataFromExcel("contact", 1, 1);
		VCNCP.getPhoneNumberTF().sendKeys(PHNO);// entering phone number
		String startdate = VCNCP.getSupportStartDate().getDomProperty("value");// capturing current date
		WebElement enddate = VCNCP.getSupportEndDate();
		enddate.clear();
		enddate.sendKeys(jutil.getRequiredDate());// entering required date
		//below getAttribute() method is deprecated instead use getDomProperty() method
		//String EndDate = enddate.getAttribute("value");
		String EndDate = enddate.getDomProperty("value");
		VCNCP.getSaveBTN().click();// click on save
		// verify contact created with same data
		Assert.assertTrue(VCIP.getContactInfoPageHedder().getText().contains(lastname), "new contact not created");
		ObjectUtility.getTest().log(Status.INFO,"new contact created successfully");
		// to verify phone number
		String actPhNo = VCIP.getPhoneNumberTF().getText().trim();
		softAssert.assertEquals(PHNO, actPhNo);
		// to verify start date
		String actStartDate = VCIP.getSupportStartDateTF().getText().trim();
		softAssert.assertEquals(startdate, actStartDate);

		// to verify end date
		String actEndDate = VCIP.getSuppotyEndDateTF().getText().trim();
		softAssert.assertEquals(EndDate, actEndDate);
		softAssert.assertAll();
	}

	@Test(groups={"regression"})
	public void CreateContactWithPhoneNumberTest() throws IOException {
		VtigerHomePage VHP = new VtigerHomePage(wd);
		VtigerContactPage VCP = new VtigerContactPage(wd);
		VtigerCreateNewContactPage VCNCP = new VtigerCreateNewContactPage(wd);
		VtigerContactInformantionPage VCIP = new VtigerContactInformantionPage(wd);
		SoftAssert softAssert = new SoftAssert();
		// to verify home page displayed successfully
		Assert.assertTrue(wd.getCurrentUrl().contains("module=Home"), "home page not displayed");
		ObjectUtility.getTest().log(Status.INFO,"home page displayed");
		// click on create new contact icon
		VHP.getContactLINK().click();
		// to verify contact page displayed successfully
		Assert.assertTrue(wd.getTitle().contains("Contacts"), "Contacts page not displayed");
		ObjectUtility.getTest().log(Status.INFO,"Contacts page displayed");
		// click on create New Contact icon
		VCP.getCreateContactICON().click();
		// to verify Create New Contact page is displayed or not
		Assert.assertTrue(VCNCP.getCreateNewContactHedder().getText().contains("Creating New Contact"),"Creating New Contact page not displayed");		
		ObjectUtility.getTest().log(Status.INFO,"Creating New Contact page displayed");

		// creating new contact with last name
		String lastname = eutil.getDataFromExcel("contact", 1, 0) + jutil.getRandomNumber();
		VCNCP.getLastNameTF().sendKeys(lastname);// entering name
		String PHNO = eutil.getDataFromExcel("contact", 1, 1);
		VCNCP.getPhoneNumberTF().sendKeys(PHNO);// entering phone number
		VCNCP.getSaveBTN().click();// click on save

		// verify contact created with same data
		Assert.assertTrue(VCIP.getContactInfoPageHedder().getText().contains(lastname), "new contact not created");
		ObjectUtility.getTest().log(Status.INFO,"new contact created successfully");
		// to verify phone number
		String actPhNo = VCIP.getPhoneNumberTF().getText().trim();
		softAssert.assertEquals(PHNO, actPhNo);
		softAssert.assertAll();
	}
}
