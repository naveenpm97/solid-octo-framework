package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerVendorsPage {
	public VtigerVendorsPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Vendor...']")
	private WebElement createNewVendorICON;
	public WebElement getCreateNewVendorICON() {
		return createNewVendorICON;
	}
	
}
