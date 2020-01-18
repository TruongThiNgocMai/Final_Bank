package tests.bankcustomer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import tests.CommonTest;
import utils.Constant;

import java.text.ParseException;

import static tests.PageProvider.getTransactionsPage;

public class TransactionTest {

    @Then("^I verify transactions successfully with deposit amount as (.*) and withdrawal amount as (.*)$")
    public void verifyTransactionsSuccessfully(String depositAmount, String withdrawalAmount) throws InterruptedException, ParseException {
        Thread.sleep(5000);
        getTransactionsPage().verifyTransaction(depositAmount, withdrawalAmount, CommonTest.depositTime, CommonTest.withdrawalTime, Constant.SUCCESS);
        Thread.sleep(5000);
    }

    @Then("^I verify transactions unsuccessfully with wrong deposit amount as (.*) and wrong withdrawal amount as (.*)$")
    public void verifyTransactionUnsuccessfully(String wrongdepositAmount, String wrongwithdrawalAmount) throws InterruptedException, ParseException {
        Thread.sleep(5000);
        getTransactionsPage().verifyTransaction(wrongdepositAmount, wrongwithdrawalAmount, CommonTest.depositTime, CommonTest.withdrawalTime, Constant.FAILURE);
        Thread.sleep(5000);
    }
}
