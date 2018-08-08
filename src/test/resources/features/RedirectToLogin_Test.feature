Feature: Redirect to login page action

  Background:
  Scenario: Unauthorized user sees "Вход в кабинет" link
    Given User goes to the main page
    Then Unauthorized user should see "Вход в кабинет" link in the top of the page

  Scenario: Unauthorized user is redirected to login page
    And Unauthorized user clicks on Sell Car button
    Then Auto Page displays a Login Form