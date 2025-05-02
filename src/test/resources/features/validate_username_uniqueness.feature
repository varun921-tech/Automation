@registration @validation @backend @database
Feature: Validate username uniqueness during registration
  As a new user
  I want the system to validate the uniqueness of my username during registration
  So that I cannot register with a username that is already in use

  Background:
    Given the registration page is accessible
    And the database contains the following existing usernames:
      | username      |
      | john_doe      |
      | jane_smith    |
      | user123       |

  @positive @validation
  Scenario: Successful registration with a unique username
    Given I am on the registration page
    When I enter a unique username "unique_user"
    And I enter a valid password "Password123"
    And I click the "Register" button
    Then I should be successfully registered
    And I should see a confirmation message "Registration successful"

  @negative @validation
  Scenario: Unsuccessful registration with a duplicate username
    Given I am on the registration page
    When I enter a username "john_doe" that already exists
    And I enter a valid password "Password123"
    And I click the "Register" button
    Then I should see an error message "Username already exists. Please choose a different username."

  @negative @validation @scenario-outline
  Scenario Outline: Unsuccessful registration with various duplicate usernames
    Given I am on the registration page
    When I enter a username "<username>" that already exists
    And I enter a valid password "Password123"
    And I click the "Register" button
    Then I should see an error message "Username already exists. Please choose a different username."

    Examples:
      | username    |
      | john_doe    |
      | jane_smith  |
      | user123     |