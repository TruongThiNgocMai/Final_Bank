package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"tests"},
        tags = {"~@Ignore"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }, plugin = "json:target/cucumber-reports/CucumberTestReport.json")

public class TestRunner {

    private TestNGCucumberRunner testNGCucumberRunner;
    //Declare a Webdriver variable
    public static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "version", "platform"})
    public void setUpClass(String browser, String version, String platform) throws Exception {
        if (platform.equals("windown")) {
            if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//driver//geckodriver.exe");
                driver = new FirefoxDriver();

            } else if (browser.equals("chromedriver")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//driver//chromedriver.exe");
                driver = new ChromeDriver();
            }
        }
        if (platform.equals("mac")) {
            if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//driver//geckodriver");
                driver = new FirefoxDriver();

            } else if (browser.equals("chromedriver")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//driver//chromedriver");
                driver = new ChromeDriver();
            }
        }
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
        Thread.sleep(5000);
        driver.quit();
        Thread.sleep(5000);
    }
}