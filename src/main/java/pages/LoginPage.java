package pages;

import entity.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import waiters.WaiterLoaderPage;

/**
 * This class represents the login page and provides methods to interact with it.
 */
public class LoginPage extends BasePage{
    WaiterLoaderPage waiterLoaderPage;
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    /**
     * Constructor for LoginPage.
     *
     * @param driver the WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Logs in using the provided User object.
     *
     * @param user the User object containing username and password
     * @return a new instance of ProductPage
     */
    public ProductPage login(User user){
        driver.findElement(USERNAME_INPUT).sendKeys(user.getUsername());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductPage(driver);
    }

    /**
     * Logs in using the provided username and password.
     *
     * @param username the username as a String
     * @param password the password as a String
     * @return a new instance of ProductPage
     */
    public ProductPage login(String username, String password){
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductPage(driver);
    }

    /**
     * Gets the error message displayed on the login page.
     *
     * @return the error message as a String
     */
    public String getErrorMassegeTest(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    /**
     * Waits for the login page to be fully loaded.
     *
     * @return the current instance of LoginPage
     */
    public LoginPage waitForPageOpened() {
        waiterLoaderPage.waitForElementToBeVisible(LOGIN_BUTTON, 15);
        return this;
    }
}