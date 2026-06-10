package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    public void enterUsername(String username){
        usernameInput.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public ProductsPage loginAsValidUser(String username, String password) {
        login(username, password);
        return new ProductsPage();
    }

}
