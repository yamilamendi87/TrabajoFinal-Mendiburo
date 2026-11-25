package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private final By headerTitle = By.cssSelector(".oxd-topbar-header-breadcrumb-module");
    private final By pimMenuLink = By.xpath("//span[text()='PIM']/ancestor::a");
    private final By userDropdown = By.cssSelector(".oxd-userdropdown-tab");
    private final By logoutLink = By.xpath("//a[text()='Logout']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnDashboard() {
        return waitForUrlContains("/dashboard") && isElementVisible(headerTitle);
    }

    public String getHeaderText() {
        return getText(headerTitle);
    }

    public void goToPIM() {
        click(pimMenuLink);
    }

    public void logout() {
        click(userDropdown);
        click(logoutLink);
    }
}

