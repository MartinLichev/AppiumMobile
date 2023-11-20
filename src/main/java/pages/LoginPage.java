package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Web element locators - Replace these with actual locators from the website
    By usernameLocator = By.id("form_username"); // Replace with actual locator
    By passwordLocator = By.id("form_password"); // Replace with actual locator
    By loginButtonLocator = By.id("submit_button"); // Replace with actual locator

    // Page actions
    public void setUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButtonLocator).click();
    }

    // Login method for convenience
    public void loginAs(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLogin();
    }
}
