package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.LandingPage;
import utils.TestContextSetUp;

import java.time.Duration;

public class LandingPageStepDefinitions {
    TestContextSetUp testContextSetUp;

    public LandingPageStepDefinitions(TestContextSetUp testContextSetUp ){
        this.testContextSetUp = testContextSetUp;
    }
    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() {
        testContextSetUp.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }
    @When("User searched with shortname {string} and extracted actual name of the product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String string) throws InterruptedException {
        LandingPage landingPage  = testContextSetUp.pageObjectManager.getLandingPage();
        testContextSetUp.searchKey = string;
        landingPage.searchItem(string);
        Thread.sleep(1000);
        testContextSetUp.productNameAtMainPage = landingPage.getProductName().split("-")[0].trim();
        //System.out.println("Denemelerceeeee" + testContextSetUp.productNameAtMainPage);
    }
}
