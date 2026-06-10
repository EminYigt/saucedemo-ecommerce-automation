package tests;

import base.BaseTest;
import groovy.util.logging.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage();

        ProductsPage productsPage =
                loginPage.loginAsValidUser(
                        "standard_user",
                        "secret_sauce"
                );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html")
        );

        Assert.assertEquals(
                productsPage.getProductsTitle(),
                "Products"
        );
    }
    @Test
    public void invalidLoginTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.login(
                "standard_user",
                "wrong"
        );
        Assert.assertTrue(loginPage.getErrorMessage().contains(
                "Epic sadface: Username and password do not match any user in this service"));
    }
    @Test
    public void addProductToCartTest(){
        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage =
                loginPage.loginAsValidUser(
                        "standard_user",
                        "secret_sauce"
                );
        productsPage.clickAddButton();
        Assert.assertEquals(productsPage.getCartBadgeInfo(), "1");
        CartPage cartpage = productsPage.goToCartPage();
        productsPage.goToCartPage();
        Assert.assertEquals(productsPage.getCartProductName(), "Sauce Labs Backpack");
    }
}