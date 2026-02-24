@ui
Feature: Automation Exercise - UI - Verify Test Cases page

  Scenario: User can open the Test Cases page from home
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to Test Cases
    Then the Test Cases page title should be visible
