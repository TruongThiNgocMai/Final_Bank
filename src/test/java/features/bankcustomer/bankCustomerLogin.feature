
Feature: Bank customer login
  In order to login bank customer, I want to have the login customer feature so that I can login bank customer easily

  Background:
    Given Open Website http://www.way2automation.com/angularjs-protractor/banking/#/customer

  Scenario Outline: Bank customer login successfully
    When I click username as <username>
    And I click customer login button
    Then I verify that customer login successfully with name as <username>

    Examples:
      | username     |
      | Harry Potter |

  Scenario Outline: Bank customer login unsuccessfully
    When I click username as <username>
    And I click customer login button
    Then I verify that customer login unsuccessfully with name as <username>

    Examples:
      | username |
      | Harry    |