package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductPage extends HeaderPage{
    public static final By PRODUCT_LIST = By.className("inventory_item");
    public static final By ADD_TO_CART_BUTTON = By.id("add-to-cart");
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public void clickButtonAddToCartByIndex(int number){
        List<WebElement> products = driver.findElements(PRODUCT_LIST);
        WebElement product = products.get(number);
        product.findElement(By.tagName("button")).click();
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
