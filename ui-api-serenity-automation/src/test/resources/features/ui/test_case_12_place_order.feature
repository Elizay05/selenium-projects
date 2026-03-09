@ui
Feature: Automation Exercise - UI - Place Order

  Scenario: User can place an order registering during checkout
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to products page
    Then the products page should be visible
    When they add the following products to the cart
      | Men Tshirt |
      | Sleeveless Dress |
    And they navigate to cart page
    Then the cart page should be visible
    And they proceed to checkout
    And they choose to register or login
    Then the New User Signup section should be visible
    And they register a new account
    Then the account should be created
    When they navigate to cart page
    Then the cart page should be visible
    And they proceed to checkout
    Then the checkout page should be visible
    And they place the order
    Then the order should be placed successfully
    When they delete the account
    Then the account should be deleted

  Scenario: User can place an order registering before checkout
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to Signup Login
    Then the New User Signup section should be visible
    When they register a new account
    Then the account should be created
    When they navigate to products page
    Then the products page should be visible
    When they add the following products to the cart
      | Blue Top |
      | Sleeveless Dress |
    And they navigate to cart page
    Then the cart page should be visible
    And they proceed to checkout
    Then the checkout page should be visible
    And they place the order
    Then the order should be placed successfully
    When they delete the account
    Then the account should be deleted

  Scenario: User can place an order logging in before checkout
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to Signup Login
    Then the New User Signup section should be visible
    Then they register a new account
    And they continue after account creation
    And they logout
    And they navigate to Signup Login
    Then the Login to your account section should be visible
    When they login with the registered credentials
    Then they should be logged in
    When they navigate to products page
    Then the products page should be visible
    When they add the following products to the cart
      | Blue Top |
      | Men Tshirt |
    And they navigate to cart page
    Then the cart page should be visible
    And they proceed to checkout
    Then the checkout page should be visible
    And they place the order
    Then the order should be placed successfully
    When they delete the account
    Then the account should be deleted