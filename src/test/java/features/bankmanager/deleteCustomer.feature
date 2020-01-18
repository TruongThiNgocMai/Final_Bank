
Feature: Delete customer
  In order to delete customer, I want to have the deleting customer feature so that I can delete customer easily

  Background:
    Given Open Website https://www.way2automation.com/angularjs-protractor/banking/#/login

  Scenario Outline: Delete customer successfully
    When I login bank manager successfully
    When I click customer tab
    And I click delete button with first name as <firstname>, last name as <lastname>, post code as <postcode> and account number as <accountnumber>
    Then I verify customer delete successfully with first name as <firstname>, last name as <lastname>, post code as <postcode> and account number as <accountnumber>

    Examples:
      | firstname | lastname | postcode | accountnumber |
      | Harry     | Potter   | E725JB   | 1004          |

  Scenario Outline: Delete customer unsuccessfully
    When I login bank manager successfully
    When I click customer tab
    And I click delete button with first name as <firstname>, last name as <lastname>, post code as <postcode> and account number as <accountnumber>
    Then I verify customer delete unsuccessfully with first name as <firstname>, last name as <lastname>, post code as <postcode> and account number as <accountnumber>

    Examples:
      | firstname  | lastname | postcode | accountnumber |
      | HarryHarry | Potter   | E725JB   | 1004          |