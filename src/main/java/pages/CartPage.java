package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * This class represents the cart page and provides methods to interact with it.
 */
@Log4j2
public class CartPage extends HeaderPage {
    public static final By NAME_PRODUCT = By.className("inventory_item_name");
    public static final By PRICE_PRODUCT = By.className("inventory_item_price");
    public static final By QUANTITY_PRODUCT = By.className("cart_quantity");
    public static final By REMOVE_BUTTON = By.className("btn_secondary");
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By ERROR_MESSAGE = By.className("title");

    /**
     * Constructor for CartPage.
     *
     * @param driver the WebDriver instance
     */
    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Gets the name of the product at the specified index.
     *
     * @param number the index of the product
     * @return the name of the product
     */
    public String getProductNames(int number) {
        List<WebElement> nameProducts = driver.findElements(NAME_PRODUCT);
        WebElement nameProduct = nameProducts.get(number);
        log.info("Get product index {}: {}", number, nameProduct.getText());
        return nameProduct.getText();
    }

    /**
     * Gets a list of all product name elements.
     *
     * @return a list of WebElement representing product names
     */
    public List<WebElement> ProductNames() {
        return driver.findElements(NAME_PRODUCT);
    }

    /**
     * Gets the price of the product at the specified index.
     *
     * @param number the index of the product
     * @return the price of the product as a String
     */
    public String getProductPrices(int number) {
        List<WebElement> priceProducts = driver.findElements(PRICE_PRODUCT);
        WebElement priceProduct = priceProducts.get(number);
        String priceText = priceProduct.getText().replace("$", "").trim();
        log.info("get price product {}: {}", number, priceText);
        return priceText;
    }

    /**
     * Retrieves the quantity of the product at the specified index.
     *
     * @param number the index of the product
     * @return the quantity of the product as a String
     */
    public String retrieveProductQuantities(int number) {
        List<WebElement> quantityProducts = driver.findElements(QUANTITY_PRODUCT);
        log.info("Get product quantity {}", quantityProducts);
        return quantityProducts.get(number).getText();
    }

    /**
     * Sets the quantity of the product at the specified index.
     *
     * @param number the index of the product
     * @param quantity the quantity to set
     */
    public void setProductQuantity(int number, String quantity) {
        List<WebElement> quantityProducts = driver.findElements(QUANTITY_PRODUCT);
        WebElement quantityProduct = quantityProducts.get(number);
        quantityProduct.sendKeys(quantity);
        log.info("Set product quantity {}", quantityProducts);
    }

    /**
     * Clicks the remove button for the product at the specified index.
     *
     * @param number the index of the product
     */
    public void clickRemoveButton(int number) {
        List<WebElement> removeButtons = driver.findElements(REMOVE_BUTTON);
        WebElement button = removeButtons.get(number);
        button.click();
        log.info("Clicked remove button at index {}", number);
    }

    /**
     * Clicks the checkout button.
     */
    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    /**
     * Gets the error message displayed on the cart page.
     *
     * @return the error message as a String
     */
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}