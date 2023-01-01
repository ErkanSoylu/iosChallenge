import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
public class firstLogin {
    public static final String UserName = "blupay_hU5pQe";
    public static final String AutomateKey = "MmyJq8RwiXxyXm8aLJVr";

    public static final String URL = "https://" + UserName + ":" + AutomateKey + "@hub-cloud.browserstack.com/wd/hub";
     public IOSDriver driver;
   public IOSDriver<MobileElement> driverpublic;

    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("deviceName", "iPhone 14 Pro Max");
        desiredCapabilities.setCapability("os_version","16");
        desiredCapabilities.setCapability("appPackage", "com.bluepay.roket");
        desiredCapabilities.setCapability("appActivity", "com.bluepay.roket.MainActivity");
        desiredCapabilities.setCapability("app","bs://c48dba17daa525c27455e32685aa475a4091739e");
        desiredCapabilities.setCapability("autoAcceptAlerts", true);
        IOSDriver driver = new IOSDriver(new URL(URL),desiredCapabilities);


        MobileElement loginButton = (MobileElement) driver.findElement(By.name("com.bluepay.roket:id/user_login_Button"));

        // Check that the login button exists
        Assert.assertTrue(loginButton.isDisplayed());

        // Check the text inside the login button
        Assert.assertEquals(loginButton.getText(), "Giriş Yap");

        // Call the click action of the login button
        loginButton.click();
        Thread.sleep(2000);
        // Find the login action button
        MobileElement loginActionButton = (MobileElement) driver.findElement(By.name("com.bluepay.roket:id/login_action_Button"));

        // Check that the login action button exists
        Assert.assertTrue(loginActionButton.isDisplayed());
        Thread.sleep(2000);
        // Call the click action of the login action button
        loginActionButton.click();
        Thread.sleep(2000);
        // Check that the login button text is changed to the welcome message
        MobileElement welcomeButton = (MobileElement) driver.findElement(By.name("com.bluepay.roket:id/user_login_Button"));

        // Check that the login button exists
        Assert.assertTrue(welcomeButton.isDisplayed());
        Assert.assertEquals(welcomeButton.getText(), "Merhaba, Çağrı");

        driver.quit();

    }

    class LoginScreen {
        public WebElement loginActionButton;

        public boolean isDisplayed() {
            // Check if the login screen is displayed by checking for the presence of the login action button
            return loginActionButton.isDisplayed();
        }
    }
    // Page object for the home screen
    class HomeScreen {
        public WebElement loginButton;

        public boolean isDisplayed() {
            // Check if the home screen is displayed by checking for the presence of the login button
            return loginButton.isDisplayed();
        }
    }
}
