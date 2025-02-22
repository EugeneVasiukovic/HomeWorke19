package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageFactory extends BasePage{

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

    public void waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }
}
