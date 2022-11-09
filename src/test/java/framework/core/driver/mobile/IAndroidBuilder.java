package framework.core.driver.mobile;

import org.openqa.selenium.PageLoadStrategy;

import java.io.File;

public interface IAndroidBuilder {

    String DISABLE_NOTIFICATIONS = "disable-notifications";
    String START_INCOGNITO = "--incognito";
    String IGNORE_CERTIFICATE_ERRORS = "--ignore-certificate-errors";

    String SAFE_BROWSING_ENABLED = "safebrowsing.enabled";
    String PROFILE_DEFAULT_SETTINGS_POPUP = "profile.default_content_settings.popups";
    String PROMPT_FOR_DOWNLOAD = "download.prompt_for_download";
    String DOWNLOAD_DIRECTORY = "download.default_directory";

    IAndroidBuilder addCustomOptionArgument(Object argument);
    IAndroidBuilder addCustomPreference(Object pref, Object value);
    IAndroidBuilder disableNotifications();
    IAndroidBuilder startIncognito();
    IAndroidBuilder ignoreCertificateErrors();
    IAndroidBuilder enableAutomation();
    IAndroidBuilder enableSafeBrowsing();
    IAndroidBuilder setDownloadDirectory(File directory);
    IAndroidBuilder allowPopups();
    IAndroidBuilder suppressDownloadPrompt();
    IAndroidBuilder setPageLoadStrategy(PageLoadStrategy strategy);
    void build();
}
