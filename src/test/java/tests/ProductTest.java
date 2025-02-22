package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends Preconditions{

    @Test
    public void isAddToCartButtonDisplayedTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userSuccess);
        Assert.assertTrue(productPage.isAddToCartButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }

    @Test
    public void isRemoveButtonDisplayedTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userSuccess)
                 .addProductToCart(SAUCE_LABS_BOLT_T_SHIRT);
        Assert.assertTrue(productPage.isRemoveToCartButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }
}
