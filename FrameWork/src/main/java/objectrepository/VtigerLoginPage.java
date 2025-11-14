package objectrepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutility.FileUtility;
import genericutility.WebdriverUtility;

public class VtigerLoginPage {
	
	WebDriver wd;
	public VtigerLoginPage(WebDriver wd) {
		this.wd = wd;
		PageFactory.initElements(wd, this);
	}
	@FindBy(name = "user_name")
	private WebElement usernameTF;
	public WebElement getUsernameTF() {
		return usernameTF;
	}
	
	@FindBy(name = "user_password")
	private WebElement passwordTF;
	public WebElement getPasswordTF() {
		return passwordTF;
	}
	
	@FindBy(id = "submitButton")
	private WebElement loginBTN;
	public WebElement getLoginBTN() {
		return loginBTN;
	}
	
	public void login(String URL,String UN, String PWD) throws IOException {
		WebdriverUtility wutil=new WebdriverUtility();
		
		
		wutil.maximize(wd);
		wutil.implicitWait(wd);
		
		wd.get(URL);
		usernameTF.sendKeys(UN);
		passwordTF.sendKeys(PWD);
		loginBTN.click();
	}
}
