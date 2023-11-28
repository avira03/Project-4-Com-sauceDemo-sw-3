package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String BaseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid() {
        //
        String expectedText="Products";
        // enter user name
        sendTextToElement(By.id("user-name"), "standard_user");
        // enter password
        sendTextToElement(By.id("password"), "secret_sauce");
        //click on login button
        clickOnElement(By.id("login-button"));
        // get products
        String actualText=getTextFromElement(By.xpath("//span[text()='Products']"));
        // compare results
        Assert.assertEquals("error",expectedText,actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        int expectedProds=6;
        // enter user name
        sendTextToElement(By.id("user-name"), "standard_user");
        // enter password
        sendTextToElement(By.id("password"), "secret_sauce");
        //click on login button
        clickOnElement(By.id("login-button"));
        // get list of products
        List<WebElement> prods = driver.findElements(By.className("inventory_item"));
        int actualProds = prods.size();

        // compare results
        Assert.assertEquals("error",expectedProds,actualProds);

    }
}
