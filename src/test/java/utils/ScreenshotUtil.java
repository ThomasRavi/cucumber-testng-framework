package utils;

import org.openqa.selenium.*;
import driver.DriverFactory;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static void capture(String name) {
        try {
            File src = ((TakesScreenshot)DriverFactory.getDriver())
                        .getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(src,
              new File("target/screenshots/"+name+".png"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}