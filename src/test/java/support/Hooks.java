package support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


import static support.TestContext.getDriver;

public class Hooks {

    @Before(order = 0)
    public void testStart() {
        TestContext.setDriver(new ChromeDriver());
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After(order = 0)
    public void testEnd() {
        TestContext.teardown();
    }
}
