package framework.core.driver.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import static framework.core.exceptions.Errors.end;

@SuppressWarnings("unchecked")
public class BasicAndroidDriver extends BasicAppiumDriver {

    public BasicAndroidDriver() {
        super();
    }

    public AppiumDriver driver() {
        return (AppiumDriver) driver;
    }

    public void launch() {
        try {
            driver = new AndroidDriver<>(new URL(serverAddress), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setAppPackage(String appPackage) {
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
    }

    public void setAppActivity(String appActivity) {
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
    }

    public void setUiAutomator2() {
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
    }

}
