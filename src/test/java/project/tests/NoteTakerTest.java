package project.tests;

import com.github.marcosbelfastdev.erbium.core.Common;
import framework.core.driver.mobile.BasicAndroidDriver;
import framework.core.driver.mobile.BasicAppiumDriver;
import framework.core.driver.web.ViewPort;
import framework.core.flow.BaseTestAccessors;
import framework.core.utils.WordsGenerator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import project.applications.Apple.AppleApp;
import project.applications.Apple.pages.HomePage;

import java.util.concurrent.TimeUnit;


public class NoteTakerTest extends BaseTestAccessors {

    BasicAndroidDriver noteTaker = new BasicAndroidDriver();
    AppiumDriver driver;

    @BeforeTest
    public void setup(ITestContext context) throws Throwable {

        noteTaker.setAutoAcceptAlerts();
        noteTaker.setAutoGrantPermissions();
        noteTaker.setDeviceId("emulator-5554");
        noteTaker.setNoReset();
        noteTaker.setDeviceName("Emulator");
        noteTaker.setUiAutomator2();
        noteTaker.setAppPackage("com.ztnstudio.notepad");
        noteTaker.setAppActivity("com.ztnstudio.notepad.presentation.noteslist.view.NoteListActivity");
        noteTaker.launch();
        driver = noteTaker.driver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    /*
    Ant elements used in this test were created inside the final page object
    in a horizontal manner, without the need for separate page objects, for simplicity reasons.
     */

    @SuppressWarnings("unchecked")
    @Test(description = "Demo Test - Take notes")
    public void createCheckList() throws Throwable {
        driver.findElement(MobileBy.id("com.ztnstudio.notepad:id/content_accept_btn")).click();

        MobileElement floatingActionMenu = (MobileElement) driver.findElement(MobileBy.id("com.ztnstudio.notepad:id/myNotes_floating_action_menu"));
        MobileElement addButton = floatingActionMenu.findElement(By.xpath("//android.widget.ImageButton"));
        addButton.click();

        driver.findElement(MobileBy.id("com.ztnstudio.notepad:id/myNotes_fab_createCheckList")).click();
        driver.findElement(MobileBy.id("com.ztnstudio.notepad:id/checklistHeaderTitle")).sendKeys(WordsGenerator.getRandomString());

        for (int i = 0; i < 5; i ++) {
            driver.findElement(MobileBy.id("com.ztnstudio.notepad:id/checklistAddEditText")).sendKeys(WordsGenerator.getRandomString(20));
            driver.findElement(MobileBy.id("com.ztnstudio.notepad:id/activity_check_save")).click();
        }

        driver.findElement(MobileBy.id("com.ztnstudio.notepad:id/menu_save")).click();
    }

    @AfterClass
    public void end(ITestContext context) throws Throwable {
        driver.closeApp();
    }

}
