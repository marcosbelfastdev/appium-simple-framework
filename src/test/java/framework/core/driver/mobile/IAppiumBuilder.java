package framework.core.driver.mobile;

import org.openqa.selenium.PageLoadStrategy;

import java.io.File;

public interface IAppiumBuilder {

    String DISABLE_NOTIFICATIONS = "disable-notifications";
    String START_INCOGNITO = "--incognito";
    String IGNORE_CERTIFICATE_ERRORS = "--ignore-certificate-errors";

    String SAFE_BROWSING_ENABLED = "safebrowsing.enabled";
    String PROFILE_DEFAULT_SETTINGS_POPUP = "profile.default_content_settings.popups";
    String PROMPT_FOR_DOWNLOAD = "download.prompt_for_download";
    String DOWNLOAD_DIRECTORY = "download.default_directory";

    IAppiumBuilder addCustomOptionArgument(Object argument);
    IAppiumBuilder addCustomPreference(Object pref, Object value);
    IAppiumBuilder disableNotifications();
    IAppiumBuilder startIncognito();
    IAppiumBuilder ignoreCertificateErrors();
    IAppiumBuilder enableAutomation();
    IAppiumBuilder enableSafeBrowsing();
    IAppiumBuilder setDownloadDirectory(File directory);
    IAppiumBuilder allowPopups();
    IAppiumBuilder suppressDownloadPrompt();
    IAppiumBuilder setPageLoadStrategy(PageLoadStrategy strategy);
    void build();
}
