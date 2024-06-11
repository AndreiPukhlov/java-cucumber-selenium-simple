package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class googleSteps {
    @Given("user is on the google page")
    public void userIsOnTheSamplePage() throws InterruptedException {
        getDriver().get("https://www.google.com/");
        Thread.sleep(1000);
    }

    @When("they search for Cucumber Selenium")
    public void theySearchForCucumber() {
        getDriver().findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Cucumber Selenium");
        new Actions(getDriver()).sendKeys(Keys.ENTER).perform();

    }

    @And("they proceed with the result")
    public void theyProceedWithTheResult() {
        getDriver().findElement(By.xpath("(//*[text()='https://cucumber.io'])[1]")).click();
    }

    @Then("the right page is opened")
    public void theRightPageIsOpened() {
        boolean cucumberPageIsDisplayed = getDriver().findElement(By.xpath("//*[@id='selenium-webdriver']")).isDisplayed();
        assertThat(cucumberPageIsDisplayed).isTrue();

    }

    @And("they accepts cookies")
    public void theyAcceptedCookies() throws InterruptedException {
        WebElement element = getDriver().findElement(By.xpath("//*[contains(@class,'ch2-btn-primary')]"));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        element.click();
        Thread.sleep(3000); // Only to see the result
    }
}
