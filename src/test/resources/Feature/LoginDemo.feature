Feature: Login Check
  As a user, I want to log in with a valid email and password so that I can access the home page.

  @logon_demo
  Scenario Outline: Login with correct username and password
    Given browser open
    And user on login page
    When user enter "<email>" and "<password>" using page factory
    And user click on submit using page factory
    Then user navigate to home page

    Examples:
      | email                  | password   |
      | saguharihar@gmail.com  | Bathi@1998 |
