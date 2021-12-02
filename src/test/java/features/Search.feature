Feature: Search scenario for yelp automation

  @do
  Scenario Outline: Retrieve search results
  Given user access "https://www.yelp.com/"
  And selects "Restaurants" from dropdown in search box
  And append "pizza" to Restaurants on searchbox
  And filter distance by <valueDist> and features by <valueFeat>
  When search results are displayed
  Then report number of results, name and star rating of restaurants
  And visit first restaurant page to retrieve address, phone no, website details and first 3 customer reviews

    Examples:
      | valueDist       | valueFeat       |
      | Driving (5 mi.) | Good for Groups |
      | Biking (2 mi.)  | Good for Kids   |
      | Walking (1 mi.) | Has TV          |