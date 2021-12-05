package pages;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class RestaurantPage extends BasePage{

    /**
     * Region Variables
     */
    String businessWebsite = "//p[contains (text(),'Business website')] //ancestor::div[1] //a";
    String businessPhone = "//p[contains (text(),'Phone number')] //ancestor::div[1] //p[2]";
    String businessAddress = "//a[contains (text(),'Get Directions')] //ancestor::div[1] //p[2]";
    String reviewByIndex = "(//section[@aria-label='Recommended Reviews'] //ul) [2] //li [$Index] //p[contains (@class,'comment') ] //span";

    /**
     * Region Constructor
     */
    public RestaurantPage() {
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

    public List<String> getTopThreeRevs (){
        List<String> reviews = new ArrayList<String>();
        reviews.add(Find(reviewByIndex.replace("$Index",Integer.toString(1))).getText());
        reviews.add(Find(reviewByIndex.replace("$Index",Integer.toString(2))).getText());
        reviews.add(Find(reviewByIndex.replace("$Index",Integer.toString(3))).getText());

        return reviews;
    }

}
