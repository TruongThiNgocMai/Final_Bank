package tests.bankcustomer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import tests.CommonTest;
import utils.Constant;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static tests.PageProvider.getTransactionsPage;

public class TransactionSortTest {
    public static int countSort = 0;
    List<String> transactionTimeList = new ArrayList<>();

    @And("^I click date time sort$")
    public void clickDateTimeSort() throws InterruptedException, ParseException {
        Thread.sleep(2000);
        transactionTimeList = getTransactionsPage().getCustomerTransactionTimeList();
        Thread.sleep(2000);
        getTransactionsPage().clickDateTimeTransactionSort();
        Thread.sleep(2000);
        countSort++;
        Thread.sleep(2000);
    }

    @Then("^I verify sort transactions successfully$")
    public void verifySortTransactionSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        getTransactionsPage().verifyTransactionSort(transactionTimeList, Constant.SUCCESS, countSort);
        Thread.sleep(2000);
    }

    @Then("^I verify sort transactions unsuccessfully$")
    public void verifySortTransactionUnsuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        getTransactionsPage().verifyTransactionSort(transactionTimeList, Constant.FAILURE, countSort);
        Thread.sleep(2000);
    }

}
