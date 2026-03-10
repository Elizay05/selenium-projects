@ui
Feature: Automation Exercise - UI - Login user

  Scenario: User can login with correct email and password
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to Signup Login
    Then the New User Signup section should be visible
    When they register a new account
    Then the account should be created
    When they continue after account creation
    Then they should be logged in
    And they logout
    And they navigate to Signup Login
    Then the Login to your account section should be visible
    When they login with the registered credentials
    Then they should be logged in
    When they delete the account
    Then the account should be deleted

  Scenario: User cannot login with incorrect email and password
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to Signup Login
    Then the Login to your account section should be visible
    When they login with incorrect credentials
    Then an error message should be displayed