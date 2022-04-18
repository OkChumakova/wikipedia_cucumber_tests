package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.CreateAccountPage;
import pages.HomePage;
import utils.BaseClass;


public class CreateAccountStepDefinitions extends BaseClass {

    private BaseClass base;
    CreateAccountPage createAccountPage;

    public CreateAccountStepDefinitions(BaseClass base) {
        this.base = base;
        createAccountPage = new CreateAccountPage(this.base.driver);
    }

    @When("I enter {string} into username input field")
    public void i_enter_into_username_input_field(String keys) {
        createAccountPage.enterKeysIntoUserNameInputField(keys);
    }

    @When("I enter {string} into password input field")
    public void i_enter_into_password_input_field(String keys) {
        createAccountPage.enterKeysIntoPasswordInputField(keys);
    }

    @When("I enter {string} into confirm password input field")
    public void i_enter_into_confirm_password_input_field(String keys) {
        createAccountPage.enterKeysIntoConfirmPasswordInputField(keys);
    }

    @When("I enter {string} into email input field")
    public void i_enter_into_email_input_field(String keys) {
        createAccountPage.enterKeysIntoEmailInputField(keys);
    }

    @When("I submit the form")
    public void i_submit_the_form() {
        createAccountPage.clickSubmitAccountCreationButton();

    }

    @Then("I should be able to see {string}")
    public void i_should_be_able_to_see(String textValue) {
        createAccountPage.assertWarningToFillTheFieldIsDisplayed(textValue);
    }
}
