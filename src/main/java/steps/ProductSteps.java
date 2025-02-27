package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;

public class ProductSteps {

    private ProductPage productPage;

    public ProductSteps(WebDriver driver){
        productPage = new ProductPage(driver);
    }

    @Step("Login and add product to cart")
    public ProductSteps addProductToCart(int addProduct){
        productPage
                .addProductsToCartPage(addProduct);
        return this;
    }

    @Step("Login and add product to cart")
    public ProductSteps addProductToCart(String productName){
        productPage
                .addProductToCart(productName);
        return this;
    }
}