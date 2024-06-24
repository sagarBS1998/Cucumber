Feature: Feature to test login functionality

  Scenario: Check login is successful with valid credentials

    Given user on the login page
    When user enters valid credentials
    Then user is redirected to the dashboard