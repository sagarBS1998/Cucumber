Feature: login check
  @login_demo
  Scenario Outline: login with correct user name and password
    Given browser open
    And user on login page
    When user enter "<email>" and "<password>" using page factory
    And user click on submit using page factory
    Then user navigate to home page
    Then click on setting
    Then search Newsletter
    And click on Submit button

    Examples:
      |email								|password|
      |saguharihar@gmail.com|Bathi@1998|
