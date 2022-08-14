package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

    WebDriver driver;

    public OffersPage(WebDriver driver){
        this.driver = driver;
    }

    private By searchBox = By.cssSelector("input#search-field");
    private By offerPageProductName = By.cssSelector("tr td:nth-child(1)");

    public void searchItem(String item){
        driver.findElement(searchBox).sendKeys(item);
    }

    public String getProductName(){
        return driver.findElement(offerPageProductName).getText();
    }


}
