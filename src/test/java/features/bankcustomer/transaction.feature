
Feature: Customer transaction
  In order to customer transaction, I want to have the transaction customer feature so that I can manage transaction easily

  Background:
    Given Open Website http://www.way2automation.com/angularjs-protractor/banking/#/customer

  Scenario Outline: Customer transaction successfully
    When I login successfully with as <username>
    When I deposit successfully with amount as <depositamount>
    When I withdrawal successfully with amount as <withdrawalamount>
    And I click transactions tab
    Then I verify transactions successfully with deposit amount as <depositamount> and withdrawal amount as <withdrawalamount>

    Examples:
      | username     | depositamount | withdrawalamount |
      | Harry Potter | 4000          | 3000             |

  Scenario Outline: Customer transaction unsuccessfully
    When I login successfully with as <username>
    When I deposit successfully with amount as <depositamount>
    When I withdrawal successfully with amount as <withdrawalamount>
    And I click transactions tab
    Then I verify transactions unsuccessfully with wrong deposit amount as <wrongdepositamount> and wrong withdrawal amount as <wrongwithdrawalamount>

    Examples:
      | username     | depositamount | withdrawalamount |wrongdepositamount|wrongwithdrawalamount|
      | Harry Potter | 4000          | 3000             |4000              |4000                 |