
Feature: Home Page scenario check
  
Background: 
Given User has already logged in to the application
      | uid           | pwd          | 
      | standard_user | secret_sauce |
  
  Scenario: Home Page logo check
    
    When User gets the logo text of the Home Page
    
    Then Home page should appear with logo "Products"
    

  
  Scenario: Home Page menu check
    
    When User click on menu button on top left 
    Then User gets menu item links

    |All Items|
    |About|
    |Logout|
    |Reset App State|
    And Links count should be 4
