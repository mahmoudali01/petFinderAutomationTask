@regression
Feature: Login

  Background:
    Given the user is on the home page
    When the user clicks the Sign In button
    And the user clicks the login button

  Scenario: Verify that Sign up page design and text is correct
    Then the user get redirect to login page with correct design and text

  Scenario: Verify that validation message is displayed when user enter invalid credentials
    When the user fills invalid email and password fields
    And the user clicks sign in button
    Then user does not exist validation is displayed

  Scenario: Verify that user get redirected to sign up page when click sign up link
    When the user clicks sign up link
    Then the user get redirect to sign up page with correct design and text

  Scenario: Verify that user get redirected to forget password page when click forget password link
    When the user clicks forget password link
    Then the user get redirect to reset password page

  Scenario: Verify that user can login correctly with valid credentials
    When the user fills valid credentials
    And the user clicks sign in button
    Then the user gets redirected to his profile

