package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#p-lang span.vector-menu-heading-label")
    private WebElement staticHeaderTextForLanguagesList;

    public WebElement getStaticHeaderTextForLanguagesList() {
        return staticHeaderTextForLanguagesList;
    }
}
