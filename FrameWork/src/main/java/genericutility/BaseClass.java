package genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import objectrepository.VtigerHomePage;
import objectrepository.VtigerLoginPage;

public class BaseClass {
	public WebDriver wd;
	
	public ExcelUtility eutil =new ExcelUtility();
	public WebdriverUtility wutil=new WebdriverUtility();
	public JavaUtility jutil=new JavaUtility();
	public FileUtility futil=new FileUtility();
	
/*************************************************************************************************************************/	
	
	@BeforeSuite(alwaysRun = true)
	public void reportConfig() {
		
	}
	
	
	@BeforeClass(alwaysRun = true)
		//launch browser
		public void openBrowser() throws IOException {
		
		
		String BROWSER = System.getProperty("browser", futil.getDataFromProperty("browser"));
		
		if(BROWSER.equals("chrome")) {
			wd=new ChromeDriver();
		}else if(BROWSER.equals("edge")) {
			wd=new EdgeDriver();
		}else if(BROWSER.equals("safari")) {
			wd=new SafariDriver();
		}else if(BROWSER.equals("firefox")) {
			wd=new FirefoxDriver();
		}else {
			wd=new ChromeDriver();
		}
		
		ObjectUtility.setDriver(wd);
		
		
		
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws IOException {
		
		String URL = System.getProperty("url", futil.getDataFromProperty("url"));
		String USERNAME = System.getProperty("username", futil.getDataFromProperty("username"));
		String PASSWORD = System.getProperty("password", futil.getDataFromProperty("password"));
		
		VtigerLoginPage VLG =new VtigerLoginPage(wd);
		VLG.login(URL,USERNAME,PASSWORD);
	}
		
	@AfterMethod(alwaysRun = true)
	public void logout() {
		//logout code
		VtigerHomePage VHP=new VtigerHomePage(wd);
		wutil.mouseHover(wd, VHP.getProfileIcon());
		VHP.getSignoutLINK().click();
		
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		//close browser
		wd.quit();
	}
		
	@AfterSuite(alwaysRun = true)
	public void reporBackup() {
		
		System.out.println("report backup done");
		System.out.println("backup done");
	}
}
