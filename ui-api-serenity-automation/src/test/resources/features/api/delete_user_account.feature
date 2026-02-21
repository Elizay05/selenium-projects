Feature: Automation Exercise - API - User Account - Delete Account

  Scenario: User can delete an account successfully
    Given the user is connected to the API
    When they create a new account
    And they delete account with created credentials
    Then the API response code should be 200
    And the API response message should be "Account deleted!"

  Scenario: User cannot delete an account with invalid credentials
    Given the user is connected to the API
    When they delete an account with email "fake@test.com" and password "wrong"
    Then the API response code should be 404
    And the API response message should be "Account not found!"

  Scenario: User cannot delete account when email is missing
    Given the user is connected to the API
    When they delete an account without email
    Then the API response code should be 400
    And the API response message should be "Bad request, email parameter is missing in DELETE request."

  Scenario: User cannot delete account when password is missing
    Given the user is connected to the API
    When they delete an account without password
    Then the API response code should be 400
    And the API response message should be "Bad request, password parameter is missing in DELETE request."


  Scenario: User cannot delete account when both parameters are missing
    Given the user is connected to the API
    When they delete an account without credentials
    Then the API response code should be 400
    And the API response message should be "Bad request, email parameter is missing in DELETE request."