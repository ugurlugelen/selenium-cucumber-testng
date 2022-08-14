package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = "https://rahulshettyacademy.com/seleniumPractise/#/"
public class BaseClass {
    @FindBy(css = ".search-keyword")
    public WebElement searchKeywordInput;

    @FindBy(xpath = "//a[text()='Top Deals']")
    public WebElement cartHeaderNavlinkLink;

    @FindBy(id = "search-field")
    public WebElement searchFieldInput;

    @FindBy(css = ".quantity")
    public WebElement quantityInput;

    @FindBy(xpath = "//button[text()='ADD TO CART']")
    public WebElement button;

    public BaseClass(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
}