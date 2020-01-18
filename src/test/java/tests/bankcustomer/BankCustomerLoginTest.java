package tests.bankcustomer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Constant;

import static tests.PageProvider.getBankCustomerLoginPage;


public class BankCustomerLoginTest {
    @When("^I click username as (.*)$")
    public void clickUsername(String username) throws InterruptedException {
        Thread.sleep(5000);
        getBankCustomerLoginPage().clickOption(username);
        Thread.sleep(5000);
    }

    @And("^I click customer login button$")
    public void clickCustomerLoginButton() throws InterruptedException {
        Thread.sleep(5000);
        getBankCustomerLoginPage().clickSubmit();
        Thread.sleep(5000);
    }

    @Then("^I verify that customer login successfully with name as (.*)$")
    public void verifyCustomerLoginSuccessfully(String username) throws InterruptedException {
        Thread.sleep(5000);
        getBankCustomerLoginPage().checkCustomerLogin(username, Constant.SUCCESS);
        Thread.sleep(5000);
    }

    @Then("^I verify that customer login unsuccessfully with name as (.*)$")
    public void verifyCustomerLoginUnsuccessfully(String username) throws InterruptedException {
        Thread.sleep(5000);
        getBankCustomerLoginPage().checkCustomerLogin(username, Constant.FAILURE);
        Thread.sleep(5000);
    }

}

