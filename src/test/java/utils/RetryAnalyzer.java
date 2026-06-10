package utils;

import config.ConfigReader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;
    @Override
    public boolean retry(ITestResult result) {
        int maxRetry = ConfigReader.getInt("retryCount");

        if (count < maxRetry){
            count++;
            System.out.println("Retrying test: " +
                    result.getName() + " attempt : " +
                    count);
            return true;
        }
        return false;
    }
}
