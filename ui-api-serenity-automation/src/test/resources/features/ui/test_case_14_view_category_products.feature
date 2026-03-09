@ui
Feature: Automation Exercise - UI - View category products

  Scenario: User can navigate through product categories
    Given the user is browsing Automation Exercise
    When they open the home page
    Then categories should be visible on the left sidebar
    When they open the "Women" category
    And they select the "Dress" subcategory from "Women"
    Then the category page for "Women - Dress Products" should be visible
    When they open the "Men" category
    And they select the "Tshirts" subcategory from "Men"
    Then the category page for "Men - Tshirts Products" should be visible