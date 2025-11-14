package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerCreateNewContactPage {
	public VtigerCreateNewContactPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	@FindBy(xpath = "//span[text()='Creating New Contact']")
	private WebElement createNewContactHedder;
	public WebElement getCreateNewContactHedder() {
		return createNewContactHedder;
	}
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameTF;
	public WebElement getLastNameTF() {
		return lastNameTF;
	}
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBTN;
	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	
	
	@FindBy (xpath = "//input[@id='mobile']")
	private WebElement phoneNumberTF;
	public WebElement getPhoneNumberTF() {
		return phoneNumberTF;
	}
	
	@FindBy(xpath = "//input[@name='support_start_date']")
	private WebElement supportStartDate;
	public WebElement getSupportStartDate() {
		return supportStartDate;
	}
	
	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement supportEndDate;
	public WebElement getSupportEndDate() {
		return supportEndDate;
	}
	
}
