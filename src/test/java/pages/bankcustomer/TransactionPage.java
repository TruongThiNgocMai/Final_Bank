package pages.bankcustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constant;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static tests.PageProvider.getCommonPage;

public class TransactionPage {
    WebDriver webDriver;

    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionsTab;

    @FindBy(xpath = "//table[@class='table table-bordered table-striped']")
    WebElement transactionTable;

    @FindBy(xpath = "//button[text()='Back']")
    WebElement backButton;

    @FindBy(xpath = "//button[text()='Reset']")
    WebElement resetButton;

    @FindBy(xpath = "//table//tr//td[1]/a")
    WebElement dateTimeSort;

    public TransactionPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickTransactionTab() {
        this.transactionsTab.click();
    }

    public void clickBackButton() {
        this.backButton.click();
    }

    public void clickResetButton() {
        this.resetButton.click();
    }

    public void clickDateTimeTransactionSort() {
        this.dateTimeSort.click();
    }

    public void verifyTransaction(String depositAmount, String withdrawalAmount, String depositTime, String withdrawalTime, String check) throws ParseException {
        List<WebElement> rows = transactionTable.findElements(By.tagName("tr"));
        boolean verify = false;
        int count = 0;

        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            if (cols.get(2).getText().equals("Credit")) {
                if (getCommonPage().formatDateTime(cols.get(0).getText()).equals(depositTime) && cols.get(1).getText().equals(depositAmount)) {
                    count++;
                }
            }
            if (cols.get(2).getText().equals("Debit")) {
                if (getCommonPage().formatDateTime(cols.get(0).getText()).equals(withdrawalTime) && cols.get(1).getText().equals(withdrawalAmount)) {
                    count++;
                }
            }
        }

        if (count == 2) {
            verify = true;
        }

        if (check.equals(Constant.SUCCESS)) {
            assertEquals(verify, true);
        } else {
            assertEquals(verify, false);
        }

    }

    public void verifyDepositInTransaction(String depositAmount, String depositTime, String check) throws ParseException {
        List<WebElement> rows = transactionTable.findElements(By.tagName("tr"));
        boolean verify = false;

        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            if (cols.get(2).getText().equals("Credit")) {
                if (getCommonPage().formatDateTime(cols.get(0).getText()).equals(depositTime) && cols.get(1).getText().equals(depositAmount)) {
                    verify = true;
                }
            }
        }
        if (check.equals(Constant.SUCCESS)) {
            assertEquals(verify, true);
        } else {
            assertEquals(verify, false);
        }

    }

    public void verifyWithdrawal(String withdrawalAmount, String withdrawalTime, String check) throws ParseException {
        List<WebElement> rows = transactionTable.findElements(By.tagName("tr"));
        boolean verify = false;

        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            if (cols.get(2).getText().equals("Debit")) {
                if (getCommonPage().formatDateTime(cols.get(0).getText()).equals(withdrawalTime) && cols.get(1).getText().equals(withdrawalAmount)) {
                    verify = true;
                }
            }
        }

        if (check.equals(Constant.SUCCESS)) {
            assertEquals(verify, true);
        } else {
            assertEquals(verify, false);
        }

    }

    public void verifyTransactionSort(List<String> transactionTimeList, String check, int countSort) {
        int count = 0;
        boolean verify = false;

        if (countSort % 2 != 0) {
            Collections.sort(transactionTimeList, Collections.reverseOrder());
        } else {
            Collections.sort(transactionTimeList);
        }

        List<String> sortTransactionList = getCustomerTransactionTimeList();

        for (int i = 0; i < transactionTimeList.size(); i++) {
            try {
                if (transactionTimeList.get(i).equals(sortTransactionList.get(i))) {
                    count++;
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        if (count == sortTransactionList.size()) {
            verify = true;
        }


        if (check.equals(Constant.SUCCESS)) {
            assertEquals(verify, true);
        } else {
            assertEquals(false, false);
        }

    }

    public List<String> getCustomerTransactionTimeList() {
        List<WebElement> rows = transactionTable.findElements(By.tagName("tr"));
        List<String> transactionTimeList = new ArrayList<String>();
        for (int i = 1; i < rows.size(); i++) {
            try {
                List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
                transactionTimeList.add(getCommonPage().formatDateTime(cols.get(0).getText()));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        return transactionTimeList;
    }

    public void verifyResetTransaction(String check) {
        List<WebElement> rows = transactionTable.findElements(By.xpath("tbody/tr"));
        if (check.equals(Constant.SUCCESS)) {
            assertEquals(rows.size(), 0);
        } else {
            assertEquals(1, 1);
        }
    }

}
