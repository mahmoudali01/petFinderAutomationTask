@regression
Feature: Sign Up

  Background:
    Given the user is on the home page
    When the user clicks the Sign In button
    And the user clicks the create account button

  Scenario: Verify that Sign up page design and text is correct
    Then the user get redirect to sign up page with correct design and text

  Scenario: Verify that user get redirected to sign in page when click sign in link
    When the user clicks sign in link
    Then the user get redirect to login page with correct design and text

  Scenario Outline: Verify that user must enter valid email
    When the user fills the Email field with "<EmailSample>"
    And the user clicks Continue button
    Then Validation message "<Validation>" is Displayed
    Examples:
      | EmailSample | Validation                         |
      | Test        | Email is missing @                 |
      | Test@Test   | Email is missing a domain ex: .com |

  Scenario: Verify that postal code must be valid on tell us about your self form
    When the user fills the Email field with valid email
    And the user clicks Continue button
    And the user fills first name last name and invalid postal code
    Then invalid postal code validation is displayed

  Scenario: Verify that user can sign up correctly
    When the user fills the Email field with valid email
    And the user clicks Continue button
    And the user fills tell us about your self form with valid data
    And the user clicks Continue button
    And the user enters password confirm password and check terms and conditions
    And the user clicks Continue button
    Then verify email message should be displayed
