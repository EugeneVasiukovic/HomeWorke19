package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class represents the product page and provides methods to interact with it.
 */
public class ProductPage extends HeaderPage {
    private static final By PRODUCT_LIST = By.className("inventory_item");
    private static final By ADD_TO_CART_BUTTON = By.className("btn_primary");
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class=\"inventory_item\"]";
    private static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Add')]";
    private static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Remove')]";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";

    /**
     * Constructor for ProductPage.
     *
     * @param driver the WebDriver instance
     */
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Adds the specified products to the cart.
     *
     * @param productNames the names of the products to add
     * @return the current instance of ProductPage
     */
    public ProductPage addProductToCart(String... productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        }
        return this;
    }

    /**
     * Checks if the "Add to Cart" button is displayed for the specified product.
     *
     * @param productName the name of the product
     * @return true if the button is displayed, false otherwise
     */
    public boolean isAddToCartButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).isDisplayed();
    }

    /**
     * Checks if the "Remove from Cart" button is displayed for the specified product.
     *
     * @param productName the name of the product
     * @return true if the button is displayed, false otherwise
     */
    public boolean isRemoveToCartButtonDisplayed(String productName) {
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).isDisplayed();
    }

    /**
     * Gets the price of the specified product.
     *
     * @param productName the name of the product
     * @return the price of the product as a String
     */
    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    /**
     * Clicks the "Add to Cart" button for the product at the specified index.
     *
     * @param number the index of the product
     */
    public void clickButtonAddToCartByIndex(int number) {
        List<WebElement> products = driver.findElements(PRODUCT_LIST);
        WebElement product = products.get(number);
        product.findElement(ADD_TO_CART_BUTTON).click();
    }

    /**
     * Adds a specified number of products to the cart.
     *
     * @param addProductsToCartPage the number of products to add
     */
    public void addProductsToCartPage(int addProductsToCartPage) {
        for (int i = 0; i < addProductsToCartPage; i++) {
            clickButtonAddToCartByIndex(i);
        }
    }

    /**
     * Checks if the "Add to Cart" button is present on the page.
     *
     * @return true if the button is present, false otherwise
     */
    public boolean isAddToCartButtonPresent() {
        try {
            driver.findElement(ADD_TO_CART_BUTTON);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}