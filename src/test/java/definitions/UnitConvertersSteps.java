package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UnitConvertersSteps {

    @Given("user is on the Unit converters page")
    public void userIsOnThePage() {
        String url = "https://www.unitconverters.net";
        getDriver().get(url);

    }

    @When("they select unit {string}")
    public void theySelectUnit(String arg0) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + arg0 + "')]")).click();
    }

    @And("they select from {string} to {string}")
    public void theySelectFromTo(String arg0, String arg1) {
        getDriver().findElement(By.xpath("//*[@id='calFrom']/option[text()='" + arg0 + "']")).click();
        getDriver().findElement(By.xpath("//*[@id='calTo']/option[text()='" + arg1 + "']")).click();
        String calFrom = getDriver().findElement(By.xpath("//*[@id='calFrom']/option[text()='" + arg0 + "']")).getText();
        assertThat(calFrom).containsIgnoringCase(arg0);
        String calTo = getDriver().findElement(By.xpath("//*[@id='calTo']/option[text()='" + arg1 + "']")).getText();
        assertThat(calTo).containsIgnoringCase(arg1);
    }

    @Then("they see the calculation result is {string}")
    public void theySeeTheCalculationResult(String calTo) {

        String actualCalTo = getDriver().findElement(By.xpath("//*[@id='toVal']")).getAttribute("value");
        assertThat(actualCalTo).isEqualTo(calTo);

        boolean element = getDriver().findElement(By.xpath("//*[@id='calResults']")).isDisplayed();
        String result = getDriver().findElement(By.xpath("//*[@id='calResults']")).getText();

        if (element) {
            System.out.println("Result is calculated. " + result);
        } else {
            System.out.println("Result is not calculated.");
        }
        assertThat(element).isTrue();
    }

    @And("set initial value to {string}")
    public void setInitialValueTo(String arg0) {
        getDriver().findElement(By.xpath("//*[@id='fromVal']")).sendKeys(arg0);
    }
}
