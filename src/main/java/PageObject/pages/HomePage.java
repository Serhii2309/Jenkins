package PageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private By searchButton = By.className("js-search-btn");
    private By searchField = By.id("search_text");
    private By confirmSearchButton = By.id("search_btn");
    private By iphoneCategory = By.xpath("//a[@href='https://eplio.com.ua/iphone/']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage searchForItem(String searchText) {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        driver.findElement(searchField).sendKeys(searchText);
        driver.findElement(confirmSearchButton).click();
        return new SearchResultPage(driver);
    }

    public SearchPage chooseCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(iphoneCategory));
        driver.findElement(iphoneCategory).click();
        return new SearchPage(driver);

    }
}
