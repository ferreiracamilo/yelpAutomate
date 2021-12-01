package pages;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class MainPage extends BasePage{

    /**
     * Region Variables
     */
    private String searchBoxInput = "//input[@name='find_desc']";
    private String searchBoxDropByOption = "//ul[@class='suggestions-list'] //span[contains (text(),'$Option')]";
    private String buttonSearch = "//button[@id='header-search-submit']";
    private String radioDistBtnByInnerTxt = "//span [contains ( text (), '$InnerText' )] //ancestor::div[3] //input[@type='radio']";
    private String checkFeatBtnByInnerTxt = "//span [contains ( text (), '$InnerText' )] //ancestor::div[3] //input[@type='checkbox']";
    private String businessName = "//h4 //a";
    private String businessNameByIndex = "(//h4 //a) [$Index]";
    private String businessStarByIndex = "(//h4 //a /ancestor::div[4] //div[contains (@class,'i-stars')] ) [$Index]";

    private HashMap<String, String> restaurantsInfo = new HashMap<String, String>();

    /**
     * Region Constructor
     */
    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Region Methods
     */

    public void writeInSearchBox(String argText){
        write(searchBoxInput," " + argText);
    }

    public void clickSearchBtn (){
        Find(buttonSearch).click();
    }

    /**
     * Click an option of dropdown displayed after clicking on search text input
     * @param option inner text of option you'd like to click
     */
    public void clickDropdownOpt (String option){
        Find(searchBoxDropByOption.replace("$Option",option)).click();
    }

    public void setDistanceFilter(String filter){
        Find(radioDistBtnByInnerTxt.replace("$InnerText",filter)).click();
    }

    public void setFeatureFilter (String filter){
        Find(checkFeatBtnByInnerTxt.replace("$InnerText",filter)).click();
    }

    public int qtyRestaurants (){
        return getAllElements(businessName).size();
    }

    public void clickFirstSearchResult(){
        Find(businessNameByIndex.replace("$Index","1")).click();
    }

    public void printNreportVals (){
        int max = qtyRestaurants()+1;
        for(int i=1;i<=max;i++){
            System.out.println(businessNameByIndex.replace("$Index",Integer.toString(i)) + " has a " + businessStarByIndex.replace("$Index",Integer.toString(i)));
            System.out.println();
        }
    }

}
