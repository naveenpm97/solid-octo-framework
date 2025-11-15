package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerContactPage {
	public VtigerContactPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactICON;
	public WebElement getCreateContactICON() {
		return createContactICON;
	}
	
	
	
}
