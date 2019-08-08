
package Amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base {

    private static WebDriver webdriver;

    final static String CHROME_DRIVER_PATH = "C://Users//singhanj//UI_Automation//chrome_Driver//chromedriver.exe";

    @BeforeSuite
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("safebrowsing", true);

        options.setExperimentalOption("prefs", prefs);

        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        setDriver(new ChromeDriver(options));

        webdriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        webdriver.quit();
    }

    public static WebDriver getWebDriver() {
        return webdriver;
    }

    private void setDriver(WebDriver webdriver) {
        Base.webdriver = webdriver;
    }
}
