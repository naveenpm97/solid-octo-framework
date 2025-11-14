package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerAddNewProductPage {
	public VtigerAddNewProductPage(WebDriver wd) {
		PageFactory.initElements(wd,this);
	}
	@FindBy(xpath = "//input[@name='productname']")
	private WebElement productNameTF;
	public WebElement getProductNameTF() {
		return productNameTF;
	}
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBTN;
	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	
	@FindBy(xpath = "//span[text()='Creating New Product']")
	private WebElement creatingNewProductHedder;
	public WebElement getCreatingNewProductHedder() {
		return creatingNewProductHedder;
	}
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement addVendorNameICON;
	public WebElement getAddVendorNameICON() {
		return addVendorNameICON;
	}
	
	@FindBy(xpath = "//input[@name='vendor_name']")
	private WebElement vendorNameTF;
	public WebElement getVendorNameTF() {
		return vendorNameTF;
	}
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productInfoHedder;
	public WebElement getProductInfoHedder() {
		return productInfoHedder;
	}
	
	//add vendor child window elements
	
	
	
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement searchVendorTF;
	public WebElement getSearchVendorTF() {
		return searchVendorTF;
	}
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchVendorBTN;
	public WebElement getSearchVendorBTN() {
		return searchVendorBTN;
	}
	
	
	
	
}
