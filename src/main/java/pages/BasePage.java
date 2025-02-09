package pages;

import constans.IConstans;
import org.openqa.selenium.WebDriver;

public abstract class BasePage implements IConstans {
    WebDriver driver;

    BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void openPage(String url){
        driver.get(url);
    }
}