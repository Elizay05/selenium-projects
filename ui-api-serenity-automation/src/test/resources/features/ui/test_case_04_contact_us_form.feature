@ui
Feature: Automation Exercise - UI - Contact Us form

  Scenario: User can submit the contact us form successfully
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to Contact Us
    Then the Get In Touch section should be visible
    When they submit the contact form
    Then a success message should be displayed
    When they return to the home page
    Then they should be on the home page