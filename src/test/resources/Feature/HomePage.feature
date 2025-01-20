Feature: Open and test the studyabroad pages
  @Home1
  Scenario: verify that open is opened
    Given user open the home page
    And verify page opened
    Then identify the form title
    And Add full name
    And add email address
    And add phone number
    And click on Book your free counseling CTA
    And enter OTP
    Then find Enter your details to recommend you the best universities & programs! popup
    And select country want to study?
    And select type of degree want to do
    And select nearest upgrad city export
    And click on next CTA
    Then find A few more details to customize your study abroad journey! popup
    And want to complete bachelors
    And which stream you want
    And have you given any exams yet
    And click on Book your free counseling CTA


