
Feature: Add customer
  In order to add customer, I want to have the add customer feature so that I can add customer easily

  Background:
    Given Open Website https://www.way2automation.com/angularjs-protractor/banking/#/login

  Scenario Outline: Add customer successfully
    When I login bank manager successfully
    When I click add customer tab
    And I input first name as <firstname>, last name as <lastname> and post code as <postcode>
    And I click submit
    Then I verify that system is already added customer as <fullname> successfully

    Examples:
      | firstname         | lastname            | postcode | fullname                              |
      | thao              | ngo                 | 550000   | thao ngo                              |
      | <html>thao</html> | <script>ngo</scrip> | 550000   | <html>thao</html> <script>ngo</scrip> |

  Scenario Outline: Add customer unsuccessfully without first name, last name or post code
    When I login bank manager successfully
    When I click add customer tab
    And I input first name as <firstname>, last name as <lastname> and post code as <postcode>
    And I click submit
    Then I verify that system added customer unsuccessfully with full name as <fullname>

    Examples:
      | firstname | lastname | postcode | fullname |
      | thao      |          | 550000   | thao     |
      |           | hoang    | 550000   | hoang    |

  Scenario Outline: Add customer unsuccessfully with existed customer
    When I login bank manager successfully
    When I click add customer tab
    And I input first name as <firstname>, last name as <lastname> and post code as <postcode>
    And I click submit
    Then I verify that system can not add with customer is existed with first name as <firstname>, last name as <lastname> and post code as <postcode>

    Examples:
      | firstname | lastname | postcode |
      | Harry     | Potter   | E725JB   |
