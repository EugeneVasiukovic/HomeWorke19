package pages;

import constans.IConstans;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * This abstract class represents the base page and provides common methods for all pages.
 */
public abstract class BasePage implements IConstans {
    WebDriver driver;

    /**
     * Constructor for BasePage.
     *
     * @param driver the WebDriver instance
     */
    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the specified URL in the browser.
     *
     * @param url the URL to open
     */
    public void openPage(String url) {
        driver.get(url);
    }
}