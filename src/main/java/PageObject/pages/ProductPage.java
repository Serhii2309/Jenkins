package PageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Pattern;

public class ProductPage extends BasePage {

    private By addToCartButton = By.id("button-cart");
    private By removeFromCartButton = By.xpath("//a[@title='Удалить']");
    private By productName = By.tagName("h1");
    private By addedToCartProduct = By.className("cart__model");
    private By emptyCartText = By.className("js-cart-items");
    private By productPrice = By.className("products-full-list__price");


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();
        return new ProductPage(driver);
    }

    public void removeFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(removeFromCartButton));
        driver.findElement(removeFromCartButton).click();
    }

    public WebElement getProductName() {
        return driver.findElement(productName);
    }

    public WebElement getAddedToCartProductName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addedToCartProduct));
        return driver.findElement(addedToCartProduct);
    }

    public WebElement getEmptyCartText() {
        wait.until(ExpectedConditions.textMatches(emptyCartText, Pattern.compile("Корзина \\(0\\)")));
        return driver.findElement(emptyCartText);
    }

    public WebElement getProductPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        return driver.findElement(productPrice);
    }
}
