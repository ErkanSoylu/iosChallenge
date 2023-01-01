import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
public class firstLogin {
     private MobileDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("deviceName", "iPhone Simulator");
        desiredCapabilities.setCapability("appPackage", "com.bluepay.roket");
        desiredCapabilities.setCapability("appActivity", "com.bluepay.roket.MainActivity");

        driver = (MobileDriver) new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLogin() {
        class LoginPage {
            private WebDriver driver;
            private String loginButtonId = "com.bluepay.roket:id/user_login_Button";
            private String loginActionButtonId = "com.bluepay.roket:id/login_action_Button";

            public LoginPage(WebDriver driver) {
                this.driver = driver;
            }

            public void clickLoginButton() {
                driver.findElement(By.id(loginButtonId)).click();
            }

            public void clickLoginActionButton() {
                driver.findElement(By.id(loginActionButtonId)).click();
            }
        }

        class HomePage {
            private WebDriver driver;
            private String loginButtonId = "com.bluepay.roket:id/user_login_Button";

            public HomePage(WebDriver driver) {
                this.driver = driver;
            }

            public String getLoginButtonText() {
                WebElement loginButton = driver.findElement(By.id(loginButtonId));
                return loginButton.getText();
            }
        }

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // Check the User Login Button exists
        Assert.assertTrue(driver.getPageSource().contains(loginPage.loginButtonId));

        // Check the text inside the User Login Button
        WebElement loginButton = driver.findElement(By.id(loginPage.loginButtonId));
        Assert.assertEquals(loginButton.getText(), "Giriş Yap");

        // Call the Click Action of The Login Button
        loginPage.clickLoginButton();

        // Check the Following login screen will appear
        Assert.assertTrue(driver.getPageSource().contains(loginPage.loginActionButtonId));

        // Call the Click action of the login action button
        loginPage.clickLoginActionButton();

        // Check if the app returns to home screen and User Login Button text is changed to welcome user message
        Assert.assertEquals(homePage.getLoginButtonText(), "Merhaba,Çağrı");
    }
}
