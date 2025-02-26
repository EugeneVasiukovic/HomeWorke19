package steps;

import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.HeaderPage;
import pages.LoginPage;

import static constans.IConstans.LOGIN_PAGE_URL;


public class CartSteps {
    private LoginPage loginPage;
    private HeaderPage headerPage;

    public CartSteps(WebDriver driver) {
        loginPage =new LoginPage(driver);
        headerPage = new HeaderPage(driver);
    }

    @Step("Login, Add Product to Cart, and Remove Product")
    public CartSteps loginAndAddProductToCartAndDeleteProduct(User user, int addProduct, int deleteProduct) {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(user)
                .addProductsToCartPage(addProduct);
        headerPage
                .navigateToCartPage()
                .clickRemoveButton(deleteProduct);
        return this;
    }

    @Step("Login, Add Product to Cart, and Check Product")
    public CartSteps loginAndAddProductCheckToCart(User user, int addProduct) {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(user)
                .addProductsToCartPage(addProduct);
        headerPage
                .navigateToCartPage();
        return this;
    }

    @Step("Login, Add Product to Cart, and update Quantity")
    public CartSteps loginAndAddProductUpdateQuantity(User user, int addProduct) {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(user)
                .addProductsToCartPage(addProduct);
        headerPage
                .navigateToCartPage()
                .setProductQuantity(0, "2");
        return this;
    }

    @Step("Login, Add Product to Cart, Product Non Existent")
    public CartSteps loginAndAddProductNonExistent(User user, String url) {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(user)
                .openPage(url);
        return this;
    }

    @Step("Place an order with an empty shopping cart")
    public CartSteps placeAnOrderWithAnEmptyShoppingCart(User user) {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(user);
        headerPage
                .navigateToCartPage()
                .clickCheckoutButton();
        return this;
    }
}