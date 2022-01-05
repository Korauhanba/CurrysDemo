package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public static WebDriver driver;
	public static CurrysBase currysBase;
	
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		currysBase = new CurrysBase(driver);
		PageFactory.initElements(driver, this);
		
	}

}
