@regression
Feature: Home

  Scenario: Display of Sign In Dialog on Home Page Sign In Button Click
    Given the user is on the home page
    When the user clicks the Sign In button
    Then the Sign In dialog should be displayed with the correct design and text
    And the user click the sign in dialog close button
    Then the dialog should not be displayed