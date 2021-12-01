package pages;

import org.openqa.selenium.WebDriver;

public class RestaurantPage extends BasePage{

    /**
     * Region Variables
     */
    String businessWebsite = "//p[contains (text(),'Business website')] //ancestor::div[1] //a";
    String businessPhone = "//p[contains (text(),'Phone number')] //ancestor::div[1] //p[2]";
    String businessAddress = "//a[contains (text(),'Get Directions')] //ancestor::div[1] //p[2]";

    /**
     * Region Constructor
     */
    public RestaurantPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Region Methods
     */
    public String getWebsite(){
        return Find(businessWebsite).getText();
    }

    public String getPhone(){
        return Find(businessPhone).getText();
    }

    public String getAddress(){
        return Find(businessAddress).getText();
    }

}
