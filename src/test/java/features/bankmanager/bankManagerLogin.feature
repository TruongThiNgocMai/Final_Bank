
Feature: Login into bank manager
  In order to login bank manager, I want to have the login manager feature so that I can login bank manager easily

  Background:
    Given Open Website https://www.way2automation.com/angularjs-protractor/banking/#/login

  Scenario: Login into bank management successfully
    When I click bank manager login
    Then I verify login into bank management successfully

