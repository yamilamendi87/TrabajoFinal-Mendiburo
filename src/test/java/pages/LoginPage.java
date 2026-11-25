package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final String LOGIN_URL = "https://opensource-demo.orangehrmlive.com/";

    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By errorAlert = By.cssSelector(".oxd-alert-content-text");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void gotoPage() {
        driver.get(LOGIN_URL);
        waitForVisibility(usernameInput);
    }

    // Alias por si lo necesitás con el nombre exacto del enunciado
    public void gotoUrl() {
        gotoPage();
    }

    public void enterUserName(String username) {
        type(usernameInput, username);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void loginAs(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isOnLoginPage() {
        return waitForUrlContains("/auth/login") && isElementVisible(usernameInput);
    }

    public boolean isErrorDisplayed() {
        return isElementVisible(errorAlert);
    }
}
