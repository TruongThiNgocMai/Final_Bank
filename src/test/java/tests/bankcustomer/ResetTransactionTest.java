package tests.bankcustomer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Constant;

import static tests.PageProvider.getTransactionsPage;

public class ResetTransactionTest {

    @And("^I click reset button$")
    public void clickResetButton() throws InterruptedException {
        Thread.sleep(5000);
        getTransactionsPage().clickResetButton();
        Thread.sleep(5000);
    }

    @Then("^I verify reset transactions successfully$")
    public void verifyResetTransactionSuccessfully() throws InterruptedException {
        Thread.sleep(5000);
        getTransactionsPage().verifyResetTransaction(Constant.SUCCESS);
        Thread.sleep(5000);
    }

    @Then("^I verify reset transactions unsuccessfully$")
    public void verifyResetTransactionUnsuccessfully() throws InterruptedException {
        Thread.sleep(5000);
        getTransactionsPage().verifyResetTransaction(Constant.FAILURE);
        Thread.sleep(5000);
    }
}
