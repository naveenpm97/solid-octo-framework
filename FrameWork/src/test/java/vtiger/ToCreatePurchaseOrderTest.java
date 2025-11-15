package vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ObjectUtility;
import objectrepository.VtigerAddNewProductPage;
import objectrepository.VtigerCreateNewVendorsPage;
import objectrepository.VtigerHomePage;
import objectrepository.VtigerProductInfoPage;
import objectrepository.VtigerProductPage;
import objectrepository.VtigerVendorInformationPage;
import objectrepository.VtigerVendorsPage;

@Listeners(genericutility.ListnerUtility.class)
public class ToCreatePurchaseOrderTest extends BaseClass {
	
	
	// to create vendor
	@Test(groups={"smoke","regression"})
	public void toCreateVendorTest() throws IOException {
		VtigerHomePage VHP = new VtigerHomePage(wd);
		VtigerVendorsPage VVP=new VtigerVendorsPage(wd);
		VtigerCreateNewVendorsPage VCNVP=new VtigerCreateNewVendorsPage(wd);
		VtigerVendorInformationPage VVIP=new VtigerVendorInformationPage(wd);
		
		// generate random number
		int randomNUM = jutil.getRandomNumber();
		// to verify home page displayed successfully
		Assert.assertTrue(wd.getCurrentUrl().contains("module=Home"), "home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "home page displayed");
		
		
		//mouse hover more and click on vendors link
		wutil.mouseHover(wd, VHP.getMoreLINK());
		VHP.getVendorLINK().click();
		
		//to verify vendor page displayed
		Assert.assertTrue(wd.getCurrentUrl().contains("Vendors&action"), "vendors page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Vendors page displayed");
		
		// to click on create new vendor icon
		VVP.getCreateNewVendorICON().click();
		
		//to verify create new vendor page displayed
		Assert.assertTrue(VCNVP.getCreateNewVendorPageHedder().isDisplayed(), "Create new vendors page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Create new Vendors page displayed");
		
		//adding new vendor
		String vendorName = eutil.getDataFromExcel("vendor", 1, 0)+randomNUM;
		
		VCNVP.getVendorsNameTF().sendKeys(vendorName);
		
		VCNVP.getEmailTF().sendKeys(eutil.getDataFromExcel("vendor", 1, 1));
		
		VCNVP.getPhoneTF().sendKeys(eutil.getDataFromExcel("vendor", 1, 2));
		
		//click on save btn
		VCNVP.getSaveBTN().click();
		
		//verify vendor info page displayed
		Assert.assertTrue(wd.getCurrentUrl().contains("Vendors&record"), "vendors info page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "vendors info page displayed");
		
		//verifying vendor added successfully
		Assert.assertTrue(VVIP.getVendorNameTF().getText().contains(vendorName), "vendors name mismatch");
		ObjectUtility.getTest().log(Status.INFO, "vendors name verified");
		
		Assert.assertTrue(VVIP.getEmailTF().getText().contains(eutil.getDataFromExcel("vendor", 1, 1)), "vendors email mismatch");
		ObjectUtility.getTest().log(Status.INFO, "vendors email verified");
		
	}
	
	//to add product from vendor
	@Test(groups={"regression"})
	public void toCreateProductTest() throws IOException, InterruptedException {
		int randomNUM = jutil.getRandomNumber();
		VtigerHomePage VHP=new VtigerHomePage(wd);
		VtigerProductPage VPP=new VtigerProductPage(wd);
		VtigerAddNewProductPage VANP=new VtigerAddNewProductPage(wd);
		VtigerProductInfoPage VPIO=new VtigerProductInfoPage(wd);
		VtigerVendorsPage VVP=new VtigerVendorsPage(wd);
		VtigerCreateNewVendorsPage VCNVP=new VtigerCreateNewVendorsPage(wd);
		VtigerVendorInformationPage VVIP=new VtigerVendorInformationPage(wd);
		
		
		//mouse hover more and click on vendors link
		wutil.mouseHover(wd, VHP.getMoreLINK());
		VHP.getVendorLINK().click();
		
		// to click on create new vendor icon
		VVP.getCreateNewVendorICON().click();
		
		//to verify create new vendor page displayed
		Assert.assertTrue(VCNVP.getCreateNewVendorPageHedder().isDisplayed(), "Create new vendors page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Create new Vendors page displayed");
		
		//adding new vendor
		String vendorName = eutil.getDataFromExcel("vendor", 1, 0)+randomNUM;
		
		VCNVP.getVendorsNameTF().sendKeys(vendorName);
		
		VCNVP.getEmailTF().sendKeys(eutil.getDataFromExcel("vendor", 1, 1));
		
		VCNVP.getPhoneTF().sendKeys(eutil.getDataFromExcel("vendor", 1, 2));
		
		//click on save btn
		VCNVP.getSaveBTN().click();
		
		Thread.sleep(3000);
		VHP.getProductsLINK().click();
		//to verify product page is displayed or not
		Assert.assertTrue(wd.getTitle().contains("Products"),"product page not displayed");
		ObjectUtility.getTest().log(Status.INFO,"product page displayed sucessfully");
		//click on create new product icon
		VPP.getCreateProductIcon().click();
		//to verify create new product page is displayed or not
		Assert.assertTrue(VANP.getCreatingNewProductHedder().isDisplayed(),"create new product page is not displayed");
		ObjectUtility.getTest().log(Status.INFO,"create new product page is displayed");
		//adding new product
		String productname=eutil.getDataFromExcel("products", 1, 0)+randomNUM;
		VANP.getProductNameTF().sendKeys(productname);
		//click on add vendor icon
		String addNewVendorPageID = wd.getWindowHandle();
		VANP.getAddVendorNameICON().click();
		//switch to add vendor child window pop up
		wutil.switchToWindow(wd, "Vendors&action=Popup&html");
		//String vendorName = eutil.getDataFromExcel("vendor", 1, 0)+randomNUM;
		//select vendor
		VANP.getSearchVendorTF().sendKeys(vendorName);
		VANP.getSearchVendorBTN().click();
		wd.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		//switch back to add new product page
		wd.switchTo().window(addNewVendorPageID);
		//click on save btn
		VANP.getSaveBTN().click();
		//to verify product added successfully
		Assert.assertTrue(VPIO.getProductInfoHedder().getText().contains(productname),"product not created");
		ObjectUtility.getTest().log(Status.INFO,"product created sucessfully");
		
		Assert.assertTrue(VPIO.getVendorNameTF().getText().contains(vendorName),"vendor name mismatch");
		ObjectUtility.getTest().log(Status.INFO,"vendor name verified successfully");
	}
	
	
	
}
