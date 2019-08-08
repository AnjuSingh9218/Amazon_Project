
package Amazon;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderingTest extends Base {

    private static String SCREENSHOT_FOLDER_PATH = "C://Users//singhanj//Trainings//AmazonWorkspace//Amazon//test-output//Screeshots//";

    private static String SHOE_NAME = "Lancer Men Formal Shoes";

    @BeforeClass
    public void beforeClass() {
        getWebDriver().navigate().to("https://www.amazon.in");
    }

    /**
     * @throws InterruptedException
     * @throws IOException
     */
    @Test
    public void orderShoesTest() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(getWebDriver(), 20);

        PageWebElements.searchBox().sendKeys(SHOE_NAME);

        PageWebElements.searchIcon().submit();

        PageWebElements.searchProductImage().click();

        wait.until(ExpectedConditions.visibilityOf(PageWebElements.searchProductImage()));

        Reporter.log("Selected Product/n");
        takeSnapshotAttachToReport("SelectedProduct_Shoe");

        Select selectSize = new Select(PageWebElements.selectSizeDropdown());
        selectSize.selectByValue("1,B07M8SMZ6Q");

        wait.until(ExpectedConditions.stalenessOf(PageWebElements.addToCart()));
        PageWebElements.addToCart().click();

        PageWebElements.navigateToCart().click();
        wait.until(ExpectedConditions.visibilityOf(PageWebElements.activeCart()));

        Reporter.log("Cart Has Selected Product");
        takeSnapshotAttachToReport("ViewCart");

    }

    private void takeSnapshotAttachToReport(String screenshotName) throws IOException {

        File scrFile = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        File screenShotName = new File(SCREENSHOT_FOLDER_PATH + screenshotName + "_" + timeStamp + ".png");
        FileUtils.copyFile(scrFile, screenShotName);
        Reporter.log("<br> <img src='" + screenShotName + "' height='400' /></br>");
    }
}
