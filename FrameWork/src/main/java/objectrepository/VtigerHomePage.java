package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerHomePage {
	
	public VtigerHomePage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	@FindBy(xpath = "//td[@class='tabUnSelected']/descendant::a[text()='Organizations']")
	private WebElement organizationLINK;
	public WebElement getOrganizationLINK() {
		return organizationLINK;
	}
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/descendant::a[text()='Contacts']")
	private WebElement contactLINK;
	public WebElement getContactLINK() {
		return contactLINK;
	}
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/descendant::a[text()='Opportunities']")
	private WebElement OpportunitiesLINK;
	public WebElement getOpportunitiesLINK() {
		return OpportunitiesLINK;
	}
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/descendant::a[text()='Products']")
	private WebElement ProductsLINK;
	
	public WebElement getProductsLINK() {
		return ProductsLINK;
	}
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/descendant::a[text()='Documents']")
	private WebElement DocumentsLINK;
	public WebElement getDocumentsLINK() {
		return DocumentsLINK;
	}
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/descendant::a[text()='Email']")
	private WebElement EmailLINK;
	public WebElement getEmailLINK() {
		return EmailLINK;
	}
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/descendant::a[text()='Trouble Tickets']")
	private WebElement TroubleTicketsLink;
	public WebElement getTroubleTicketsLink() {
		return TroubleTicketsLink;
	}
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/descendant::a[text()='Dashboard']")
	private WebElement DashboardLINK;
	public WebElement getDashboardLINK() {
		return DashboardLINK;
	}
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/descendant::a[text()='Leads']")
	private WebElement LeadsLINK;
	public WebElement getLeadsLINK() {
		return LeadsLINK;
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement profileIcon;
	public WebElement getProfileIcon() {
		return profileIcon;
	}
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutLINK;
	public WebElement getSignoutLINK() {
		return signoutLINK;
	}
	
	@FindBy(xpath = "//a[text()='More']")
	private WebElement moreLINK;
	public WebElement getMoreLINK() {
		return moreLINK;
	}
	
	
	
	//below are more options dropdown elements
	
	@FindBy(xpath = "//a[@name='Sales Order']")
	private WebElement salesOrderLINK;
	public WebElement getSalesOrderLINK() {
		return salesOrderLINK;
	}
	
	@FindBy(xpath = "//a[@name='Vendors']")
	private WebElement vendorLINK;
	public WebElement getVendorLINK() {
		return vendorLINK;
	}
	
	
	
}
