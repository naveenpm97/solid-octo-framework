package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerOpportunitiesPage {
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement createNewOppertunityIcon;
	public VtigerOpportunitiesPage(WebDriver wd) {
		PageFactory.initElements(wd,this);
	}
	public WebElement getCreateNewOppertunityIcon() {
		return createNewOppertunityIcon;
	}
	
}
