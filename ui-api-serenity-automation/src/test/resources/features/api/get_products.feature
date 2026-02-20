Feature: Automation Exercise - API - Products - Retrieve Products List

  Scenario: User can retrieve the products list successfully
    Given the user is connected to the API
    When they request all products
    Then the API response code should be 200
    And the products list should not be empty
    And each product should contain the required fields