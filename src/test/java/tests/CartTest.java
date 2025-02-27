package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.IntStream;

public class CartTest extends Preconditions {

    @Test(description = "SC-1 Adding an item to the shopping cart and checking for compliance with the name and price of the added item")
    public void addProductToCartTest() {
        loginSteps.loginAndPageOpened(userSuccess);
        productSteps.addProductToCart(2);
        cartSteps.navigateToCartPage();
        String[] expectedNames = {SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT};
        String[] expectedPrices = {SAUCE_LABS_BACKPACK_PRICE, SAUCE_LABS_BIKE_LIGHT_PRICE};
        IntStream.range(0, expectedNames.length).forEach(i -> {
            Assert.assertEquals(cartPage.getProductNames(i), expectedNames[i]);
            Assert.assertEquals(cartPage.getProductPrices(i), expectedPrices[i]);
        });
    }

    @Test(description = "sc-2 Removing an item from the shopping cart and checking that it is missing")
    public void removeProductToCartTest() {
        loginSteps.loginAndPageOpened(userSuccess);
        productSteps.addProductToCart(3);
        cartSteps.navigateToCartAndDeleteProduct(0);
        List<WebElement> productNames = cartPage.ProductNames();
        String[] remainingProductNames = {SAUCE_LABS_BIKE_LIGHT, SAUCE_LABS_BOLT_T_SHIRT};
        IntStream.range(0, remainingProductNames.length).forEach(i -> {
            Assert.assertEquals(productNames.get(i).getText(), remainingProductNames[i]);
            Assert.assertEquals(productNames.size(), 2);
        });
    }

    @Test(enabled = false, description = "sc-3 Updating the quantity of the purchased product in the basket")
    public void updateQuantityOfThePurchasedProduct() {
        loginSteps.loginAndPageOpened(userSuccess);
        productSteps.addProductToCart(3);
        cartSteps.updateQuantity(0,"2");
        String updatedQuantity = cartPage.retrieveProductQuantities(0);
        Assert.assertEquals(updatedQuantity, "2");
    }

    @Test(enabled = false, description = "sc-4 When you go to the product page with an ID that does not exist, there should be no 'Add to Cart' button.")
    public void addProductNonExistentToCart() {
        loginSteps.loginAndPageOpened(userSuccess);
        cartSteps.addProductNonExistent(PAGE_URL_NON_EXISTENT_PRODUCT);
        boolean isAddToCartButtonPresent = productPage.isAddToCartButtonPresent();
        if (isAddToCartButtonPresent) {
            Assert.fail("The 'Add to Cart' button should not be displayed for a non-existent product.");
        }
    }

    @Test(enabled = false, description = "sc-5 Place an order with an empty shopping cart")
    public void placeAnOrderWithAnEmptyShoppingCart() {
        loginSteps.loginAndPageOpened(userSuccess);
        cartSteps
                .navigateToCartPage()
                .placeAnOrderWithAnEmptyShoppingCart();
        Assert.assertEquals(cartPage.getErrorMessage(), "Your cart is empty. Please add items to your cart before checking out.");
    }
}