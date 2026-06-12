package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class CartPage {

    private final WebDriver driver;

    public CartPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(css = "[data-test='inventory-item-name']")
    private WebElement nameOfProduct;

    public String getCartProductName() {
        return nameOfProduct.getText();
    }

    public CheckoutPage goToCheckoutPage(){
        checkoutButton.click();
        return new CheckoutPage();
    }
}
