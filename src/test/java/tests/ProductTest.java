package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends Preconditions{

    @Test(description = "sc-6 Checking if the 'Add to Cart' button is displayed for the specified product")
    public void isAddToCartButtonDisplayedTest() {
        loginSteps.loginAndWaitForPageOpened(userSuccess);
        Assert.assertTrue(productPage.isAddToCartButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }

    @Test(description = "sc-7 Removing an item from the shopping cart and checking that it is missing")
    public void isRemoveButtonDisplayedTest() {
        loginSteps.loginAndWaitForPageOpened(userSuccess);
        productSteps.addProductToCart(SAUCE_LABS_BOLT_T_SHIRT);
        Assert.assertTrue(productPage.isRemoveToCartButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }
}