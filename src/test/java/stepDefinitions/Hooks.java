package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BaseClass;
import utils.DriverFactory;
import utils.FrameworkPropertyReader;

import java.io.File;
import java.io.IOException;

public class Hooks extends BaseClass {

    private BaseClass base;

    public Hooks(BaseClass base) {
        this.base = base;
    }

    @After
    public void teardown() {
        base.driver.quit();
    }

    @Before
    public void initialize() {
        base.driver = DriverFactory.createDriver(FrameworkPropertyReader.getBrowser());
    }

    @AfterStep
    public void makeScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) this.base.driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", "screenshot");
        }
    }

}
