package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerCreateNewSalesOrderPage {
	@FindBy(xpath = "//span[text()='Creating New Sales Order']")
	private WebElement createNewSaleOrderHedder;
	public VtigerCreateNewSalesOrderPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	public WebElement getCreateNewSaleOrderHedder() {
		return createNewSaleOrderHedder;
	}
	
	@FindBy(xpath = "//input[@name='subject']")
	private WebElement subjectTF;
	public WebElement getSubjectTF() {
		return subjectTF;
	}
	
	@FindBy(xpath = "//select[@name='sostatus']")
	private WebElement statusDD;
	public WebElement getStatusDD() {
		return statusDD;
	}
	
	@FindBy(xpath = "//input[@id='single_accountid']")
	private WebElement organizationNameTF;
	public WebElement getOrganizationNameTF() {
		return organizationNameTF;
	}
	
	@FindBy(xpath = "//input[@id='single_accountid']/../img")
	private WebElement addOrganizationNameICON;
	public WebElement getAddOrganizationNameICON() {
		return addOrganizationNameICON;
	}
	
	@FindBy (xpath="//select[@name='invoicestatus']")
	private WebElement invoiceStatusDD;
	public WebElement getInvoiceStatusDD() {
		return invoiceStatusDD;
	}
	
	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement billingAddressTF;
	public WebElement getBillingAddressTF() {
		return billingAddressTF;
	}
	
	@FindBy(xpath="//textarea[@name='ship_street']")
	private WebElement shipingAddressTF;
	public WebElement getShipingAddressTF() {
		return shipingAddressTF;
	}
	
	@FindBy(xpath="//input[@id='productName1']")
	private WebElement itemNameTF;
	public WebElement getItemNameTF() {
		return itemNameTF;
	}
	
	@FindBy(xpath="//img[@id='searchIcon1']")
	private WebElement additemICON;
	public WebElement getAdditemICON() {
		return additemICON;
	}
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveBTN;
	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	@FindBy(xpath = "//input[@id='qty1']")
	private WebElement getQuantityTF;
	public WebElement getGetQuantityTF() {
		return getQuantityTF;
	}

	//add organization child window elements
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement searchOrganizationTF;
	public WebElement getSearchOrganizationTF() {
		return searchOrganizationTF;
	}
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchOrganizationBTN;
	public WebElement getSearchOrganizationBTN() {
		return searchOrganizationBTN;
	}
	
	//add product child window elements
	
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement searchProductTF;
	public WebElement getSearchProductTF() {
		return searchProductTF;
	}
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchProductBTN;
	public WebElement getSearchProductBTN() {
		return searchProductBTN;
	}
	
	@FindBy(xpath = "(//option[@value='Approved'])[2]")
	private WebElement approved;
	public WebElement getApproved() {
		return approved;
	}
	
	
	
	
	
	
	
	
}
