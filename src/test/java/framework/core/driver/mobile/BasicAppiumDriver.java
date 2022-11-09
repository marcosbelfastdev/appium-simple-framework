package framework.core.driver.mobile;

import framework.core.driver.web.BasicWebDriver;
import framework.core.driver.web.IChromeBuilder;
import framework.core.exceptions.BrowserOptionsAbsent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;

import static framework.core.exceptions.Errors.end;
import static java.util.Objects.isNull;

public class BasicAppiumDriver {

    protected WebDriver driver;
    protected MutableCapabilities caps;
    protected String serverAddress;

    public BasicAppiumDriver() {
        super();
        setCaps();
    }

    private void setCaps() {
        caps = new DesiredCapabilities();
        serverAddress = isNull(serverAddress) ? "http://127.0.0.1:4723/wd/hub" : serverAddress;
    }

    public void setServerAddress(String address) {
        serverAddress = address;
    }

    public void setCapability(String capability, String value) {
        caps.setCapability(capability, value);
    }

    public void setDeviceId(String udid) {
        caps.setCapability(MobileCapabilityType.UDID, udid);
    }

    public void setPlatformName(String platformName) {
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
    }

    public void setDeviceName(String deviceName) {
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
    }

    public void setNoReset() {
        caps.setCapability(MobileCapabilityType.NO_RESET, "false");
    }

    public void setAutoGrantPermissions() {
        caps.setCapability("autoGrantPermissions", "true");
    }

    public void setAutoAcceptAlerts() {
        caps.setCapability("autoAcceptAlerts", "true");
    }

}
