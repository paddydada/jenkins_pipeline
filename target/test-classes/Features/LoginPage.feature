Feature: Login to HRM Application 
 
   @ValidCredentials
   Scenario: Login with valid credentials
     
    Given User is on Home page
    When User enters username as "Admin"
    And User enters password as "admin123"
    Then User should be able to login sucessfully
     
   @InValidCredentials
   Scenario: Login with invalid credentials
     
    Given User is on Home page
    When User enters username as "username"
    And User enters password as "password"
    Then Login will be unsuccessfull with error message "Invalid credentials"
