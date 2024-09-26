Feature: register

  Scenario: register with invalid credentials
     
    Given User is on Home page
    When User enters username as "username"
    And User enters password as "password"
    Then Login will be unsuccessfull with error message "Invalid credentials"