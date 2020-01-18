package tests.bankcustomer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import utils.Constant;

import java.text.ParseException;

import static tests.PageProvider.*;

public class CustomerWithdrawalTest {
    String amountBeforeAdd = "";
    String withdrawalTime = "";

    @And("^I click withdrawal tab$")
    public void clickWithdrawTab() throws InterruptedException {
        Thread.sleep(5000);
        getCustomerWithdrawalPage().clickWithdrawTab();
        Thread.sleep(5000);
        amountBeforeAdd = getCustomerWithdrawalPage().getBalance();
        Thread.sleep(5000);
    }

    @And("^I type withdrawal amount as (.*)$")
    public void setWithdrawalAmount(String amount) throws InterruptedException {
        Thread.sleep(5000);
        getCustomerWithdrawalPage().setWithdrawAmount(amount);
        Thread.sleep(5000);
    }

    @And("^I click withdraw button$")
    public void clickWithdrawalButton() throws InterruptedException {
        Thread.sleep(5000);
        getCustomerWithdrawalPage().clickWithdrawButton();
        withdrawalTime = getCommonPage().getCurrentTime();
        Thread.sleep(5000);
    }

    @Then("^I verify withdrawal successfully with amount as (.*)$")
    public void verifyAddWithdrawalSuccessfully(String amount) throws InterruptedException, ParseException {
        Thread.sleep(5000);
        getCustomerWithdrawalPage().verifyAddWithdrawalAmount(amountBeforeAdd, amount, Constant.SUCCESS);
        Thread.sleep(5000);
        getTransactionsPage().clickTransactionTab();
        Thread.sleep(5000);
        getTransactionsPage().verifyWithdrawal(amount, withdrawalTime, Constant.SUCCESS);
        Thread.sleep(5000);
        getTransactionsPage().clickBackButton();
        Thread.sleep(5000);
    }

    @Then("^I verify withdrawal unsuccessfully without withdrawal amount as (.*)$")
    public void verifyAddWithdrawalUnsuccessfullyWithoutWithdrawalAmount(String amount) throws InterruptedException, ParseException {
        Thread.sleep(5000);
        getCustomerWithdrawalPage().verifyAddWithdrawalAmount(amountBeforeAdd, amount, Constant.FAILURE);
        Thread.sleep(5000);
        getTransactionsPage().clickTransactionTab();
        Thread.sleep(5000);
        getTransactionsPage().verifyWithdrawal(amount, withdrawalTime, Constant.FAILURE);
        Thread.sleep(5000);
        getTransactionsPage().clickBackButton();
        Thread.sleep(5000);
    }

    @Then("^I verify withdrawal unsuccessfully with withdraw amount as (.*) more than the balance$")
    public void verifyWithdrawalUnsuccessfullyWithWithdrawAmountMoreThanBalance(String amount) throws InterruptedException, ParseException {
        Thread.sleep(5000);
        getCustomerWithdrawalPage().verifyAddWithdrawalAmount(amountBeforeAdd, amount, Constant.FAILURE);
        Thread.sleep(5000);
        getTransactionsPage().clickTransactionTab();
        Thread.sleep(5000);
        getTransactionsPage().verifyWithdrawal(amount, withdrawalTime, Constant.FAILURE);
        Thread.sleep(5000);
        getTransactionsPage().clickBackButton();
        Thread.sleep(5000);
    }
}
