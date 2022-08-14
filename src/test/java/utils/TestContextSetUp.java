package utils;

import org.openqa.selenium.WebDriver;
import pages.PageObjectManager;

public class TestContextSetUp {

    public String productNameAtMainPage;
    public WebDriver driver;
    public String searchKey;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils utils;

    public TestContextSetUp(){
        testBase = new TestBase();
        this.driver = testBase.getDriver();
        pageObjectManager = new PageObjectManager(testBase.getDriver());
        utils = new GenericUtils(testBase.getDriver());
    }
}
