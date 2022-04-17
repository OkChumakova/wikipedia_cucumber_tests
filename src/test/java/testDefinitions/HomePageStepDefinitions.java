package testDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import utils.DriverFactory;
import utils.FrameworkPropertyReader;

import java.io.File;
import java.io.IOException;

public class HomePageStepDefinitions {
    WebDriver driver;
    WebElement webElement;

    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
    }

    @When("I search element by {string}")
    public void i_search_element_by(String xPath) {
        webElement = driver.findElement(By.xpath(xPath));
    }

    @Then("It should be present on the page containing following {string}")
    public void it_should_be_present_on_the_page_containing_following(String textValue) {
        Assert.assertEquals(webElement.getText(), textValue);
    }

    @When("I switch language to {string}")
    public void iSwitchLanguageTo(String language) {
        driver.findElement(By.linkText(language)).click();
    }

    @Then("I observe that static text denoting block with languages is displayed as {string}")
    public void iObserveThatStaticTextDenotingBlockWithLanguagesIsDisplayedAs(String textValue) {
        String textExtracted  = driver.findElement(By.cssSelector("#p-lang span.vector-menu-heading-label")).getText();
       Assert.assertEquals(textExtracted, textValue);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Before
    public void getDriver(){
        driver = DriverFactory.createDriver(FrameworkPropertyReader.getBrowser());
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", "screenshot");
        }
    }

}
