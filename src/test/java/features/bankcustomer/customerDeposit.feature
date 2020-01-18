
Feature: Customer deposit
  In order to deposit customer, I want to have the deposit feature so that I can deposit easily

  Background:
    Given Open Website http://www.way2automation.com/angularjs-protractor/banking/#/customer

  Scenario Outline: Deposit successfully
    When I login successfully with as <username>
    And I click deposit tab
    And I type deposit amount as <amount>
    And I click deposit button
    Then I verify add deposit successfully with amount as <amount>

    Examples:
      | username     | amount |
      | Harry Potter | 4000   |

  Scenario Outline: Deposit unsuccessfully with negative deposit account
    When I login successfully with as <username>
    And I click deposit tab
    And I type deposit amount as <amount>
    And I click deposit button
    Then I verify add deposit unsuccessfully with negative deposit amount as <amount>

    Examples:
      | username     | amount |
      | Harry Potter | -4000  |

  Scenario Outline: Deposit unsuccessfully without deposit account
    When I login successfully with as <username>
    And I click deposit tab
    And I type deposit amount as <amount>
    And I click deposit button
    Then I verify add deposit unsuccessfully without deposit amount as <amount>

    Examples:
      | username     | amount |
      | Harry Potter |        |
