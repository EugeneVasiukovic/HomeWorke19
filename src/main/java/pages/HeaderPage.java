package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage{
    public static final By  CART_PAGE = By.id("shopping_cart_container");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }
    public void navigateToCartPage(){
        driver.findElement(CART_PAGE).click();
    }
}