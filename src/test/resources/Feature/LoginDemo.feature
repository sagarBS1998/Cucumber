Feature: login check
Scenario Outline: login with correct user name and password
Given brower open
And user on login age
When user enter <email> and <password>
And user click on submit
Then user navigate to home page

Examples: 
|email								|password|
|saguharihar@gmail.com|Bathi@1998|
