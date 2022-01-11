package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class ItemDescriptionPage extends BasePage {

	public ItemDescriptionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@class='page-title nosp']")
	public WebElement itemTitleDescPage;

	@FindBy(xpath = "//div[@id='product-actions']//button[@class='Button__StyledButton-iESSlv eyLozJ Button-dtUzzq sc-jfJzZe kHUYTy gdsrAv'][normalize-space()='Add to basket']")
	public WebElement addToBasketBtn;

	@FindBy(xpath = "//*[@class='sc-XhUPp kiNLFp']")
	public WebElement itemAddedSuccessMsg;

	@FindBy(xpath = "//*[@class='sc-biBrSq fdmElq']")
	public WebElement itemNameOnSuccessMsg;

	public String getItemTitleItemDescPage() {

		return itemTitleDescPage.getText();

	}

	public void addItemToBasket() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		String winHandle = driver.getWindowHandle();
		driver.switchTo().window(winHandle);

		addToBasketBtn.click();

	}

	public String getItemAddedSuccessMsg() {

		return itemAddedSuccessMsg.getText();

	}

	public String getItemNameOnAddedSuccessMsg() {

		return itemNameOnSuccessMsg.getText();

	}

}
