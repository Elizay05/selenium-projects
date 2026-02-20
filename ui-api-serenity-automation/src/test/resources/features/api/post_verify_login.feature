Feature: Automation Exercise - API - Login - Verify login

  Scenario: User can verify login after creating account
    Given the user is connected to the API
    When they create a new account
    And they verify login with created credentials
    Then the API response code should be 200
    And the API response message should be "User exists!"

  Scenario: User cannot verify login with invalid credentials
    Given the user is connected to the API
    When they verify login with email "fake@test.com" and password "wrong"
    Then the API response code should be 404
    And the API response message should be "User not found!"

  Scenario: User cannot verify login when parameters are missing
    Given the user is connected to the API
    When they verify login without credentials
    Then the API response code should be 400
    And the API response message should be "Bad request, email or password parameter is missing in POST request."