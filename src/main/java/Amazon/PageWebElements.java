
package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageWebElements extends Base {

    public static WebElement searchBox() {
        return getWebDriver().findElement(By.xpath("//div[@id='navbar']//input[@id='twotabsearchtextbox']"));
    }

    public static WebElement searchIcon() {
        return getWebDriver().findElement(By.xpath("//div[contains(@class,'nav-search-submit')]//input"));
    }

    public static WebElement searchProductImage() {
        return getWebDriver().findElement(By.xpath("//div[contains(@class,'desktopSparkle__asin')]//img"));
    }

    public static WebElement selectSizeDropdown() {
        return getWebDriver().findElement(By.name("dropdown_selected_size_name"));
    }

    public static WebElement addToCart() {
        return getWebDriver().findElement(By.id("add-to-cart-button"));
    }

    public static WebElement navigateToCart() {
        return getWebDriver().findElement(By.id("nav-cart"));
    }

    public static WebElement activeCart() {
        return getWebDriver().findElement(By.id("sc-active-cart"));
    }

}
