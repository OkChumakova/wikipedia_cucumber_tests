package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.testng.Assert;
import pages.HomePage;
import utils.BaseClass;

public class HomePageStepDefinitions extends BaseClass {

    private BaseClass base;
    private HomePage homePage;
    private WebElement webElement;

    public HomePageStepDefinitions(BaseClass base) {
        this.base = base;
        homePage = new HomePage(base.driver);
    }

    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        this.base.driver.get(url);
    }

    @When("I search element by {string}")
    public void i_search_element_by(String xPath) {
        webElement = this.base.driver.findElement(By.xpath(xPath));
    }

    @Then("It should be present on the page containing following {string}")
    public void it_should_be_present_on_the_page_containing_following(String textValue) {
        Assert.assertEquals(webElement.getText(), textValue);
    }

    @When("I switch language to {string}")
    public void iSwitchLanguageTo(String language) {
        this.base.driver.findElement(By.linkText(language)).click();
    }

    @Then("I observe that static text denoting block with languages is displayed as {string}")
    public void iObserveThatStaticTextDenotingBlockWithLanguagesIsDisplayedAs(String textValue) {
        String textExtracted = homePage.getStaticHeaderTextForLanguagesList().getText();
        Assert.assertEquals(textExtracted, textValue);
    }
}
