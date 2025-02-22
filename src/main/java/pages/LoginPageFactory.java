package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiters.WaiterLoaderPage;

public class LoginPageFactory extends BasePage{
    WaiterLoaderPage waiterLoaderPage;

    @FindBy(id = "user-name" )
    WebElement userNameInput;

    @FindBy(id = "password" )
    WebElement passwordInput;

    @FindBy(id = "login-button" )
    WebElement loginButton;

    @FindBy(xpath = "//*[@data-test='error']" )
    WebElement errorMassage;

    @FindBy(xpath = "//button[contains(.,'Add')]")
    static WebElement addsButton;

    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement deletesButton;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMassegeTest(){
        return errorMassage.getText();
    }

    public static WebElement getAddButton() {
        return addsButton;
    }

    public WebElement getDeleteButton() {
        return deletesButton;
    }

    public LoginPageFactory waitForPageOpened() {
        waiterLoaderPage.waitForElementToBeVisible((By) loginButton, 15);
        return this;
    }
}