package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            String path = ScreenshotUtil.takeScreenshot(driver, result.getName());
            System.out.println("Screenshot saved: " + path);
        } else {
            System.out.println("Driver is null in Listener." +
                    " Screenshot skipped. ");
        }
    }

}
