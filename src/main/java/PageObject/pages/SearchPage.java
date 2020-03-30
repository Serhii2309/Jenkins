package PageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    private By firstIphoneProduct = By.cssSelector("a[data-id='975']");
    private By secondIphoneProduct = By.cssSelector("a[data-id='976']");
    private By firstPhoneAddToComparePageButton = By.cssSelector("//a[@onclick=\"compare.add('975');\"]");
    private By secondPhoneAddToComparePageButton = By.cssSelector("//a[@onclick=\"compare.add('976');\"]");
    private By showProductsToBeComparedButton = By.xpath("//a[@class='js-popup-call']");
    private By moveToCompareProductsPageButton = By.xpath("//a[@href='https://eplio.com.ua/compare-products/']");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage chooseElement() {
        wait.until(ExpectedConditions.elementToBeClickable(firstIphoneProduct));
        driver.findElement(firstIphoneProduct).click();
        return new ProductPage(driver);
    }

    public CompareProductsPage addProductsToComparePage() {
        wait.until(ExpectedConditions.elementToBeClickable(firstPhoneAddToComparePageButton));
        wait.until(ExpectedConditions.elementToBeClickable(secondPhoneAddToComparePageButton));
        driver.findElement(firstPhoneAddToComparePageButton).click();
        driver.findElement(secondPhoneAddToComparePageButton).click();
        driver.findElement(showProductsToBeComparedButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(moveToCompareProductsPageButton));
        driver.findElement(moveToCompareProductsPageButton).click();
        return new CompareProductsPage(driver);
    }

    public WebElement getFirstIphoneProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstIphoneProduct));
        return driver.findElement(firstIphoneProduct);
    }

    public WebElement getSecondIphoneProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondIphoneProduct));
        return driver.findElement(secondIphoneProduct);
    }
}
