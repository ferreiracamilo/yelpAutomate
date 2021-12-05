package stepDefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.BasePage;
import pages.MainPage;
import pages.RestaurantPage;

public class SearchSteps {
    MainPage mainp = new MainPage();
    RestaurantPage restp = new RestaurantPage();
    Scenario scenario;

    @Before
    public void beforeScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^user access \"([^\"]*)\"$")
    public void user_access(String arg1) throws Throwable {
        BasePage.navigateTo(arg1);
    }

    @Given("^selects \"([^\"]*)\" from dropdown in searchbox$")
    public void selects_restaurant_from_dropdown_in_search_box(String arg1) throws Throwable {
        mainp.clickSearchbox();
        mainp.clickDropdownOpt(arg1);
    }

    @Given("^append \"([^\"]*)\" to Restaurants on searchbox$")
    public void append_to_Restaurants_on_searchbox(String arg1) throws Throwable {
        Thread.sleep(100);
        mainp.writeInSearchBox(" "+arg1);
        mainp.clickSearchBtn();
    }

    @Given("^filter distance by (.+) and features by (.+)$")
    public void filter_distance_by_unval_and_features_by_otro_val(String distanceVal,String featureVal) throws Throwable {
        Thread.sleep(100);
        mainp.setFeatureFilter(featureVal);
        Thread.sleep(100);
        mainp.setDistanceFilter(distanceVal);
    }

    @When("^search results are displayed$")
    public void search_results_are_displayed() throws Throwable {
        Assert.assertTrue(mainp.qtyRestaurants()>0);
    }

    @Then("^report number of results, name and star rating of restaurants$")
    public void report_number_of_results_name_and_star_rating_of_restaurants() throws Throwable {
        scenario.log("** Restaurants found and its star rating **");
        for (String element : mainp.getBusinessesNStars()){
            System.out.println(element);
            scenario.log(element);
        }
    }

    @Then("^visit first restaurant page to retrieve address, phone no, website details and first three customer reviews$")
    public void visit_first_restaurant_page_to_retrieve_address_phone_no_website_details_and_first_customer_reviews() throws Throwable {
        mainp.clickFirstSearchResult();
        scenario.log("** Details from first result found **");
        scenario.log("THIS IS THE ADDRESS -> " + restp.getAddress());
        scenario.log("THIS IS THE PHONE -> " + restp.getPhone());
        scenario.log("THIS IS THE WEBSITE -> " + restp.getWebsite());
        scenario.log("** List of first 3 reviews **");

        int index = 1;
        for(String element : restp.getTopThreeRevs()){
            scenario.log("#REVIEW " + index + "\n" + element);
            index++;
        }
    }

}
