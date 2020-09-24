package tests.common;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;
import pages.SolarBatteryStoragePage;

/**
 * Configure environment for the tests
 */
public abstract class BaseTest {
    private static final int DEFAULT_TIMEOUT = 15000;
    private static final String BASE_URL = "https://us.sunpower.com";
    public MainPage mainPage;
    public SolarBatteryStoragePage solarBatteryStoragePage;

    @BeforeAll
    private static void setUpDriver() {
        Configuration.baseUrl = BASE_URL;
        Configuration.startMaximized = true;
        Configuration.timeout = DEFAULT_TIMEOUT;
        Configuration.pageLoadStrategy = "normal";
        Configuration.clickViaJs = true;
    }

    @BeforeEach
    private void initPages() {
        mainPage = new MainPage();
        solarBatteryStoragePage = new SolarBatteryStoragePage();
    }
}
