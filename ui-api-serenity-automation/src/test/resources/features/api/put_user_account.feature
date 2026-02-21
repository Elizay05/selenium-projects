Feature: Automation Exercise - API - User Account - Update Account

  Scenario: User can update an account successfully
    Given the user is connected to the API
    When they create a new account
    And they update account with created credentials
    Then the API response code should be 200
    And the API response message should be "User updated!"

  Scenario: User cannot update account with invalid credentials
    Given the user is connected to the API
    When they update account with email "fake@test.com" and password "wrong"
    Then the API response code should be 404
    And the API response message should be "Account not found!"

  Scenario: User cannot update account when email is missing
    Given the user is connected to the API
    When they update an account without email
    Then the API response code should be 400
    And the API response message should be "Bad request, email parameter is missing in PUT request."

  Scenario: User cannot update account when password is missing
    Given the user is connected to the API
    When they update an account without password
    Then the API response code should be 400
    And the API response message should be "Bad request, password parameter is missing in PUT request."

  Scenario: User cannot update account when parameters are missing
    Given the user is connected to the API
    When they update an account without credentials
    Then the API response code should be 400
    And the API response message should be "Bad request, email parameter is missing in PUT request."