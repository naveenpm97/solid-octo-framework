package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerSalesOrderInformationPage {
	public VtigerSalesOrderInformationPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement salesInfoPageHedder;
	public WebElement getSalesInfoPageHedder() {
		return salesInfoPageHedder;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Subject']")
	private WebElement SubjectTF;
	public WebElement getSubjectTF() {
		return SubjectTF;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Status']")
	private WebElement StatusTF;
	public WebElement getStatusTF() {
		return StatusTF;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']")
	private WebElement OrganizationNameTF;
	public WebElement getOrganizationNameTF() {
		return OrganizationNameTF;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Billing Address']")
	private WebElement BillingAddressTF;
	public WebElement getBillingAddressTF() {
		return BillingAddressTF;
	}
	
	@FindBy(xpath = "//span[@id='dtlview_Shipping Address']")
	private WebElement ShipingAddressTF;
	public WebElement getShipingAddressTF() {
		return ShipingAddressTF;
	}
	
	@FindBy(xpath = "(//table[@id='proTab']/descendant::tr/td[@class='crmTableRow small lineOnTop'])[1]")
	private WebElement ItemNameTF;
	public WebElement getItemNameTF() {
		return ItemNameTF;
	}
	
	@FindBy(xpath = "(//table[@id='proTab']/descendant::tr/td[@class='crmTableRow small lineOnTop'])[3]")
	private WebElement QuantityTF;
	public WebElement getQuantityTF() {
		return QuantityTF;
	}
	
}    
     