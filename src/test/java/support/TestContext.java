package support;

import org.openqa.selenium.*;

public class TestContext {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    protected static void setDriver(WebDriver newChromeDriver) {
        driver = newChromeDriver;
    }

    public static void teardown() {
        driver.quit();
    }
}
