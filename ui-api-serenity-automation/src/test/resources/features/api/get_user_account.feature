Feature: Automation Exercise - API - User Account - Retrieve Account

  Scenario: User can retrieve account detail by email
    Given the user is connected to the API
    And they create a new account
    When they request user detail by created email
    Then the API response code should be 200
    And the response should contain the correct user email

  Scenario: User cannot retrieve account detail with invalid email
    Given the user is connected to the API
    When they request user detail with email "fake@hola.com"
    Then the API response code should be 404
    And the API response message should be "Account not found with this email, try another email!"

  Scenario: User cannot retrieve account detail when email is missing
    Given the user is connected to the API
    When they request user detail without email
    Then the API response code should be 400
    And the API response message should be "Bad request, email parameter is missing in GET request."