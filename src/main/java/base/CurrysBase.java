package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import extentlisteners.ExtentListeners;

public class CurrysBase {
	
	WebDriver driver;
	
	public CurrysBase(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//*[@class='Image__Link-edvTxk iOuFMd HeaderLogo__DesktopImage-ioUffV iLFFMe' or @aria-label='currys']")
	public WebElement currysLogo;
	
	@FindBy(xpath = "//*[@class='pageTitle']")
	public WebElement itemTitle;
	
	@FindBy(xpath = "//*[text()='Mobile Phones']")
	public WebElement mobileTitle;
	
	// Method to verify the display of the Currys logo
	public void verifyCurrysLogo() {
		
		if(currysLogo.isDisplayed()) {
			
			ExtentListeners.test.log(Status.INFO, "Currys Logo is displayed.");
			
			/*
			 * Thread.sleep(2000);
			 * 
			 * try { ExtentManager.captureScreenshot(); } catch (IOException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 * 
			 * ExtentListeners.test.pass("<b><font color=green>" + "Screenshot of Logo" +
			 * "</font></b><br>",MediaEntityBuilder.createScreenCaptureFromPath(
			 * ExtentManager.fileName) .build());
			 */
			
		}else{
			
			ExtentListeners.test.log(Status.INFO, "Currys logo is missing.");
			
		}
		
		//Boolean imageExist = (Boolean) ((JavascriptExecutor) driver).executeScript("return (arguments[0].complete || typeof arguments[0].naturalWidth!=\"undefined\" && arguments[0].naturalWidth>0)",currysLogo);
		//System.out.println(imageExist);
		/*
		 * if(imageExist) {
		 * 
		 * System.out.println("Currys Logo exist on the page.");
		 * 
		 * }else {
		 * 
		 * System.out.println("Currys Logo is missing on the page.");
		 * 
		 * }
		 */
	}
	
	// Method to navigate back to home page by clicking on the Currys logo
	public void navigateBackToHomePage() {
		
		currysLogo.click();
		
	}
	
	
	// Method to retrieve the page title
	public String getPageTitle() {
		
		return driver.getTitle();
		
	}
	
	// Method to retrieve the item title on the page
	public String getItemTitle() {
		
		return itemTitle.getText();
		
	}
	
	// Method to retrieve the Mobile item title on the page
	public String getMobileTitle() {
		
		return mobileTitle.getText();
		
	}

}
