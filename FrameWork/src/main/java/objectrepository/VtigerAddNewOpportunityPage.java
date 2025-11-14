package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerAddNewOpportunityPage {
	@FindBy(xpath = "//span[text()='Creating New Opportunity']")
	private WebElement createNewOpportunityHedder;
	public VtigerAddNewOpportunityPage(WebDriver wd) {
		PageFactory.initElements(wd,this);
	}
	public WebElement getCreateNewOpportunityHedder() {
		return createNewOpportunityHedder;
	}
	
	@FindBy(xpath = "//input[@name='potentialname']")
	private WebElement opportunityNameTF;
	public WebElement getOpportunityNameTF() {
		return opportunityNameTF;
	}
	
	@FindBy(xpath = "//input[@name='potentialname']")
	private WebElement opportunityNameTF1;
	public WebElement getOpportunityNameTF1() {
		return opportunityNameTF1;
	}
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBTN;
	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	@FindBy(xpath = "(//img[@alt='Select'])[1]")
	private WebElement addRelateToICON;
	public WebElement getAddRelateToICON() {
		return addRelateToICON;
	}
	
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement addOrgToSearctTF;
	public WebElement getAddOrgToSearctTF() {
		return addOrgToSearctTF;
	}
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchOrgBTN;
	public WebElement getSearchOrgBTN() {
		return searchOrgBTN;
	}
	
	
	
}
