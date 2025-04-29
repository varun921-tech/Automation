Feature: Login Page Feature

  Scenario: Successful Login
    Given user is on the login page
    When user enters the "Admin" in the username field
    And user enters the password "admin123" in the password field
    When user clicks on the login button
    Then user lands on the dashboard page