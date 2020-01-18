package pages.bankcustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constant;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static tests.PageProvider.getCommonPage;

public class BankCustomerLoginPage {
    private WebDriver webDriver;

    @FindBy(id = "userSelect")
    WebElement userSelect;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutButton;

    @FindBy(xpath = "//span[@class='fontBig ng-binding']")
    WebElement nameSpan;

    public BankCustomerLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickOption(String name) {
        List<WebElement> rows = userSelect.findElements(By.tagName("option"));

        for (int i = 0; i < rows.size(); i++) {

            if (rows.get(i).getText().equals(name)){
                WebElement option = userSelect.findElement(By.xpath("//option[text()='" + name + "']"));
                option.click();
            }
        }

    }

    public void clickSubmit() {
        try {
            if(getCommonPage().exists(this.loginButton)){
                this.loginButton.click();
            }
        }catch (Exception e){
            e.getStackTrace();
        }

    }

    public void checkCustomerLogin(String username, String check) throws InterruptedException {
        if(check.equals(Constant.SUCCESS)){
            Thread.sleep(5000);
            assertEquals(getCommonPage().exists(this.logoutButton), true);
            Thread.sleep(5000);
            assertEquals(nameSpan.getText(), username);
            Thread.sleep(5000);
        }
        else {
            Thread.sleep(5000);
            assertEquals(getCommonPage().exists(this.loginButton), false);
            Thread.sleep(5000);
        }
    }

    public void loginSuccessfully(String username) throws InterruptedException {
        Thread.sleep(5000);
        clickOption(username);
        Thread.sleep(5000);
        clickSubmit();
        Thread.sleep(5000);
        checkCustomerLogin(username,Constant.SUCCESS);
        Thread.sleep(5000);
    }
}
