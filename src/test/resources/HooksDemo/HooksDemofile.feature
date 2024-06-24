Feature: login
	@smoke
  Scenario: check now
    Given login page
    When enter email and password
    And click submit
    Then navigate to result page
    
    @smoke
    Scenario: check now
    Given login page
    When enter email and password
    And click submit
    Then navigate to result page