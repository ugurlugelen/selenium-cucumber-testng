package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {

    WebDriver driver;

    public CheckOutPage(WebDriver driver){
        this.driver = driver;
    }

    private By cartButton = By.cssSelector(".cart-icon");
    private By proceeddToCheckOutButton = By.xpath("//*[text()='PROCEED TO CHECKOUT']");
    private By productName =By.cssSelector(".product-name");
    private By promoButton = By.cssSelector(".promoBtn");
    private By placeOrderButton = By.xpath("//button[text()='Place Order']");



    public void navigateToCheckOut(){
        driver.findElement(cartButton).click();
        driver.findElement(proceeddToCheckOutButton).click();
    }

    public Boolean verfiyPromoButton(){
        return driver.findElement(promoButton).isDisplayed();
    }
    public String getProductName(){
        return driver.findElement(productName).getText();
    }
    public void clickPlaceOrderButton(){
        driver.findElement(placeOrderButton).click();
    }

}
