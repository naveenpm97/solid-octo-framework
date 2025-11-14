package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerVendorInformationPage {
	public VtigerVendorInformationPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement vendorInfoHedder;
	public WebElement getVendorInfoHedder() {
		return vendorInfoHedder;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Vendor Name']")
	private WebElement vendorNameTF;
	public WebElement getVendorNameTF() {
		return vendorNameTF;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Email']")
	private WebElement emailTF;
	public WebElement getEmailTF() {
		return emailTF;
	}
	@FindBy(xpath = "//td[@id='mouseArea_Phone']")
	private WebElement phoneTF;
	public WebElement getPhoneTF() {
		return phoneTF;
	}
	
	
	
	
}
