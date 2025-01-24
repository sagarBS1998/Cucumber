Feature: Open and test the IELTS pages
  @IELTS1
  Scenario: verify that open is opened1
    Given user open the home page1
    And verify page opened1
    Then verify delay popup is opend1
    Then verify the text Unlock Your SAT Success: Explore Expert Articles & Tips Now!
    And add email address1