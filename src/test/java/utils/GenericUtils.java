package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class GenericUtils {

    WebDriver driver;

    WebDriverWait wait;
    public GenericUtils(WebDriver driver){
        this.driver = driver;
    }

    public void switchWindowToChild(){
        String mainPage = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainPage)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void waitUntilNewWindows(int windowNumber){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(numberOfWindowsToBe(windowNumber));
    }

}
