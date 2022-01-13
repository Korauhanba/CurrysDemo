package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import base.BasePage;
import extentlisteners.ExtentListeners;

public class TrackMyOrderPage extends BasePage{

	public TrackMyOrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "(//*[@class='TextBlockSingleItem__Link-sc-1p6f7wj-7 eIrVFZ'])[1]")
	public WebElement goToTrackerVisitToday;
	
	public TrackTodayOrderDeliveryPage goToTrackerForTodayPage() {
		
		try {
			goToTrackerVisitToday.click();
		}catch(Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		return new TrackTodayOrderDeliveryPage(driver);
		
	}

}
