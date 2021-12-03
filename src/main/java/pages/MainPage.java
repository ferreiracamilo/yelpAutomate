package pages;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class MainPage extends BasePage{

    /**
     * Region Variables
     */
    private String searchBoxInput = "//input[@name='find_desc']";
    private String searchBoxButton = "//span[@class='pseudo-input_text business-search-form_input-text' and contains(text(),'Find')]";
    private String searchBoxDropByOption = "//ul[@class='suggestions-list'] //span[contains (text(),'$Option')]";
    private String buttonSearch = "//button[@id='header-search-submit' or @data-testid='suggest-submit']";
    private String radioDistBtnByInnerTxt = "//span [contains ( text (), '$InnerText' )] //ancestor::div[3] //input[@type='radio']";
    private String checkFeatBtnByInnerTxt = "//span [contains ( text (), '$InnerText' )] //ancestor::div[3] //input[@type='checkbox']";
    private String businessName = "//h4 //a";
    private String businessNameByIndex = "(//h4 //a) [$Index]";
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
        moveNClick(checkFeatBtnByInnerTxt.replace("$InnerText",filter));
    }

    public int qtyRestaurants (){
        return getAllElements(businessName).size();
    }

    public void clickFirstSearchResult(){
        moveNClick(businessNameByIndex.replace("$Index","1"));
    }

    public void printNreportVals (){
        int max = qtyRestaurants()+1;
        for(int i=1;i<=max;i++){
            System.out.println(businessNameByIndex.replace("$Index",Integer.toString(i)) + " has a " + businessStarByIndex.replace("$Index",Integer.toString(i)));
        }
    }

}
