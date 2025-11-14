package vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ObjectUtility;
import objectrepository.VtigerAddNewOrganizationPage;
import objectrepository.VtigerAddNewProductPage;
import objectrepository.VtigerCreateNewSalesOrderPage;
import objectrepository.VtigerHomePage;
import objectrepository.VtigerOrganizationInformationPage;
import objectrepository.VtigerOrganizationPage;
import objectrepository.VtigerProductPage;
import objectrepository.VtigerSalesOrderInformationPage;
import objectrepository.VtigerSalesOrderPage;

@Listeners(genericutility.ListnerUtility.class)
public class ToCreateSalesOrderTest extends BaseClass {

	@Test(groups={"smoke"})
	public void createSalesOrderTest() throws IOException {
		VtigerHomePage VHP = new VtigerHomePage(wd);
		VtigerOrganizationPage VOPP = new VtigerOrganizationPage(wd);
		VtigerAddNewOrganizationPage VANOP = new VtigerAddNewOrganizationPage(wd);
		VtigerOrganizationInformationPage VOIP = new VtigerOrganizationInformationPage(wd);
		VtigerProductPage VPP = new VtigerProductPage(wd);
		VtigerAddNewProductPage VANP = new VtigerAddNewProductPage(wd);
		VtigerSalesOrderPage VSOP = new VtigerSalesOrderPage(wd);
		VtigerCreateNewSalesOrderPage VCNSOP = new VtigerCreateNewSalesOrderPage(wd);
		VtigerSalesOrderInformationPage VSOIP = new VtigerSalesOrderInformationPage(wd);
		

		// generate random number
		int randomNUM = jutil.getRandomNumber();

		// to verify home page displayed successfully
		//Assert.assertTrue(wd.getCurrentUrl().contains("module=Home"), "home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "home page displayed");
		// click on product link
		VHP.getProductsLINK().click();

		// to verify product page is displayed or not
		Assert.assertTrue(wd.getTitle().contains("Products"), "product page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "product page displayed sucessfully");

		// click on create new product icon
		VPP.getCreateProductIcon().click();

		// to verify create new product page is displayed or not
		Assert.assertTrue(VANP.getCreatingNewProductHedder().isDisplayed(), "create new product page is not displayed");
		ObjectUtility.getTest().log(Status.INFO, "create new product page is displayed");

		// adding new product
		String productname = eutil.getDataFromExcel("products", 1, 0) + randomNUM;
		VANP.getProductNameTF().sendKeys(productname);
		// click on save
		VANP.getSaveBTN().click();

		// to verify product added successfully
		Assert.assertTrue(VANP.getProductInfoHedder().getText().contains(productname), "product not created");
		ObjectUtility.getTest().log(Status.INFO, "product created sucessfully");

		// add new organization
		// to click on organization page
		VHP.getOrganizationLINK().click();
		//to verify organization page is displayed successfully
		Assert.assertTrue(wd.getTitle().contains("Organizations"),"Organization page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Organization page displayed");
		// to click on create new organization icon
		VOPP.getCreateNewOrganizationIcon().click();
		
		//to verify Create New Organization page is displayed or not
		Assert.assertTrue(VANOP.getCreateNewOrganizationHedder().getText().contains("Creating New Organization"),"Creating New Organization page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Creating New Organization page displayed");
		
		// creating new organization
		String orgName = eutil.getDataFromExcel("org", 1, 0) + randomNUM;
		VANOP.getOrganizationNameTF().sendKeys(orgName);
		//click on save
		VANOP.getSaveBTN().click();
		
		//to verify new organization created successfully
		Assert.assertTrue(VOIP.getOrganizationInfoHedder().getText().contains(orgName),"new organization not created");
		ObjectUtility.getTest().log(Status.INFO, "new organization created successfully");

		// to create sales order
		// mouse hover more and click sales order
		wutil.mouseHover(wd, VHP.getMoreLINK());
		VHP.getSalesOrderLINK().click();
		// to verify sales order page is displayed
		Assert.assertTrue(wd.getTitle().contains("Sales Order"),"sales order page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "sales order page displayed successfully");

		// click on new sales order icon
		VSOP.getCreateNewSalesOrderICON().click();
		// to verify create new sales order page is displayed or not
		Assert.assertTrue(VCNSOP.getCreateNewSaleOrderHedder().isDisplayed(),"create new sales order page is not displayed");
		ObjectUtility.getTest().log(Status.INFO, "create new sales order page is displayed");
		
		// creating sales order
		// entering subject
		VCNSOP.getSubjectTF().sendKeys(eutil.getDataFromExcel("salesorder", 1, 0));
		WebElement statusDD = VCNSOP.getStatusDD();
		// selecting status
		wutil.selectWithText(wd, eutil.getDataFromExcel("salesorder", 2, 1), statusDD);
		String newSaleOrderWinID = wd.getWindowHandle();
		// adding organization
		VCNSOP.getAddOrganizationNameICON().click();
		// switching to add organization child window
		wutil.switchToWindow(wd, "Popup&popuptype");
		// enter organization in search TF
		VCNSOP.getSearchOrganizationTF().sendKeys(orgName);
		// click on search btn
		VCNSOP.getSearchOrganizationBTN().click();
		// click on organization to select
		wd.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		// switch to alert and accept
		wd.switchTo().alert().accept();
		// switch back to parent page
		wd.switchTo().window(newSaleOrderWinID);
		// capture invoice DD
		WebElement invoiceDD = VCNSOP.getInvoiceStatusDD();
		// select option with value
		wutil.selectWithValue(wd, eutil.getDataFromExcel("salesorder", 2, 2), invoiceDD);
		// enter billing address
		VCNSOP.getBillingAddressTF().sendKeys(eutil.getDataFromExcel("salesorder", 1, 3));
		System.out.println("billing address entered");
		// enter shiping address
		VCNSOP.getShipingAddressTF().sendKeys(eutil.getDataFromExcel("salesorder", 1, 4));
		System.out.println("shiping address entered");
		// click on add product icon
		VCNSOP.getAdditemICON().click();
		// switch to add product child window
		wutil.switchToWindow(wd, "inventory_prod&curr");
		// search product
		VCNSOP.getSearchProductTF().sendKeys(productname);
		// click on search btn
		VCNSOP.getSearchProductBTN().click();
		// click on the product to select
		wd.findElement(By.xpath("//a[text()='" + productname + "']")).click();
		// switch back to parent window
		wd.switchTo().window(newSaleOrderWinID);
		// send data to quantity text field
		VCNSOP.getGetQuantityTF().sendKeys(eutil.getDataFromExcel("salesorder", 2, 6));
		// click on save btn
		VCNSOP.getSaveBTN().click();
		
		// to verify sales info page displayed successfully
		Assert.assertTrue(VSOIP.getSalesInfoPageHedder().isDisplayed(),"sales order info page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "sales order info page displayed sucessfully");
		
		// verify subject
		Assert.assertTrue(VSOIP.getSubjectTF().getText().contains(eutil.getDataFromExcel("salesorder", 1, 0)),"subject mismatch");
		ObjectUtility.getTest().log(Status.INFO, "subject verified");
		
		// verify status
		Assert.assertTrue(VSOIP.getStatusTF().getText().contains(eutil.getDataFromExcel("salesorder", 2, 1)),"status mismatch");
		ObjectUtility.getTest().log(Status.INFO, "status verified");
		
		// verify billing address
		Assert.assertTrue(VSOIP.getBillingAddressTF().getText().contains(eutil.getDataFromExcel("salesorder", 1, 3)),"billing address mismatch");
		ObjectUtility.getTest().log(Status.INFO, "billing address verified");
		
		// verify shipping address
		Assert.assertTrue(VSOIP.getShipingAddressTF().getText().contains(eutil.getDataFromExcel("salesorder", 1, 4)),"shiping address mismatch");
		ObjectUtility.getTest().log(Status.INFO, "shiping address verified");
		
		// verify item name
		Assert.assertTrue(VSOIP.getItemNameTF().getText().contains(productname),"added item mismatch");
		ObjectUtility.getTest().log(Status.INFO, "added item verified");
		
		// verify quantity
		Assert.assertTrue(VSOIP.getQuantityTF().getText().contains(eutil.getDataFromExcel("salesorder", 2, 6)),"item quantity mismatch");
		ObjectUtility.getTest().log(Status.INFO, "item quantity verified");
	}
}
