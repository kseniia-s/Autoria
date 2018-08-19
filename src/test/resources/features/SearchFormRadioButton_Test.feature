Feature: Checking search form radio button state

  Background:
  Scenario: Radio button "New auto" is selected when user navigates to "New auto" page from top menu
    Given User goes to the main page
    When User clicks on "New auto" from main menu
    Then Radio button "New auto" in search form is selected

  Scenario: Radio button "Auto B/u" is selected when user navigates to "Auto B/u" page from top menu
    And User clicks on "Auto B/u" from main menu
    Then Radio button "Auto B/u" in search form is selected