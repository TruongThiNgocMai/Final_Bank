
Feature: Reset transaction
  In order to reset transaction, I want to have the reset transaction feature so that I can reset transaction easily when I have a lot of transaction

  Background:
    Given Open Website http://www.way2automation.com/angularjs-protractor/banking/#/customer

  Scenario Outline: Reset transaction successfully
    When I login successfully with as <username>
    When I deposit successfully with amount as <depositamount>
    When I withdrawal successfully with amount as <withdrawalamount>
    When I click transactions tab
    And I click reset button
    Then I verify reset transactions successfully

    Examples:
      | username     | depositamount | withdrawalamount |
      | Harry Potter | 4000          | 3000             |

  Scenario Outline: Reset transaction unsuccessfully
    When I login successfully with as <username>
    When I deposit successfully with amount as <depositamount>
    When I withdrawal successfully with amount as <withdrawalamount>
    When I click transactions tab
    And I click reset button
    Then I verify reset transactions unsuccessfully

    Examples:
      | username     | depositamount | withdrawalamount |
      | Harry Potter | 4000          | 3000             |