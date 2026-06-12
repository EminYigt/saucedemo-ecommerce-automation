package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class CheckoutOverviewPage {

    private final WebDriver driver;

    public CheckoutOverviewPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    private WebElement finish_button;

    public CheckoutCompletePage click_finish(){
        finish_button.click();
        return new CheckoutCompletePage();
    }

}
