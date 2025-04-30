@smoke @ui
Feature: Login button validation
  As a user
  I want the login button to be enabled only when both the username and password fields have input
  So that I can ensure proper validation before attempting to log in

  Background:
    Given I am on the login page

  @positive @validation
  Scenario: Login button remains disabled until both fields have input
    Given the username field is empty
    And the password field is empty
    When I enter "testuser" into the username field
    Then the login button should remain disabled
    When I enter "P@ssw0rd" into the password field
    Then the login button should be enabled

  @negative @validation
  Scenario Outline: Login button remains disabled when one or both fields are empty
    Given the username field is <username>
    And the password field is <password>
    When I check the state of the login button
    Then the login button should remain disabled

    Examples:
      | username   | password   |
      |            |            |
      | testuser   |            |
      |            | P@ssw0rd   |