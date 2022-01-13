package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import base.BasePage;
import extentlisteners.ExtentListeners;

public class ItemDescriptionPage extends BasePage {

	public ItemDescriptionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@class='page-title nosp']")
	public WebElement itemTitleDescPage;

	@FindBy(xpath = "//div[@id='product-actions']//button[@class='Button__StyledButton-iESSlv eyLozJ Button-dtUzzq sc-jfJzZe kHUYTy gdsrAv'][normalize-space()='Add to basket']")
	public WebElement addToBasketBtn;

	@FindBy(xpath = "//*[text()='This item has been added to your basket']")
	public WebElement itemAddedSuccessMsg;

	@FindBy(xpath = "//*[@class='sc-biBrSq fdmElq']")
	public WebElement itemNameOnSuccessMsg;

	@FindBy(xpath = "//div[@data-component='CSAPopin']")
	public WebElement careAndRepairPopUp;

	@FindBy(xpath = "//*[@data-component='CloseBtn']")
	public WebElement closeBtn;

	public String getItemTitleItemDescPage() {

		String itemTitleDesc = null;

		try {
			itemTitleDesc = itemTitleDescPage.getText();
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		return itemTitleDesc;

	}

	public void addItemToBasket() {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			String winHandle = driver.getWindowHandle();
			driver.switchTo().window(winHandle);
			addToBasketBtn.click();

		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		if (careAndRepairPopUp.isEnabled()) {
			closeBtn.click();
		}

	}

	public String getItemAddedSuccessMsg() {

		String itemAddedSuccessMsgValue = null;

		try {
			itemAddedSuccessMsgValue = itemAddedSuccessMsg.getText();
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		return itemAddedSuccessMsgValue;

	}

	public String getItemNameOnAddedSuccessMsg() {

		String itemNameOnSuccessMsgValue = null;

		try {
			itemNameOnSuccessMsgValue = itemNameOnSuccessMsg.getText();
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		return itemNameOnSuccessMsgValue;

	}

}
