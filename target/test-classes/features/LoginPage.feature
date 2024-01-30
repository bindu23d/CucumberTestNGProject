#Author: bindusingh23@gmail.com

Feature: User login scenario check
Background: User navigates to site
Given User is on login page

 Scenario: Login Page title check
    When I get the title of Login Page
    
    Then Login Page title should be "Swag Labs"


  
  Scenario: Login with correct credentials
    When I enter userid and password
      | uid           | pwd          | 
      | standard_user | secret_sauce | 
      
     
    And Click on Login button
    Then Home page should appear with logo "Products"
    Scenario Outline: Login with wrong credentials
    When I enter wrong userid "<uid>" and password "<pwd>"
    And I click on Login button
    Then Error message should appear
    Examples:
      | uid   | pwd   | 
      | pony  | goofy | 
      | goofy | abc   |
    