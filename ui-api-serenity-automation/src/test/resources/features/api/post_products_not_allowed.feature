Feature: Automation Exercise - API - Products - POST Not Allowed

  Scenario: User cannot POST to products list
    Given the user is connected to the API
    When they try to post to products list
    Then the API response code should be 405
    And the API response message should be "This request method is not supported."
