package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.TestContextSetUp;

import java.io.File;
import java.io.IOException;

public class Hooks {

    TestContextSetUp testContextSetUp;

    public Hooks(TestContextSetUp testContextSetUp){
        this.testContextSetUp = testContextSetUp;
    }

    @After
    public void tearDown(){
        testContextSetUp.testBase.getDriver().quit();
    }

    @AfterStep
    public void addScreenShot(Scenario scenario) throws IOException {

        if (scenario.isFailed()){
            byte[] screenShot = ((TakesScreenshot) testContextSetUp.testBase.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot,"image/png",scenario.getName());
        }
    }
}
