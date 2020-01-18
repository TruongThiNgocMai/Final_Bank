package pages.bankmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constant;

import static org.testng.AssertJUnit.assertEquals;

public class AddCustomerPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//button[contains(text(), 'Add Customer')][1]")
    WebElement addCustomerTab;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstname;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastname;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postcode;

    @FindBy(xpath = "//form/button[contains(text(), 'Add Customer')]")
    WebElement submit;

    public AddCustomerPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setFirstname(String firstname) {
        this.firstname.clear();
        this.firstname.sendKeys(firstname);
    }

    public void setLastname(String lastname) {
        this.lastname.clear();
        this.lastname.sendKeys(lastname);
    }

    public void setPostcode(String postcode) {
        this.postcode.clear();
        this.postcode.sendKeys(postcode);
    }

    public void clickSubmit() {
        this.submit.click();
    }

    public void clickAddCustomerTab() {
        this.addCustomerTab.click();
    }

    public void setUserInformation(String firstname, String lastname, String postcode) {
        this.firstname.clear();
        if (!firstname.equals("null")) {
            this.firstname.sendKeys(firstname);
        }
        this.lastname.clear();
        if (!lastname.equals("null")) {
            this.lastname.sendKeys(lastname);
        }
        this.postcode.clear();
        if (!postcode.equals("null")) {
            this.postcode.sendKeys(postcode);
        }
    }

    public void verifyAddCustomerUnsuccessfullyWithExistCustomer(boolean customerIsExist, String addPopup){
        assertEquals(customerIsExist, true);
        assertEquals(addPopup, Constant.ADD_CUSTOMER_DUPLICATE_MESSAGE);
    }

    public void verifyAddCustomerSuccessfullyWithPopup(String addPopup){
        assertEquals(addPopup.contains(Constant.ADD_CUSTOMER_SUCCESSFULLY_MESSAGE),true);
    }
}
