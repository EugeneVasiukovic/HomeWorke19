package steps;

import constans.IConstans;
import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver){
        loginPage = new LoginPage(driver);
    }

    @Step("Login and wait for page loaded")
    public LoginSteps loginAndWaitForPageOpened(String username, String password){
        loginPage.openPage(IConstans.LOGIN_PAGE_URL);
        loginPage
                .login(username,password);
        return this;
    }

    @Step("Login and wait for page loaded")
    public LoginSteps loginAndWaitForPageOpened(User user){
        loginPage.openPage(IConstans.LOGIN_PAGE_URL);
        loginPage
                .login(user);
        return this;
    }
}