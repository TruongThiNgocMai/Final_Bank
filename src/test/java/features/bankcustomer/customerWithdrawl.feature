
Feature: Customer withdrawal
  In order to withdrawal customer, I want to have the withdrawal feature so that I can withdrawal easily

  Background:
    Given Open Website http://www.way2automation.com/angularjs-protractor/banking/#/customer

  Scenario Outline: Customer withdrawal successfully
    When I login successfully with as <username>
    When I deposit successfully with amount as <depositamount>
    And I click withdrawal tab
    And I type withdrawal amount as <withdrawalamount>
    And I click withdraw button
    Then I verify withdrawal successfully with amount as <withdrawalamount>

    Examples:
      | username     | withdrawalamount | depositamount |
      | Harry Potter | 2000             | 4000          |

  Scenario Outline: Customer withdrawal unsuccessfully without withdrawal amount
    When I login successfully with as <username>
    When I deposit successfully with amount as <depositamount>
    And I click withdrawal tab
    And I type withdrawal amount as <withdrawalamount>
    And I click withdraw button
    Then I verify withdrawal unsuccessfully without withdrawal amount as <withdrawalamount>

    Examples:
      | username     | withdrawalamount | depositamount |
      | Harry Potter |                  | 4000          |

  Scenario Outline: Customer withdrawal unsuccessfully with withdraw amount more than the balance
    When I login successfully with as <username>
    When I deposit successfully with amount as <depositamount>
    And I click withdrawal tab
    And I type withdrawal amount as <withdrawalamount>
    And I click withdraw button
    Then I verify withdrawal unsuccessfully with withdraw amount as <withdrawalamount> more than the balance

    Examples:
      | username     | withdrawalamount | depositamount |
      | Harry Potter | 4000000          | 4000          |
