package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public AppiumDriver appiumDriver;

    @BeforeMethod
    void setUp() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:appPackage", "su.atb.mobileapp");
        desiredCapabilities.setCapability("appium:appActivity", ".MainActivity");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:noReset", true);
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:shouldTerminateApp", true);

        appiumDriver = new AppiumDriver( new URL("http://127.0.0.1:4723/"), desiredCapabilities);
        WebDriverRunner.setWebDriver(appiumDriver);

        Configuration.timeout = 5000;

    }

    @AfterMethod
    void tearDown() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }

}
