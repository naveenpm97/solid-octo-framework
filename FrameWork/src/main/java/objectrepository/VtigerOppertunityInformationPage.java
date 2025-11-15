package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerOppertunityInformationPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement oppertunityInfoHedder;
	public VtigerOppertunityInformationPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	public WebElement getOppertunityInfoHedder() {
		return oppertunityInfoHedder;
	}
		
	@FindBy(xpath = "//a[@title='Organizations']")
	private WebElement relatedToTXTBOX;
	public WebElement getRelatedToTXTBOX() {
		return relatedToTXTBOX;
	}
	
	
}
