package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the header page and provides methods to interact with it.
 */
public class HeaderPage extends BasePage {
    public static final By CART_PAGE = By.id("shopping_cart_container");

    /**
     * Constructor for HeaderPage.
     *
     * @param driver the WebDriver instance
     */
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigates to the cart page by clicking the cart icon.
     *
     * @return a new instance of CartPage
     */
    public CartPage navigateToCartPage() {
        driver.findElement(CART_PAGE).click();
        return new CartPage(driver);
    }
}