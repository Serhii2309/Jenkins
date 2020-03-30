package PageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BasePage {

    private By airpodsProduct = By.xpath("//a[@href='https://eplio.com.ua/naushniki-apple-airpods-pro.html']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public ProductPage moveToProductPage() {
        wait.until(ExpectedConditions.elementToBeClickable(airpodsProduct));
        driver.findElement(airpodsProduct).click();
        return new ProductPage(driver);
    }

}
