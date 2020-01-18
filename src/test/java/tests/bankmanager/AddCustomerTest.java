package tests.bankmanager;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;


import static tests.PageProvider.*;

public class AddCustomerTest {
    public static String addCustomerSuccessPopup = "";

    @When("^I click add customer tab$")
    public static void clickAddCustomerTab() throws InterruptedException {
        getAddCustomerPage().clickAddCustomerTab();
        Thread.sleep(5000);
    }

    @And("^I input first name as (.*), last name as (.*) and post code as (.*)$")
    public static void setUserInformation(String firstname, String lastname, String postcode) throws InterruptedException {
        Thread.sleep(5000);
        getAddCustomerPage().setUserInformation(firstname,lastname,postcode);
        Thread.sleep(5000);
    }

    @And("^I click submit$")
    public static void clickSubmit() throws InterruptedException {
        Thread.sleep(5000);
        getAddCustomerPage().clickSubmit();
        Thread.sleep(5000);
    }

    @Then("^I verify that system is already added customer as (.*) successfully$")
    public static void verifyAddCustomerSuccessfully(String fullname) throws InterruptedException {
        Thread.sleep(5000);
        addCustomerSuccessPopup=getCommonPage().getAlertPopup();
        Thread.sleep(5000);
        getAddCustomerPage().verifyAddCustomerSuccessfullyWithPopup(addCustomerSuccessPopup);
        Thread.sleep(5000);
        getCommonPage().closeAlertPopup();
        Thread.sleep(5000);
        getOpenAccountPage().clickOpenAccountTab();
        Thread.sleep(5000);
        Assert.assertEquals(getOpenAccountPage().checkUserInformation(fullname), true);
        Thread.sleep(5000);
    }

    @Then("^I verify that system added customer unsuccessfully with full name as (.*)$")
    public static void verifyAddCustomerUnsuccessfully(String fullname) throws InterruptedException {
        Thread.sleep(5000);
        getOpenAccountPage().clickOpenAccountTab();
        Thread.sleep(5000);
        Assert.assertEquals(getOpenAccountPage().checkUserInformation(fullname), false);
        Thread.sleep(5000);
    }

    @Then("^I verify that system can not add with customer is existed with first name as (.*), last name as (.*) and post code as (.*)$")
    public static void verifyAddCustomerUnsuccessfullyWithCustomerExisted(String firstname, String lastname, String postcode) throws InterruptedException {
        Thread.sleep(5000);
        String addDuplicateCustomerMessage = getCommonPage().getAlertPopup();
        Thread.sleep(5000);
        getCommonPage().closeAlertPopup();
        Thread.sleep(5000);
        getCustomerPage().clickCustomerTab();
        Thread.sleep(5000);
        boolean verifyCustomerIsExisted = getCustomerPage().verifyCustomerIsExist(firstname, lastname, postcode);
        Thread.sleep(5000);
        getAddCustomerPage().verifyAddCustomerUnsuccessfullyWithExistCustomer(verifyCustomerIsExisted, addDuplicateCustomerMessage);
        Thread.sleep(5000);
    }
}
