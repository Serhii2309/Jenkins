package tests;

import PageObject.pages.CompareProductsPage;
import PageObject.pages.HomePage;
import PageObject.pages.ProductPage;
import PageObject.pages.SearchPage;
import PageObject.pages.SearchResultPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EplioTests {
    WebDriver chromeDriver;
    private static final String EPLIO_URL = "https://eplio.com.ua/";
    private static final String SEARCH_TEXT = "Apple Airpods Pro";
    private static final String SEARCH_RESULT_PAGE_TITLE = "Поиск - " + SEARCH_TEXT;
    private static final String EMPTY_CART_TEXT = "Корзина (0)";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().version("80.0.3987.149").setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get(EPLIO_URL);
    }

    @Test
    public void searchTest() {
        HomePage homePage = new HomePage(chromeDriver);
        SearchResultPage searchResultPage = homePage.searchForItem(SEARCH_TEXT);
        Assert.assertEquals(searchResultPage.getPageTitle(chromeDriver), SEARCH_RESULT_PAGE_TITLE);
    }

    @Test
    public void addToCartTest() {
        HomePage homePage = new HomePage(chromeDriver);
        SearchPage searchPage = homePage.chooseCategory();
        ProductPage productPage = searchPage.chooseElement().addToCart();
        Assert.assertEquals(productPage.getAddedToCartProductName().getText().toLowerCase(), productPage.getProductName().getText().toLowerCase());
    }

    @Test
    public void removeFromCartTest() {
        HomePage homePage = new HomePage(chromeDriver);
        SearchPage searchPage = homePage.chooseCategory();
        ProductPage productPage = searchPage.chooseElement().addToCart();
        productPage.removeFromCart();
        Assert.assertEquals(productPage.getEmptyCartText().getText(), EMPTY_CART_TEXT);
    }

    @Test
    public void checkIfPriceIsPresent() {
        HomePage homePage = new HomePage(chromeDriver);
        SearchResultPage searchResultPage = homePage.searchForItem(SEARCH_TEXT);
        ProductPage productPage = searchResultPage.moveToProductPage();
        Assert.assertTrue(productPage.getProductPrice().isDisplayed());
    }

    @Test
    public void checkAbilityToCompareProducts() {
        HomePage homePage = new HomePage(chromeDriver);
        SearchPage searchPage = homePage.chooseCategory();
        String expectedResult = searchPage.getFirstIphoneProduct().getText().toLowerCase() + "," + searchPage.getSecondIphoneProduct().getText().toLowerCase();
        CompareProductsPage compareProductsPage = searchPage.addProductsToComparePage();
        String actualResult = compareProductsPage.getFirstIphoneProductOnComparePage().getText().toLowerCase() + "," + compareProductsPage.getSecondIphoneProductOnComparePage().getText().toLowerCase();
        Assert.assertEquals(actualResult, expectedResult);
    }


    @AfterMethod
    public void tearDown() {
        chromeDriver.quit();
    }
}
