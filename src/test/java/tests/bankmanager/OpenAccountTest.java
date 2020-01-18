package tests.bankmanager;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Constant;

import static tests.PageProvider.*;

public class OpenAccountTest {
    String getOpenAccountPopup = "";
    String accountNumber = "";

    @When("^I click open account tab$")
    public void clickOpenAccountTab() throws InterruptedException {
        Thread.sleep(5000);
        getOpenAccountPage().clickOpenAccountTab();
        Thread.sleep(5000);
    }

    @And("^I choose account as (.+) and currency as (.+)$")
    public void setAccount(String fullname, String currency) throws InterruptedException {
        Thread.sleep(5000);
        getOpenAccountPage().getUserInformation(fullname);
        Thread.sleep(5000);
        getOpenAccountPage().getCurrency(currency);
        Thread.sleep(5000);
    }

    @And("^I click process button$")
    public void clickProcessButton() throws InterruptedException {
        Thread.sleep(5000);
        getOpenAccountPage().clickProcess();
        Thread.sleep(5000);

    }

    @And("^I close popup$")
    public void closePopup() throws InterruptedException {
        Thread.sleep(5000);
        try {
            getOpenAccountPopup = getCommonPage().getAlertPopup();

            String[] result = getOpenAccountPopup.split(":");

            for (int i = 0; i < result.length; i++) {
                if (getCommonPage().isNumeric(result[i])) {
                    accountNumber = result[i];
                }
            }

            Thread.sleep(5000);
            getCommonPage().closeAlertPopup();
            Thread.sleep(5000);
        } catch (NullPointerException e) {
            e.getMessage();
        }

    }

    @Then("^I verify that user is already open with first name as (.*) and last name as (.*)$")
    public void verifyOpenCustomerSuccessfully(String firstname, String lastname) throws InterruptedException {
        Thread.sleep(5000);
        getOpenAccountPage().verifyOpenAccountWithPopup(getOpenAccountPopup, Constant.SUCCESS);
        Thread.sleep(5000);
        getCustomerPage().checkOpenAccountInformation(firstname, lastname, accountNumber);
        Thread.sleep(5000);
    }

    @Then("^I verify that user is not open without currency or full name$")
    public void verifyOpenAccountUnsuccessfullyWithoutCurrency() throws InterruptedException {
        Thread.sleep(5000);
        getOpenAccountPage().verifyOpenAccountWithPopup(getOpenAccountPopup, Constant.FAILURE );
        Thread.sleep(5000);
    }
}
