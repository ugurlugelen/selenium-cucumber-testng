package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    private By searchEditBox = By.cssSelector(".search-keyword");
    private By productName = By.cssSelector("h4.product-name");

    private By topDealsLink = By.linkText("Top Deals");

    private By quantityInput = By.cssSelector("input.quantity");

    private By addToCartButton = By.xpath("//button[text()='ADD TO CART']");


    public void searchItem(String name){
        driver.findElement(searchEditBox).sendKeys(name);
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public void clickTopDealsButton(){
        driver.findElement(topDealsLink).click();
    }

    public void selectQuantity(String quantity){
        driver.findElement(quantityInput).clear();
        driver.findElement(quantityInput).sendKeys(quantity);
    }

    public void clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }

}
