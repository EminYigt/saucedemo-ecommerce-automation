package pages;

import utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    private final WebDriver driver;

    @FindBy(css = "[data-test='title']")
    private WebElement productsTitle;

    public ProductsPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getProductsTitle(){
        return productsTitle.getText();
    }

    @FindBy(css = "[data-test='inventory-item-name']")
    private WebElement backpackName;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCartButton;
    @FindBy(css = "[data-test='shopping-cart-badge']")
    private WebElement cartBadge;
    @FindBy(css = "[data-test='shopping-cart-link']")
    private WebElement shoppingCartLink;
    @FindBy(css = "[data-test='inventory-item-name']")
    private WebElement nameOfProduct;

    public String getbackpackName(){
        return backpackName.getText();
    }
    public void clickAddButton(){
        addBackpackToCartButton.click();
    }
    public String getCartBadgeInfo(){
        return cartBadge.getText();
    }
    public CartPage goToCartPage(){
        shoppingCartLink.click();
        return new CartPage();
    }
    public String getCartProductName(){
        return nameOfProduct.getText();
    }
}