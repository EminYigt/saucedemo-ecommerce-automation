package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class CheckoutPage {

    private final WebDriver driver;

    public CheckoutPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "first-name")
    private WebElement first_name;

    @FindBy(id = "last-name")
    private WebElement last_name;

    @FindBy(id = "postal-code")
    private WebElement postal_code;

    @FindBy(id = "continue")
    private WebElement continue_button;

    public void setInformation(
            String firstName,
            String lastName,
            String postalCode
    ) {
        first_name.sendKeys(firstName);
        last_name.sendKeys(lastName);
        postal_code.sendKeys(postalCode);
    }

    public CheckoutOverviewPage continueCheckout(){
        continue_button.click();
        return new CheckoutOverviewPage();
    }
}
