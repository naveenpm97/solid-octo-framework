package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerOrganizationPage {
	public VtigerOrganizationPage(WebDriver wd) {
		PageFactory.initElements(wd,this);
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateNewOrganizationIcon;
	public WebElement getCreateNewOrganizationIcon() {
		return CreateNewOrganizationIcon;
	}
	
	
}
