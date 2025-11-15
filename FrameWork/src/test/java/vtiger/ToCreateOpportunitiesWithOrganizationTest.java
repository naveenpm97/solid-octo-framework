package vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ObjectUtility;
import objectrepository.VtigerAddNewOpportunityPage;
import objectrepository.VtigerAddNewOrganizationPage;
import objectrepository.VtigerHomePage;
import objectrepository.VtigerOppertunityInformationPage;
import objectrepository.VtigerOpportunitiesPage;
import objectrepository.VtigerOrganizationInformationPage;
import objectrepository.VtigerOrganizationPage;
@Listeners(genericutility.ListnerUtility.class)
public class ToCreateOpportunitiesWithOrganizationTest extends BaseClass{
	
	
	@Test(groups={"smoke","regression"})
	public void createOpportunityWithOrganizationTest() throws IOException {
		int randomNUM = jutil.getRandomNumber();
		VtigerHomePage VHP=new VtigerHomePage(wd);
		VtigerOpportunitiesPage VOP=new VtigerOpportunitiesPage(wd);
		VtigerAddNewOpportunityPage VANO=new VtigerAddNewOpportunityPage(wd);
		VtigerOrganizationPage VOPP=new VtigerOrganizationPage(wd);
		VtigerAddNewOrganizationPage VANOP=new VtigerAddNewOrganizationPage(wd);
		VtigerOrganizationInformationPage VOIP=new VtigerOrganizationInformationPage(wd);
		VtigerOppertunityInformationPage VOInfo=new VtigerOppertunityInformationPage(wd);

		//to verify home page displayed successfully
		Assert.assertTrue(wd.getCurrentUrl().contains("module=Home"),"home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "home page displayed");
		
		String parent = wd.getWindowHandle();
		//to click on organization page
		VHP.getOrganizationLINK().click();
		//to click on create new organization icon
		VOPP.getCreateNewOrganizationIcon().click();
		//to verify create new organization page is displayed
		Assert.assertTrue(VANOP.getCreateNewOrganizationHedder().isDisplayed(),"create new organization page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "create new organization page displayed");
		//creating new organization
		String orgName = eutil.getDataFromExcel("org", 1, 0)+randomNUM;
		VANOP.getOrganizationNameTF().sendKeys(orgName);
		VANOP.getSaveBTN().click();
		//to verify organization created successfully
		Assert.assertTrue(VOIP.getOrganizationInfoHedder().getText().contains(orgName),"organization not created");
		ObjectUtility.getTest().log(Status.INFO, "organization created sucessfully");
		//click on opportunity link
		VHP.getOpportunitiesLINK().click();
		//to verify opportunity page is displayed or not
		Assert.assertTrue(wd.getTitle().contains("Opportunities"),"opportunity page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "opportunity page displayed sucessfully");
		//click on create new opportunity icon
		VOP.getCreateNewOppertunityIcon().click();
		//to verify new opportunity page is displayed
		Assert.assertTrue(VANO.getCreateNewOpportunityHedder().isDisplayed(),"cerate new opportunity page is not displayed");
		ObjectUtility.getTest().log(Status.INFO, "cerate new opportunity page is displayed");
		//creating new opportunity with organization.
		VANO.getOpportunityNameTF().sendKeys(eutil.getDataFromExcel("opportunity", 1,0)+randomNUM);
		VANO.getAddRelateToICON().click();
		wutil.switchToWindow(wd, "Popup_picker");
		VANO.getAddOrgToSearctTF().sendKeys(orgName);
		VANO.getSearchOrgBTN().click();
		wd.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wd.switchTo().window(parent);
		VANO.getSaveBTN().click();
		//to verify opportunity created successfully
		Assert.assertTrue(VOInfo.getOppertunityInfoHedder().isDisplayed(),"opportunity creation falied");
		ObjectUtility.getTest().log(Status.INFO, "opportunity created sucessfully");
		//to verify opportunity created with same organization
		SoftAssert softassert=new SoftAssert();
		softassert.assertTrue(VOInfo.getRelatedToTXTBOX().getText().contains(orgName),"opportunity not created with same organization");
		softassert.assertAll();
	}
}
