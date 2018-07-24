Feature: Redirect to login page action

  Scenario: Unauthorized user is redirected to login page on Add Car action
    Given Unauthorized user is on Ria Main Page
    When User "click" on Sell Car button
    Then Auto Page displayed a Login Form