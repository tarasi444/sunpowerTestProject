package tests.common;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;
import pages.SolarBatteryStoragePage;

public abstract class BaseTest {
    public MainPage mainPage;
    public SolarBatteryStoragePage solarBatteryStoragePage;

    @BeforeAll
    private static void setUpDriver() {
        Configuration.baseUrl = "https://us.sunpower.com/";
        Configuration.startMaximized = true;
        Configuration.timeout = 15000;
        Configuration.pageLoadStrategy = "normal";
    }

    @BeforeEach
    private void initPages() {
        mainPage = new MainPage();
        solarBatteryStoragePage = new SolarBatteryStoragePage();
    }
}
