Feature: Automation Exercise - API - Brands - PUT Not Allowed

  Scenario: User cannot PUT to brands list
    Given the user is connected to the API
    When they try to put to brands list
    Then the API response code should be 405
    And the API response message should be "This request method is not supported."