package steps;

import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductPage;

import static constans.IConstans.LOGIN_PAGE_URL;

public class ProductSteps {
    private LoginPage loginPage;
    private ProductPage productPage;

    public ProductSteps(WebDriver driver){
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @Step("Login and add product to cart")
    public ProductSteps LoginAndAddProductToCart(String username, String password, String productName){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(username, password)
                .addProductToCart(productName);
        return this;
    }

    @Step("Login and add product to cart")
    public ProductSteps LoginAndAddProductToCart(User user, String productName){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(user)
                .addProductToCart(productName);
        return this;
    }
    @Step("Login and add product to cart")
    public ProductSteps LoginAndAddProductToCart(User user){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(user);
        return this;
    }
}
