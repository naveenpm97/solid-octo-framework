package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerOrganizationInformationPage {
	public VtigerOrganizationInformationPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationInfoHedder;
	public WebElement getOrganizationInfoHedder() {
		return organizationInfoHedder;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Industry']")
	private WebElement industryTF;
	public WebElement getIndustryTF() {
		return industryTF;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Phone']")
	private WebElement phoneNumberTF;
	public WebElement getPhoneNumberTF() {
		return phoneNumberTF;
	}
	
	
}
