package pages.bankcustomer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.CommonTest;
import utils.Constant;

import static java.lang.Integer.parseInt;
import static org.testng.AssertJUnit.assertEquals;
import static tests.PageProvider.getCommonPage;

public class CustomerWithdrawalPage {
    WebDriver webDriver;

    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawlTab;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withdrawlAmount;

    @FindBy(xpath = "//button[text()='Withdraw']")
    WebElement withdrawlButton;

    @FindBy(xpath = "//div[@class='center']/strong[2]")
    WebElement balance;

    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement message;

    public CustomerWithdrawalPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickWithdrawTab() {
        this.withdrawlTab.click();
    }

    public void setWithdrawAmount(String amount) throws InterruptedException {
        Thread.sleep(5000);
        this.withdrawlAmount.clear();
        Thread.sleep(5000);
        this.withdrawlAmount.sendKeys(amount);
        Thread.sleep(5000);
    }

    public void clickWithdrawButton() {
        this.withdrawlButton.click();
    }

    public String getBalance() {
        return this.balance.getText();
    }

    public String getMessage() {
        return this.message.getText();
    }

    public void verifyAddWithdrawalAmount(String balanceBeforeAdd, String amount, String check) throws InterruptedException {
        int balance = parseInt(balanceBeforeAdd);
        if (check.equals(Constant.SUCCESS)) {
            balance -= parseInt(amount);
            Thread.sleep(5000);
            assertEquals(parseInt(getBalance()), balance);
            Thread.sleep(5000);
            assertEquals(getMessage(), Constant.WITHDRAWAL_SUCCESSFULLY_MESSAGE);
            Thread.sleep(5000);
        } else {
            assertEquals(parseInt(balanceBeforeAdd), balance);
            Thread.sleep(5000);
        }

    }

    public void withdrawalSuccessfully(String amount) throws InterruptedException {
        Thread.sleep(5000);
        clickWithdrawTab();
        Thread.sleep(5000);
        setWithdrawAmount(amount);
        Thread.sleep(5000);
        clickWithdrawButton();
        CommonTest.withdrawalTime = getCommonPage().getCurrentTime();
        Thread.sleep(5000);
    }
}
