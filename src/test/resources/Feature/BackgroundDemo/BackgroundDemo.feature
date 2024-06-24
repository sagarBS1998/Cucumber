
Feature: ckeck for page functionlity

	Background: user in logged i 
		Given user in login page
		When enter email and password
		And click submit
		Then navigated to home
	
  Scenario: check on logout link
   
    When user click on welcome link
    Then logout liink is visiable
    
    
	
  Scenario: verfiy toolbar is present

    When click on dashboard link
    Then quick lunch toolbar displayed
