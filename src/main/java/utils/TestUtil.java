package utils;

import Base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class TestUtil extends BaseClass {
    public static void takeScreenshotAtEndOfTest() throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentPath = System.getProperty("user.dir");
        FileUtils.copyFile(file, new File(currentPath + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
    // please prepare click method resuable method
    public static void clickOnElement(WebElement element) {
        element.click();
    }
    // please prepare sendkeys method resuable method
    public static void sendKeysToElement(WebElement element, String value) {
        element.sendKeys(value);
    }
    // wait for element reusable method

}
