package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Preconditions {
    public static final String EMPTY_USERNAME_ERROR = "Epic sadface: Username is required";
    public static final String EMPTY_DATA_IN_FIELD_PASSWORD_ERROR = "Epic sadface: Password is required";
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";

    @Test(description = "sc-8 Checking login with an empty username")
    public void loginWithEmptyUsernameTest(){
        loginSteps.loginAndWaitForPageOpened(userWithEmptyUsername);
        Assert.assertEquals(loginPage.getErrorMassegeTest(), EMPTY_USERNAME_ERROR);
    }

    @Test(description = "sc-9 Checking successful login")
    public void loginSuccessTest() {
        loginSteps.loginAndWaitForPageOpened(userSuccess);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(description = "sc-10 Checking login with an empty password")
    public void loginWithEmptyPasswordTest() {
        loginSteps.loginAndWaitForPageOpened(userWithEmptyPassword);
        Assert.assertEquals(loginPage.getErrorMassegeTest(), EMPTY_DATA_IN_FIELD_PASSWORD_ERROR);
    }

    @Test(description = "sc-11 Checking login with both fields empty")
    public void loginWithEmptyFieldsTest() {
        loginSteps.loginAndWaitForPageOpened(userWithEmptyFields);
        Assert.assertEquals(loginPage.getErrorMassegeTest(), EMPTY_USERNAME_ERROR);
    }

    @Test(description = "sc-12 Checking login with incorrect username and password")
    public void loginWithIncorrectFieldsTest() {
        loginSteps.loginAndWaitForPageOpened(userWithEmptyIncorrect);
        Assert.assertEquals(loginPage.getErrorMassegeTest(), INCORRECT_DATA_IN_FIELDS);
    }
}