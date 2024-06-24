Feature: to test google search func

  Scenario: google validation
    Given open browser
    And user on google page
    When user enter text
    And hit enter
    Then user navigated search result page
