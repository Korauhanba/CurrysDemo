package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import base.BasePage;
import extentlisteners.ExtentListeners;

public class TrackTodayOrderDeliveryPage extends BasePage {

	public TrackTodayOrderDeliveryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@name='ref']")
	public WebElement jobRepairRefField;

	@FindBy(xpath = "//*[@value='postcode']")
	public WebElement postCodeBtn;

	@FindBy(xpath = "//*[@value='number']")
	public WebElement contactNumBtn;

	@FindBy(xpath = "//*[@name='searchBy']")
	public WebElement searchByField;

	@FindBy(xpath = "//*[@value='uk']")
	public WebElement ukRadioBtn;

	@FindBy(xpath = "//*[@value='roi']")
	public WebElement roiRadioBtn;

	@FindBy(xpath = "//*[@class='ant-btn ant-btn-primary']")
	public WebElement trackItBtn;

	public void trackTodayOrderDelivery(String jobRepairRef, String searchByType, String searchByData, String countryName) {

		try {
			jobRepairRefField.sendKeys(jobRepairRef);
			ExtentListeners.test.log(Status.INFO, "Value entered in Job Ref / Repair Ref field: " + jobRepairRef);
		}catch(Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}
		
		if (countryName.equals("United Kingdom")) {

			try {
				ukRadioBtn.click();
				if (searchByType.equals("Postcode")) {
					postCodeBtn.click();
				} else if (searchByType.equals("Contact Number")) {
					contactNumBtn.click();
				}
				searchByField.sendKeys(searchByData);
			}catch(Throwable t) {
				ExtentListeners.test.log(Status.FAIL, t.getMessage());
			}
			

		} else if (countryName.equals("Republic of Ireland")) {

			try {
				roiRadioBtn.click();
				if (searchByType.equals("Contact Number")) {
					contactNumBtn.click();
				}
				searchByField.sendKeys(searchByData);
			}catch(Throwable t) {
				ExtentListeners.test.log(Status.FAIL, t.getMessage());
			}
	
		}

		ExtentListeners.test.log(Status.INFO,
				"Search By selected: " + searchByType + " & search data entered: " + searchByData);
		ExtentListeners.test.log(Status.INFO, "Country selected: " + countryName);

		// As this code is written for learning purpose and we do not have live tracking ref, 
		// Track it button click has been commented intentionally
		// as it might not be a good practice to validate wrong info multiple times on any random real website
		
		// trackItBtn.click();
	}

}