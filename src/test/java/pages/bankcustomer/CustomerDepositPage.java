package pages.bankcustomer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.CommonTest;
import utils.Constant;

import java.nio.file.WatchEvent;

import static java.lang.Integer.parseInt;
import static org.testng.AssertJUnit.assertEquals;
import static tests.PageProvider.getCommonPage;

public class CustomerDepositPage {
    WebDriver webDriver;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositTab;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement depositAmount;

    @FindBy(xpath = "//button[text()='Deposit']")
    WebElement depositButton;

    @FindBy(xpath = "//div[@class='center']/strong[2]")
    WebElement balance;

    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement message;

    public CustomerDepositPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickDepositTab() {
        this.depositTab.click();
    }

    public void setDepositAmount(String amount) throws InterruptedException {
        if(!amount.equals("")){
            Thread.sleep(5000);
            this.depositAmount.clear();
            Thread.sleep(5000);
            this.depositAmount.sendKeys(amount);
            Thread.sleep(5000);
        }
    }

    public void clickDepositButton() {
        this.depositButton.click();
    }

    public String getBalance() {
        return this.balance.getText();
    }

    public String getMessage() {
        return this.message.getText();
    }

    public void verifyAddDepositAmount(String balanceBeforeAdd, String amount, String check) throws InterruptedException {
        int balance = parseInt(balanceBeforeAdd);
        if (check.equals(Constant.SUCCESS)) {
            Thread.sleep(5000);
            balance += parseInt(amount);
            Thread.sleep(5000);
            assertEquals(parseInt(getBalance()), balance);
            Thread.sleep(5000);
            assertEquals(getMessage(), Constant.DEPOSIT_SUCCESSFULLY_MESSAGE);
            Thread.sleep(5000);
        } else {
            assertEquals(parseInt(balanceBeforeAdd), balance);
            Thread.sleep(5000);
        }
    }

    public void depositSuccessfully(String amount) throws InterruptedException {
        clickDepositTab();
        Thread.sleep(5000);
        setDepositAmount(amount);
        Thread.sleep(5000);
        CommonTest.depositTime = getCommonPage().getCurrentTime();
        Thread.sleep(5000);
        clickDepositButton();
        Thread.sleep(5000);
    }
}
