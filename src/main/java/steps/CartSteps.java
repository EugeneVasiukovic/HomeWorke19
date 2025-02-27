package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HeaderPage;
import pages.LoginPage;

public class CartSteps {
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private CartPage cartPage;

    public CartSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        cartPage = new CartPage(driver);
    }

    @Step("Login, Add Product to Cart, and Remove Product")
    public CartSteps navigateToCartAndDeleteProduct(int deleteProduct) {
        headerPage
                .navigateToCartPage()
                .clickRemoveButton(deleteProduct);
        return this;
    }

    @Step("Login, Add Product to Cart, and Check Product")
    public CartSteps navigateToCartPage() {
        headerPage
                .navigateToCartPage();
        return this;
    }

    @Step("Login, Add Product to Cart, and update Quantity")
    public CartSteps updateQuantity(int product, String addQuantity) {
        headerPage
                .navigateToCartPage()
                .setProductQuantity(product, addQuantity);
        return this;
    }

    @Step("Login, Add Product to Cart, Product Non Existent")
    public CartSteps addProductNonExistent(String url) {
        loginPage
                .openPage(url);
        return this;
    }

    @Step("Place an order with an empty shopping cart")
    public CartSteps placeAnOrderWithAnEmptyShoppingCart() {
        cartPage
                .clickCheckoutButton();
        return this;
    }
}