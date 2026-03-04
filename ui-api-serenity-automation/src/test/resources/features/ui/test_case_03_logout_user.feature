@ui
Feature: Automation Exercise - UI - Logout user

  Scenario: User can logout successfully
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to Signup Login
    Then they register a new account
    And they continue after account creation
    And they logout
    Then the Login to your account section should be visible