package tests.bankmanager;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import utils.Constant;


import static tests.PageProvider.getCustomerPage;

public class DeleteCustomerTest {

    public static boolean customerIsExist = false;

    @And("^I click delete button with first name as (.*), last name as (.*), post code as (.*) and account number as (.*)$")
    public void clickButtonDelete(String firstname, String lastname, String postcode, String accountnumber) throws InterruptedException {
        customerIsExist = getCustomerPage().verifyCustomerIsExist(firstname, lastname, postcode);
        Thread.sleep(5000);
        getCustomerPage().clickDeleteButton(firstname, lastname, postcode, accountnumber,customerIsExist);
        Thread.sleep(5000);
    }

    @Then("^I verify customer delete successfully with first name as (.*), last name as (.*), post code as (.*) and account number as (.*)$")
    public static void verifyDeleteCustomerSuccessfully(String firstname, String lastname, String postcode, String accountnumber) throws InterruptedException {
        Thread.sleep(5000);
        getCustomerPage().checkDeleteCustomer(firstname, lastname, postcode, accountnumber, Constant.SUCCESS,customerIsExist);
        Thread.sleep(5000);
    }

    @Then("^I verify customer delete unsuccessfully with first name as (.*), last name as (.*), post code as (.*) and account number as (.*)$")
    public static void verifyDeleteCustomerUnsuccessfully(String firstname, String lastname, String postcode, String accountnumber) throws InterruptedException {
        Thread.sleep(5000);
        getCustomerPage().checkDeleteCustomer(firstname, lastname, postcode, accountnumber, Constant.FAILURE,customerIsExist);
        Thread.sleep(5000);
    }

}
