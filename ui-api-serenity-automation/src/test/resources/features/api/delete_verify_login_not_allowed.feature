Feature: Automation Exercise - API - Login - DELETE Not Allowed

  Scenario: User cannot DELETE to verify login
    Given the user is connected to the API
    When they try to delete to verify login
    Then the API response code should be 405
    And the API response message should be "This request method is not supported."
