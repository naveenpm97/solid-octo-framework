package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerProductInfoPage {
	public VtigerProductInfoPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productInfoHedder;
	public WebElement getProductInfoHedder() {
		return productInfoHedder;
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Vendor Name']")
	private WebElement vendorNameTF;
	public WebElement getVendorNameTF() {
		return vendorNameTF;
	}
	
}
