package PageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompareProductsPage extends BasePage {

    private By firstIphoneProductOnComparePage = By.cssSelector("div.product__name a[href='https://eplio.com.ua/apple-iphone-11-64gb-black.html']");
    private By secondIphoneProductOnComparePage = By.cssSelector("div.product__name a[href='https://eplio.com.ua/apple-iphone-11-pro-64gb-space-gray.html'");

    public CompareProductsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstIphoneProductOnComparePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstIphoneProductOnComparePage));
        return driver.findElement(firstIphoneProductOnComparePage);
    }

    public WebElement getSecondIphoneProductOnComparePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondIphoneProductOnComparePage));
        return driver.findElement(secondIphoneProductOnComparePage);
    }
}
