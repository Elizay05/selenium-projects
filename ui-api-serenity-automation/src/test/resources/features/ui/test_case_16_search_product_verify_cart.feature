@ui
Feature: Automation Exercise - UI - Search products and verify cart after login

  Scenario: User searches products and verifies cart after login
    Given the user is browsing Automation Exercise
    When they open the home page
    And they navigate to products page
    Then the products page should be visible
    When they search for "Saree"
    Then the searched products section should be visible
    And all products related to "Saree" should be visible
    When they add searched products to the cart
    And they navigate to cart page
    And the cart should contain the following products
      | Product                                   | Price  | Qty | Total  |
      | Cotton Silk Hand Block Print Saree        | 3000   | 1   | 3000   |
      | Rust Red Linen Saree                      | 3500   | 1   | 3500   |
      | Beautiful Peacock Blue Cotton Linen Saree | 5000   | 1   | 5000   |
    And they navigate to Signup Login
    Then the New User Signup section should be visible
    Then they register a new account
    And they continue after account creation
    And they logout
    And they navigate to Signup Login
    Then the Login to your account section should be visible
    When they login with the registered credentials
    Then they should be logged in
    And they navigate to cart page
    And the cart should contain the following products
      | Product                                   | Price  | Qty | Total  |
      | Cotton Silk Hand Block Print Saree        | 3000   | 1   | 3000   |
      | Rust Red Linen Saree                      | 3500   | 1   | 3500   |
      | Beautiful Peacock Blue Cotton Linen Saree | 5000   | 1   | 5000   |