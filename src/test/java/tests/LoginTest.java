package tests;



import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends Preconditions {
    public static final String EMPTY_USERNAME_ERROR = "Epic sadface: Username is required";
    public static final String EMPTY_DATA_IN_FIELD_PASSWORD_ERROR = "Epic sadface: Password is required";
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";


    @Test
    public void loginWithEmptyUsernameTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithEmptyUsername);
        Assert.assertEquals(loginPage.getErrorMassegeTest(), EMPTY_USERNAME_ERROR);
    }


    @Test
    public void loginSuccessTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userSuccess);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }


    @Test
    public void loginWithEmptyPasswordTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithEmptyPassword);
        Assert.assertEquals(loginPage.getErrorMassegeTest(), EMPTY_DATA_IN_FIELD_PASSWORD_ERROR);
    }

    @Test
    public void loginWithEmptyFieldsTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithEmptyFilds);
        Assert.assertEquals(loginPage.getErrorMassegeTest(), EMPTY_USERNAME_ERROR);
    }

    @Test
    public void loginWithIncorrectFieldsTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithEmptyIncorect);
        Assert.assertEquals(loginPage.getErrorMassegeTest(), INCORRECT_DATA_IN_FIELDS);
    }
}