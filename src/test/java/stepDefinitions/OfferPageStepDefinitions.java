package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LandingPage;
import pages.OffersPage;
import utils.TestContextSetUp;


public class OfferPageStepDefinitions {
    String productNameAtOfferPage;
    TestContextSetUp testContextSetUp;
    public OfferPageStepDefinitions(TestContextSetUp testContextSetUp){
        this.testContextSetUp = testContextSetUp;
    }

    @Then("user searched for same shortname in offers page to check if product exist")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist() {
        /*driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/offers");*/
        switchToOffersPage();
        OffersPage offersPage = testContextSetUp.pageObjectManager.getOffersPage();
        offersPage.searchItem(testContextSetUp.searchKey);
        productNameAtOfferPage = offersPage.getProductName();
    }

    @Then("validates same results are displayed at search results")
    public void validates_same_results_are_displayed_at_search_results(){
        Assert.assertEquals(testContextSetUp.productNameAtMainPage,productNameAtOfferPage);
    }

    public void switchToOffersPage(){

        if (!testContextSetUp.driver.getCurrentUrl().equals("https://rahulshettyacademy.com/seleniumPractise/#/offers")){
            LandingPage landingPage = testContextSetUp.pageObjectManager.getLandingPage();
            landingPage.clickTopDealsButton();
            testContextSetUp.utils.switchWindowToChild();
            testContextSetUp.utils.waitUntilNewWindows(2);
        }else {
            System.out.println("Already switched");
        }

    }
}
