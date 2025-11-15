package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerContactInformantionPage {
	public VtigerContactInformantionPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactInfoHedder;
	public WebElement getContactInfoHedder() {
		return contactInfoHedder;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Support Start Date']")
	private WebElement supportStartDateTF;
	public WebElement getSupportStartDateTF() {
		return supportStartDateTF;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Support End Date']")
	private WebElement suppotyEndDateTF;
	public WebElement getSuppotyEndDateTF() {
		return suppotyEndDateTF;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Mobile']")
	private WebElement phoneNumberTF;
	public WebElement getPhoneNumberTF() {
		return phoneNumberTF;
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactInfoPageHedder;
	public WebElement getContactInfoPageHedder() {
		return contactInfoPageHedder;
	}
	
	
}
