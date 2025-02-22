package pages;

import entity.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import waiters.WaiterLoaderPage;

public class LoginPage extends BasePage{
    WaiterLoaderPage waiterLoaderPage;
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage login (User user){
        driver.findElement(USERNAME_INPUT).sendKeys(user.getUsername());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductPage(driver);
    }

    public ProductPage login (String username, String password){
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductPage(driver);
    }

    public String getErrorMassegeTest(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public LoginPage waitForPageOpened() {
        waiterLoaderPage.waitForElementToBeVisible(LOGIN_BUTTON, 15);
        return this;
    }
}