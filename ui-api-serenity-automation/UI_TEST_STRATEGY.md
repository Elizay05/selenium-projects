# UI Automation Strategy (Screenplay + Serenity)

This document proposes a scalable way to implement the UI scenarios from Automation Exercise.

## Suggested package structure

```text
src/test/java/com.portfolio.automation/
  runners/
    UiTestSuite.java
  stepdefinitions/ui/
    CommonUiStepDefinitions.java
    ...
  tasks/ui/
    OpenHomePage.java
    LoginWithCredentials.java
    AddProductToCart.java
    ...
  questions/ui/
    VisibleText.java
    CartQuantity.java
    ...
  interactions/ui/
    ScrollToBottom.java
    AcceptAlert.java
    ...
  ui/
    HomePage.java
    LoginPage.java
    CartPage.java
    CheckoutPage.java

src/test/resources/features/ui/
  test_case_01_register_user.feature
  test_case_02_login_correct_credentials.feature
  ...
```

## Incremental implementation plan

1. Build a stable core of reusable Tasks and Targets for:
   - Navigation header
   - Login/Register form
   - Products and cart
   - Checkout and payment flow
2. Implement smoke scenarios first (test cases 2, 4, 7, 8, 9, 12).
3. Reuse the same user data builder used in API for UI credentials.
4. Implement data lifecycle utilities for users created during UI tests.
5. Add the remaining complex scenarios (14, 15, 16, 23, 24, 25, 26).

## Grouping of the 26 UI test cases

- **Account & Session**: 1, 2, 3, 4, 5
- **Contact & static pages**: 6, 7
- **Catalog & search**: 8, 9, 18, 19, 21
- **Subscription**: 10, 11
- **Cart behavior**: 12, 13, 17, 20, 22
- **Checkout & order**: 14, 15, 16, 23, 24
- **Scrolling behavior**: 25, 26

## Naming recommendation

Use one `.feature` file per test case while the suite is growing, then merge related scenarios once stable.

Examples:
- `test_case_01_register_user.feature`
- `test_case_14_place_order_register_while_checkout.feature`

## Good practices

- Keep locators only in `ui/` classes (`Target` constants).
- Keep business actions in `tasks/`.
- Keep assertions in `questions/`.
- Avoid assertions inside tasks.
- Avoid `Thread.sleep`; prefer Serenity waits and state-based assertions.
