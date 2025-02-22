package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductPage extends HeaderPage{
    private static final By PRODUCT_LIST = By.className("inventory_item");
    private static final By ADD_TO_CART_BUTTON = By.className("btn_primary");
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class=\"inventory_item\"]";
    private static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Add')]";
    private static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Remove')]";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addProductToCart(String... productNames) {
        for (String productName : productNames) {
            driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        }
        return this;
    }

    public boolean isAddToCartButtonDisplayed(String productName){
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).isDisplayed();
    }

    public boolean isRemoveToCartButtonDisplayed(String productName){
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).isDisplayed();
    }

    public String getProductPrice(String productName){
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public void clickButtonAddToCartByIndex(int number){
        List<WebElement> products = driver.findElements(PRODUCT_LIST);
        WebElement product = products.get(number);
        product.findElement(ADD_TO_CART_BUTTON).click();
    }

    public void addProductsToCartPage(int addProductsToCartPage) {
        for (int i = 0; i < addProductsToCartPage; i++) {
            clickButtonAddToCartByIndex(i);
        }
    }

    public boolean isAddToCartButtonPresent() {
        try {
            driver.findElement(ADD_TO_CART_BUTTON);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
