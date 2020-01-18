
Feature: Open Account
  In order to open account, I want to have the adding customer feature so that I can add customer easily

  Background:
    Given Open Website https://www.way2automation.com/angularjs-protractor/banking/#/login

  Scenario Outline:  Open account successfully
    When I login bank manager successfully
    When I click open account tab
    And  I choose account as <fullname> and currency as <currency>
    And I click process button
    And I close popup
    And I click customer tab
    Then I verify that user is already open with first name as <firstname> and last name as <lastname>
    Examples:
      | fullname     | currency | firstname | lastname |
      | Harry Potter | Pound    | Harry     | Potter   |

  Scenario Outline:  Open account unsuccessfully
    When I login bank manager successfully
    When I click open account tab
    And  I choose account as <fullname> and currency as <currency>
    And I click process button
    And I click customer tab
    Then I verify that user is not open without currency or full name
    Examples:
      | fullname     | currency |
      | Harry Potter | null     |
      | null         | Pound    |