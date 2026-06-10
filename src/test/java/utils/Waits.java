package utils;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    public static WebElement visible(WebDriver driver,
                                    By locator){

        int timeout = ConfigReader.getInt("timeoutSeconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement clickable(WebDriver driver,
                                       By locator){
        int timeout = ConfigReader.getInt("timeoutSeconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static boolean title_contains(WebDriver driver,
                                         String text){
        int timeout = ConfigReader.getInt("timeoutSeconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.titleContains(text));
    }
}
