package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerProductPage {
	public VtigerProductPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProductIcon;
	public WebElement getCreateProductIcon() {
		return createProductIcon;
	}
	
}
