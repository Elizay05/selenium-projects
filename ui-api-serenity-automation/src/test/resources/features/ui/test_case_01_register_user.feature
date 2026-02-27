@ui
Feature: Automation Exercise - UI - Register user

  Scenario: User can register and delete the account successfully
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to Signup Login
    Then the New User Signup section should be visible
    When they register a new account
    Then the account should be created
    When they continue after account creation
    Then they should be logged in
    When they delete the account
    Then the account should be deleted