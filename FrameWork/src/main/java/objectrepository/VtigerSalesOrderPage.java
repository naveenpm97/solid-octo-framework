package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerSalesOrderPage {
	public VtigerSalesOrderPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Sales Order...']")
	private WebElement createNewSalesOrderICON;
	public WebElement getCreateNewSalesOrderICON() {
		return createNewSalesOrderICON;
	}
	
	
}
