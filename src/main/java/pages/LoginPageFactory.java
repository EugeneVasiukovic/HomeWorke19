package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiters.WaiterLoaderPage;

/**
 * This class represents the login page using the Page Factory pattern and provides methods to interact with it.
 */
public class LoginPageFactory extends BasePage {
    WaiterLoaderPage waiterLoaderPage;

    @FindBy(id = "user-name")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//*[@data-test='error']")
    WebElement errorMassage;

    @FindBy(xpath = "//button[contains(.,'Add')]")
    static WebElement addsButton;

    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement deletesButton;

    /**
     * Constructor for LoginPageFactory.
     *
     * @param driver the WebDriver instance
     */
    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    /**
     * Logs in using the provided username and password.
     *
     * @param username the username as a String
     * @param password the password as a String
     */
    public void login(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    /**
     * Gets the error message displayed on the login page.
     *
     * @return the error message as a String
     */
    public String getErrorMessageTest() {
        return errorMassage.getText();
    }

    /**
     * Gets the add button element.
     *
     * @return the add button WebElement
     */
    public static WebElement getAddButton() {
        return addsButton;
    }

    /**
     * Gets the delete button element.
     *
     * @return the delete button WebElement
     */
    public WebElement getDeleteButton() {
        return deletesButton;
    }

    /**
     * Waits for the login page to be fully loaded.
     *
     * @return the current instance of LoginPageFactory
     */
    public LoginPageFactory waitForPageOpened() {
        waiterLoaderPage.waitForElementToBeVisible((By) loginButton, 15);
        return this;
    }
}