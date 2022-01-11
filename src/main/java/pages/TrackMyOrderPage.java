package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class TrackMyOrderPage extends BasePage{

	public TrackMyOrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "(//*[@class='TextBlockSingleItem__Link-sc-1p6f7wj-7 eIrVFZ'])[1]")
	public WebElement goToTrackerVisitToday;
	
	public TrackTodayOrderDeliveryPage goToTrackerForTodayPage() {
		
		goToTrackerVisitToday.click();
		return new TrackTodayOrderDeliveryPage(driver);
		
	}

}
