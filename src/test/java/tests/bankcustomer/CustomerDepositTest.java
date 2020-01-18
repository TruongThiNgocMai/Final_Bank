package tests.bankcustomer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CommonPage;
import utils.Constant;

import java.text.ParseException;
import java.time.LocalDateTime;

import static tests.PageProvider.*;

public class CustomerDepositTest {
    String amountBeforeAdd = "";
    String depositTime = "";

    @And("^I click deposit tab$")
    public void clickDepositTab() throws InterruptedException {
        Thread.sleep(5000);
        getCustomerDepositPage().clickDepositTab();
        Thread.sleep(5000);
        amountBeforeAdd = getCustomerDepositPage().getBalance();
        Thread.sleep(5000);
    }

    @And("^I type deposit amount as (.*)$")
    public void setAmount(String amount) throws InterruptedException {
        Thread.sleep(5000);
        getCustomerDepositPage().setDepositAmount(amount);
        Thread.sleep(5000);
    }

    @And("^I click deposit button$")
    public void clickDepositButton() throws InterruptedException {
        Thread.sleep(5000);
        getCustomerDepositPage().clickDepositButton();
        depositTime = getCommonPage().getCurrentTime();
        Thread.sleep(5000);
    }

    @Then("^I verify add deposit successfully with amount as (.*)$")
    public void verifyAddDepositSuccessfully(String amount) throws InterruptedException, ParseException {
        Thread.sleep(5000);
        getCustomerDepositPage().verifyAddDepositAmount(amountBeforeAdd, amount, Constant.SUCCESS);
        Thread.sleep(5000);
        getTransactionsPage().clickTransactionTab();
        Thread.sleep(5000);
        getTransactionsPage().verifyDepositInTransaction(amount, depositTime, Constant.SUCCESS);
        Thread.sleep(5000);
        getTransactionsPage().clickBackButton();
        Thread.sleep(5000);
    }
    @Then("^I verify add deposit unsuccessfully with negative deposit amount as (.*)$")
    public void verifyAddDepositUnsuccessfullyWithNegativeDepositAmount(String amount) throws InterruptedException, ParseException {
        Thread.sleep(5000);
        getCustomerDepositPage().verifyAddDepositAmount(amountBeforeAdd, amount, Constant.FAILURE);
        Thread.sleep(5000);
        getTransactionsPage().clickTransactionTab();
        Thread.sleep(5000);
        getTransactionsPage().verifyDepositInTransaction(amount, depositTime,Constant.FAILURE);
        Thread.sleep(5000);
        getTransactionsPage().clickBackButton();
        Thread.sleep(5000);
    }

    @Then("^I verify add deposit unsuccessfully without deposit amount as (.*)$")
    public void verifyDepositUnsuccessfullyWithoutAmount(String amount) throws InterruptedException, ParseException {
        Thread.sleep(5000);
        getCustomerDepositPage().verifyAddDepositAmount(amountBeforeAdd, amount, Constant.FAILURE);
        Thread.sleep(5000);
        getTransactionsPage().clickTransactionTab();
        Thread.sleep(5000);
        getTransactionsPage().verifyDepositInTransaction(amount, depositTime,Constant.FAILURE);
        Thread.sleep(5000);
        getTransactionsPage().clickBackButton();
        Thread.sleep(5000);
    }
}
