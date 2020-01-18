package tests.bankmanager;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import utils.Constant;

import java.util.ArrayList;
import java.util.List;

import static tests.PageProvider.getCustomerPage;

public class SearchCustomerTest {
    List<WebElement> customerlist = new ArrayList<WebElement>();

    @And("^I input key search as (.*)$")
    public void setKeySearch(String keysearch) throws InterruptedException {
        Thread.sleep(5000);
        customerlist = getCustomerPage().getCustomerList();
        Thread.sleep(5000);
        getCustomerPage().setKeySearch(keysearch);
        Thread.sleep(5000);
    }

    @Then("^I verify that system is already showed customers have (.*)$")
    public void verifySearchCustomerSuccessfully(String keysearch) throws InterruptedException {
        Thread.sleep(5000);
        getCustomerPage().verifySearchCustomer(keysearch, customerlist, Constant.SUCCESS);
        Thread.sleep(5000);
    }

    @Then("^I verify that system is not showed customers have (.*)$")
    public void verifySearchCustomerUnsuccessfully(String keysearch) throws InterruptedException {
        Thread.sleep(5000);
        getCustomerPage().verifySearchCustomer(keysearch, customerlist, Constant.FAILURE);
        Thread.sleep(5000);
    }
}
