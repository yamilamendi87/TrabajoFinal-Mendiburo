package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PIMPage extends BasePage {
    private final By pimHeader = By.cssSelector(".oxd-topbar-header-breadcrumb-module");
    private final By employeeNameInput = By.xpath("//label[text()='Employee Name']/parent::div/following-sibling::div//input");
    private final By searchButton = By.cssSelector("button[type='submit']");
    private final By tableRows = By.cssSelector(".oxd-table-body .oxd-table-card");
    private final By toastMessage = By.cssSelector(".oxd-toast");
    private final By noRecordsText = By.xpath("//*[contains(text(),'No Records Found')]");

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnPIMPage() {
        return waitForUrlContains("/pim") && isElementVisible(pimHeader);
    }

    public void searchEmployeeByName(String name) {
        type(employeeNameInput, name);
        click(searchButton);
    }

    public boolean hasResults() {
        try {
            waitForVisibility(tableRows);
            List<WebElement> rows = driver.findElements(tableRows);
            return !rows.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNoRecordsDisplayed() {
        return isElementVisible(noRecordsText) || isElementVisible(toastMessage);
    }
}