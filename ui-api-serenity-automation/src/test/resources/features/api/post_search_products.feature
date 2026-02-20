Feature: Automation Exercise - API - Products - Search Products

  Scenario: User can search products successfully
    Given the user is connected to the API
    When they search products with term "tshirt"
    Then the API response code should be 200
    And the products list should not be empty
    And all products should match the search term "tshirt"

  Scenario: User can retrieve products list without search when parameter is blank
    Given the user is connected to the API
    When they search products with term ""
    Then the API response code should be 200
    And the products list should not be empty

  Scenario: User cannot retrieve products list when product does not exist
    Given the user is connected to the API
    When they search products with term "xyz123random"
    Then the API response code should be 200
    And the products list should be empty

  Scenario: User cannot retrieve products list when parameter is missing
    Given the user is connected to the API
    When they search products without term
    Then the API response code should be 400
    And the API response message should be "Bad request, search_product parameter is missing in POST request."
