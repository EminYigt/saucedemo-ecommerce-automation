package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;
import utils.Waits;

public class CheckoutCompletePage {

    private final WebDriver driver;

    private final By completeText =
            By.cssSelector("[data-test='complete-text']");

    public CheckoutCompletePage() {
        this.driver = DriverManager.getDriver();
    }

    public String getCompletePageText() {
        return Waits.visible(driver, completeText).getText();
    }
}
