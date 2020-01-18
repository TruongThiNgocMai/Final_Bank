package tests.bankmanager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static tests.PageProvider.getBankManagerLoginPage;

public class BankManagerLoginTest {

    @When("^I click bank manager login$")
    public void clickBankManagerLoginButtton() throws InterruptedException {
        Thread.sleep(5000);
        getBankManagerLoginPage().clickBankManagerLoginButton();
        Thread.sleep(5000);
    }
    @Then("^I verify login into bank management successfully$")
    public void verifyLoginSuccessfully() throws InterruptedException {
        Thread.sleep(5000);
        getBankManagerLoginPage().verifyLoginManagerSuccessfully();
        Thread.sleep(5000);
    }

}
