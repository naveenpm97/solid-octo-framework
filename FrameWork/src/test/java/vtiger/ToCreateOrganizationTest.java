package vtiger;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ObjectUtility;
import objectrepository.VtigerAddNewOrganizationPage;
import objectrepository.VtigerHomePage;
import objectrepository.VtigerOrganizationInformationPage;
import objectrepository.VtigerOrganizationPage;

@Listeners(genericutility.ListnerUtility.class)
public class ToCreateOrganizationTest extends BaseClass {
	
	@Test(groups={"regression"})
	public void createOrganizationTest() throws IOException {
		VtigerHomePage VHP=new VtigerHomePage(wd);
		VtigerOrganizationPage VOP=new VtigerOrganizationPage(wd);
		VtigerAddNewOrganizationPage VANO=new VtigerAddNewOrganizationPage(wd);
		VtigerOrganizationInformationPage VOIP=new VtigerOrganizationInformationPage(wd);
		//to verify home page displayed successfully
		Assert.assertTrue(wd.getCurrentUrl().contains("module=Home"),"home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "homepage displayed sucessfully");
		//click on organization link
		VHP.getOrganizationLINK().click();
		//to verify organization page is displayed successfully
		Assert.assertTrue(wd.getTitle().contains("Organizations"),"Organization page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Organization page displayed");
		//click on create new image for organization [+ image]
		VOP.getCreateNewOrganizationIcon().click();
		//to verify Create New Organization page is displayed or not
		Assert.assertTrue(VANO.getCreateNewOrganizationHedder().getText().contains("Creating New Organization"),"Creating New Organization page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Creating New Organization page displayed");
		//creating new organization
		int randomNUM = jutil.getRandomNumber();
		String ORGNAME1=eutil.getDataFromExcel("org", 1, 0)+randomNUM;
		VANO.getOrganizationNameTF().sendKeys(ORGNAME1);
		VANO.getSaveBTN().click();
		//to verify new organization created successfully
		Assert.assertTrue(VOIP.getOrganizationInfoHedder().getText().contains(ORGNAME1),"new organization not created");
		ObjectUtility.getTest().log(Status.INFO, "new organization created successfully");
	}
	
	
	@Test(groups={"smoke","regression"})
	public void createOrgWithIndustryTest() throws IOException {
		VtigerHomePage VHP=new VtigerHomePage(wd);
		VtigerOrganizationPage VOP=new VtigerOrganizationPage(wd);
		VtigerAddNewOrganizationPage VANO=new VtigerAddNewOrganizationPage(wd);
		VtigerOrganizationInformationPage VOIP=new VtigerOrganizationInformationPage(wd);
		
		// to verify home page displayed successfully
		Assert.assertTrue(wd.getCurrentUrl().contains("module=Home"),"home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "homepage displayed sucessfully");
		
		// click on organization link
		VHP.getOrganizationLINK().click();
		// to verify organization page is displayed successfully
		Assert.assertTrue(wd.getTitle().contains("Organizations"),"Organization page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Organization page displayed");
		
		// click on create new image [+ image]
		VOP.getCreateNewOrganizationIcon().click();
		// to verify Create New Organization page is displayed or not
		Assert.assertTrue(VANO.getCreateNewOrganizationHedder().getText().contains("Creating New Organization"),"Creating New Organization page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Creating New Organization page displayed");
		
		// creating new organization with industry
		//entering org name
		int randomNUM = jutil.getRandomNumber();
		String ORGNAME1=eutil.getDataFromExcel("org", 1, 0)+randomNUM;
		VANO.getOrganizationNameTF().sendKeys(ORGNAME1);
		
		// selecting industry type
		WebElement industryDD=VANO.getIndustryDD();
		wutil.selectWithValue(wd,eutil.getDataFromExcel("org",1, 2) , industryDD);
		//click on save
		VANO.getSaveBTN().click();

		// to verify organization is created successfully
		Assert.assertTrue(VOIP.getOrganizationInfoHedder().getText().contains(ORGNAME1),"new organization not created");
		ObjectUtility.getTest().log(Status.INFO, "new organization created successfully");
		// to verify industry selection
		Assert.assertTrue(VOIP.getIndustryTF().getText().contains(eutil.getDataFromExcel("org",1, 2)),"industry not selected or mismatch");
		ObjectUtility.getTest().log(Status.INFO, "industry selection verified and successfull");
	}
	
	
	@Test(groups={"smoke"})
	public void createOrgWithPhonenumberTest() throws IOException {
		VtigerHomePage VHP=new VtigerHomePage(wd);
		VtigerOrganizationPage VOP=new VtigerOrganizationPage(wd);
		VtigerAddNewOrganizationPage VANO=new VtigerAddNewOrganizationPage(wd);
		VtigerOrganizationInformationPage VOIP=new VtigerOrganizationInformationPage(wd);
		
		// to verify home page displayed successfully
	//	Assert.assertTrue(wd.getCurrentUrl().contains("module=Home"),"home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "homepage displayed sucessfully");
		//click on organization link
		VHP.getOrganizationLINK().click();		
		// to verify organization page is displayed successfully
		Assert.assertTrue(wd.getTitle().contains("Organizations"),"Organization page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Organization page displayed");
		
		// click on create new image [+ image]
		VOP.getCreateNewOrganizationIcon().click();
		// to verify Create New Organization page is displayed or not
		Assert.assertTrue(VANO.getCreateNewOrganizationHedder().getText().contains("Creating New Organization"),"Creating New Organization page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Creating New Organization page displayed");

		// creating new organization with industry
		// entering org name
		int randomNUM = jutil.getRandomNumber();
		String ORGNAME1 = eutil.getDataFromExcel("org", 1, 0) + randomNUM;
		VANO.getOrganizationNameTF().sendKeys(ORGNAME1);

		// selecting industry type
		WebElement industryDD = VANO.getIndustryDD();
		wutil.selectWithValue(wd, eutil.getDataFromExcel("org", 1, 2), industryDD);
		
		// adding phone number
		VANO.getPhoneNumberTF().sendKeys(eutil.getDataFromExcel("org", 1, 1));
		//click on save
		VANO.getSaveBTN().click();		
		
		// to verify organization is created successfully
		Assert.assertTrue(VOIP.getOrganizationInfoHedder().getText().contains(ORGNAME1),"new organization not created");
		ObjectUtility.getTest().log(Status.INFO, "new organization created successfully");
		// to verify industry selection
		Assert.assertTrue(VOIP.getIndustryTF().getText().contains(eutil.getDataFromExcel("org",1, 2)),"industry not selected or mismatch");
		ObjectUtility.getTest().log(Status.INFO, "industry selection verified and successfull");
		
		// to verify phone number
		Assert.assertTrue(VOIP.getPhoneNumberTF().getText().contains(eutil.getDataFromExcel("org",1, 1)),"phone number mismatch");
		ObjectUtility.getTest().log(Status.INFO, "phone number verified successfully");
		
	}
}
