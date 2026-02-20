Feature: Automation Exercise - API - Brands - Retrieve Brands List

  Scenario: User can retrieve the brands list successfully
    Given the user is connected to the API
    When they request all brands
    Then the API response code should be 200
    And the brands list should not be empty
    And each brand should contain the required fields