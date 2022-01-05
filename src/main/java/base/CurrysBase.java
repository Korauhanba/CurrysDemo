package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CurrysBase {
	
	WebDriver driver;
	
	public CurrysBase(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//*[@fill='#4C12A1']")
	public WebElement currysLogo;
	
	public void verifyCurrysLogo() {
		
		Boolean imageExist = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \\\"undefined\\\" && arguments[0].naturalWidth > 0",currysLogo);
		
		if(imageExist) {
			
			System.out.println("Currys Logo exist on the page.");
			
		}else {
			
			System.out.println("Currys Logo is missing on the page.");
			
		}
		
	}

}
