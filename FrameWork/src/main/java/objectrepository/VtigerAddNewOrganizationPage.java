package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerAddNewOrganizationPage {
	public VtigerAddNewOrganizationPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//span[text()='Creating New Organization']")
	private WebElement createNewOrganizationHedder;
	public WebElement getCreateNewOrganizationHedder() {
		return createNewOrganizationHedder;
	}
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement organizationNameTF;
	public WebElement getOrganizationNameTF() {
		return organizationNameTF;
	}
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBTN;
	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDD;
	public WebElement getIndustryDD() {
		return industryDD;
	}
	
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNumberTF;
	public WebElement getPhoneNumberTF() {
		return phoneNumberTF;
	}
	
	
	
	
	
	
}
