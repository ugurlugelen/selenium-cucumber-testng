package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import utils.TestContextSetUp;

public class CheckOutPageStepDefinitions {

    TestContextSetUp testContextSetUp;

    public CheckOutPageStepDefinitions(TestContextSetUp testContextSetUp){
        this.testContextSetUp = testContextSetUp;
    }

    @When("Added {string} items of the selected product to cart")
    public void added_items_of_the_selected_product_to_cart(String string) {
        testContextSetUp.pageObjectManager.getLandingPage().selectQuantity(string);
        testContextSetUp.pageObjectManager.getLandingPage().clickAddToCartButton();
    }
    @Then("User proceeds to checkout and validate the {string} items in checkout page")
    public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String string) {
        testContextSetUp.pageObjectManager.getCheckOutPage().navigateToCheckOut();
        Assert.assertTrue(testContextSetUp.pageObjectManager.getCheckOutPage().getProductName().contains(string));
    }
    @Then("verify user has ability to enter promo code and place the order")
    public void verfiy_user_has_ability_to_enter_promo_code_and_place_the_order() {
        Assert.assertTrue(testContextSetUp.pageObjectManager.getCheckOutPage().verfiyPromoButton());
        testContextSetUp.pageObjectManager.getCheckOutPage().clickPlaceOrderButton();
    }



}
