package tests;

import org.openqa.selenium.support.PageFactory;
import pages.CommonPage;
import pages.bankcustomer.BankCustomerLoginPage;
import pages.bankcustomer.CustomerDepositPage;
import pages.bankcustomer.CustomerWithdrawalPage;
import pages.bankcustomer.TransactionPage;
import pages.bankmanager.*;
import runner.TestRunner;

public class PageProvider {
    private static CommonPage commonPage;
    private static AddCustomerPage addCustomerPage;
    private static OpenAccountPage openAccountPage;
    private static CustomerPage customerPage;
    private static BankManagerLoginPage bankManagerLoginPage;

    private static BankCustomerLoginPage bankCustomerLoginPage ;
    private static CustomerDepositPage customerDepositPage ;
    private static CustomerWithdrawalPage customerWithdrawalPage;
    private static TransactionPage transactionsPage;


    public static BankManagerLoginPage getBankManagerLoginPage() {
        bankManagerLoginPage = PageFactory.initElements(TestRunner.driver, BankManagerLoginPage.class);
        return bankManagerLoginPage;
    }

    public static AddCustomerPage getAddCustomerPage() {
        addCustomerPage = PageFactory.initElements(TestRunner.driver, AddCustomerPage.class);
        return addCustomerPage;
    }

    public static CommonPage getCommonPage() {
        commonPage = PageFactory.initElements(TestRunner.driver, CommonPage.class);
        return commonPage;
    }

    public static OpenAccountPage getOpenAccountPage() {
        openAccountPage = PageFactory.initElements(TestRunner.driver, OpenAccountPage.class);
        return openAccountPage;
    }

    public static CustomerPage getCustomerPage() {
        customerPage = PageFactory.initElements(TestRunner.driver, CustomerPage.class);
        return customerPage;
    }
    //bank customer
    public static BankCustomerLoginPage getBankCustomerLoginPage() {
        bankCustomerLoginPage = PageFactory.initElements(TestRunner.driver, BankCustomerLoginPage.class);
        return bankCustomerLoginPage;
    }

    public static CustomerDepositPage getCustomerDepositPage(){
        customerDepositPage=PageFactory.initElements(TestRunner.driver, CustomerDepositPage.class);
        return customerDepositPage;
    }

    public static CustomerWithdrawalPage getCustomerWithdrawalPage(){
        customerWithdrawalPage=PageFactory.initElements(TestRunner.driver, CustomerWithdrawalPage.class);
        return customerWithdrawalPage;
    }

    public static TransactionPage getTransactionsPage(){
        transactionsPage=PageFactory.initElements(TestRunner.driver, TransactionPage.class);
        return transactionsPage;
    }

}
