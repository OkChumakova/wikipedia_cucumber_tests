package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateAccountPage {
    WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "wpName2")
    private WebElement userNameInputField;

    @FindBy(id = "wpPassword2")
    private WebElement passwordInputField;

    @FindBy(id = "wpRetype")
    private WebElement confirmPasswordInputField;

    @FindBy(id = "wpEmail")
    private WebElement emailInputField;

    @FindBy(id = "wpCreateaccount")
    private WebElement submitAccountCreationButton;


    public void enterKeysIntoUserNameInputField(String keys) {
        userNameInputField.sendKeys(keys);
    }

    public void enterKeysIntoPasswordInputField(String keys) {
        passwordInputField.sendKeys(keys);
    }

    public void enterKeysIntoConfirmPasswordInputField(String keys) {
        confirmPasswordInputField.sendKeys(keys);
    }

    public void enterKeysIntoEmailInputField(String keys) {
        emailInputField.sendKeys(keys);
    }

    public void clickSubmitAccountCreationButton() {
        submitAccountCreationButton.click();
    }

    public void assertWarningToFillTheFieldIsDisplayed(String textValue) {
        String message = userNameInputField.getAttribute("validationMessage");
        Assert.assertEquals(message, textValue);
    }

}
