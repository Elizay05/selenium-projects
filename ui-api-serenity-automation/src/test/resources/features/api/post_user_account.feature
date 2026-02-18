Feature: Automation Exercise - API - User Account - Create Account

  Scenario: User can create an account successfully
    Given the user is connected to the API
    When they create a new account
    Then the API response code should be 201

  Scenario: User cannot create account with existing email
    Given the user is connected to the API
    When they create an account with an existing email
    Then the API response code should be 400
    And the API response message should be "Email already exists!"

  Scenario: User cannot create account without name
    Given the user is connected to the API
    When they create an account without name
    Then the API response code should be 400
    And the API response message should be "Bad request, name parameter is missing in POST request."

  Scenario: User cannot create account without email
    Given the user is connected to the API
    When they create an account without email
    Then the API response code should be 400
    And the API response message should be "Bad request, email parameter is missing in POST request."

  Scenario: User cannot create account without password
    Given the user is connected to the API
    When they create an account without password
    Then the API response code should be 400
    And the API response message should be "Bad request, password parameter is missing in POST request."

  Scenario: User cannot create account without body
    Given the user is connected to the API
    When they create an account without body
    Then the API response code should be 400
    And the API response message should be "Bad request, name parameter is missing in POST request."