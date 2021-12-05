package pages;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainPage extends BasePage{

    /**
     * Region Variables
     */
    private String searchBoxInput = "//input[@name='find_desc']";
    private String searchBoxButton = "//span[@class='pseudo-input_text business-search-form_input-text' and contains(text(),'Find')]";
    private String searchBoxDropByOption = "//ul[@class='suggestions-list'] //span[contains (text(),'$Option')]";
    private String buttonSearch = "//button[@id='header-search-submit' or @data-testid='suggest-submit']";
    private String radioDistBtnByInnerTxt = "//span [contains ( text (), '$InnerText' )] //ancestor::div[3] //input[@type='radio'] //parent::div";
    private String checkFeatBtnByInnerTxt = "//span [contains ( text (), '$InnerText' )] //ancestor::div[3] //input[@type='checkbox'] //parent::div";
    private String businessName = "//h4 //a";
    private String businessNameByIndex = "(//h4 //a) [$Index]";
    //private String businessNameByIndexClick = "(//h4 //a) [1] //parent::span";
    private String businessNameByIndexClick = "(//a[contains (text(),'more') ]) [1]";

    private String businessStarByIndex = "(//h4 //a /ancestor::div[4] //div[contains (@class,'i-stars')] ) [$Index]";

    private HashMap<String, String> restaurantsInfo = new HashMap<String, String>();

    /**
     * Region Constructor
     */
    public MainPage() {
        super(driver);
    }

    /**
     * Region Methods
     */

    public void clickSearchbox (){
        moveNClick(searchBoxButton);
    }

    public void writeInSearchBox(String argText){
        write(searchBoxInput, argText);
    }

    public void clickSearchBtn (){
        moveNClick(buttonSearch);
    }

    /**
     * Click an option of dropdown displayed after clicking on search text input
     * @param option inner text of option you'd like to click
     */
    public void clickDropdownOpt (String option){
        moveNClick(searchBoxDropByOption.replace("$Option",option));
    }

    public void setDistanceFilter(String filter){
        moveNClick(radioDistBtnByInnerTxt.replace("$InnerText",filter));
    }

    public void setFeatureFilter (String filter){


        // moveNClick(checkFeatBtnByInnerTxt.replace("$InnerText",filter));
        jsMoveNclick(checkFeatBtnByInnerTxt.replace("$InnerText",filter));
    }

    public int qtyRestaurants (){
        return getAllElements(businessName).size();
    }

    public void clickFirstSearchResult(){
        jsMoveNclick(businessNameByIndexClick);
    }

    public List<String> getBusinessesNStars (){
        int max = qtyRestaurants();
        List<String> businesses = new ArrayList<String>();

        for(int i=1;i<=max;i++){
            String businessName = Find(businessNameByIndex.replace("$Index",Integer.toString(i))).getText();
            String businessStar = Find(businessStarByIndex.replace("$Index",Integer.toString(i))).getAttribute("aria-label");
            businesses.add(businessName + " has a " + businessStar);
        }

        return businesses;
    }

}
