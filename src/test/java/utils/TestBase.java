package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase {

    public WebDriver driver;

    public WebDriver getDriver(){

        String browserMaven = System.getProperty("browser");
        String browserProperties = PropReader.getProperty("browser");

        String browser = browserMaven!= null ? browserMaven : browserProperties;

        if (driver == null){
            switch (browser.toLowerCase()){

                case "chrome":
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--headless=new"));
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                case "remote-chrome":
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName(Browser.CHROME.browserName());
                    capabilities.setVersion("111");
                    try {
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                default:
                    driver = new ChromeDriver();
                    break;
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
