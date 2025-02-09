package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends HeaderPage{
    public static final By NAME_PRODUCT = By.className("inventory_item_name");
    public static final By PRICE_PRODUCT = By.className("inventory_item_price");
    public static final By QUANTITY_PRODUCT = By.className("cart_quantity");
    public static final By REMOVE_BUTTON = By.className("btn_secondary");
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By ERROR_MESSAGE = By.className("title");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductNames(int number) {
        List<WebElement> nameProducts = driver.findElements(NAME_PRODUCT);
        WebElement nameProduct = nameProducts.get(number);
        return nameProduct.getText();
    }

    public List<WebElement> ProductNames() {
        return driver.findElements(NAME_PRODUCT);
    }


    public String getProductPrices(int number) {
        List<WebElement> priceProducts = driver.findElements(PRICE_PRODUCT);
        WebElement priceProduct = priceProducts.get(number);
        return priceProduct.getText().replace("$", "").trim();
    }

    public String getProductQuantities(int number) {
        List<WebElement> quantityProducts = driver.findElements(QUANTITY_PRODUCT);
        return quantityProducts.get(number).getText();
    }
    public void  setProductQuantity(int number,String quantity){
        List<WebElement> quantityProducts = driver.findElements(QUANTITY_PRODUCT);
        WebElement quantityProduct = quantityProducts.get(number);
        quantityProduct.sendKeys(quantity);
    }
    public void clickRemoveButton(int number) {
        List<WebElement> removeButtons = driver.findElements(REMOVE_BUTTON);
        removeButtons.get(number).click();
    }
    public void clickCheckoutButton(){
        driver.findElement(CHECKOUT_BUTTON).click();
    }
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}





