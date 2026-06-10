package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtil {

    private ScreenshotUtil(){}

    public static String takeScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            throw new IllegalStateException("Driver is null in takeScreenshot()");
        }

        // Proje çalışma dizinine sabitle
        Path outDir = Paths.get(System.getProperty("user.dir"), "target", "screenshots");
        try {
            Files.createDirectories(outDir);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create screenshot directory: " + outDir, e);
        }

        String timestamp = String.valueOf(System.currentTimeMillis());
        String fileName = testName + "_" + timestamp + ".png";
        Path dest = outDir.resolve(fileName);

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(src.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot to: " + dest, e);
        }

        return dest.toAbsolutePath().toString();
    }
}
