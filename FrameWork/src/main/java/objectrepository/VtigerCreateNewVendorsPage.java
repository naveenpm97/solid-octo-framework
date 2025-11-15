package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerCreateNewVendorsPage {
	public VtigerCreateNewVendorsPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement createNewVendorPageHedder;
	public WebElement getCreateNewVendorPageHedder() {
		return createNewVendorPageHedder;
	}
	
	@FindBy(xpath = "//input[@name='vendorname']")
	private WebElement vendorsNameTF;
	public WebElement getVendorsNameTF() {
		return vendorsNameTF;
	}
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailTF;
	public WebElement getEmailTF() {
		return emailTF;
	}
			
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneTF;
	public WebElement getPhoneTF() {
		return phoneTF;
	}
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBTN;
	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	
}
