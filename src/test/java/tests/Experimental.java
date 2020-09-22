package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import tests.common.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class Experimental extends BaseTest {

    @Test
    public void test() {
        Configuration.holdBrowserOpen = true;
        open("/");
        mainPage.scrollAndOpenSolarBatteryStorage()
        .scrollAndOpenCalculateEnergySavingsBlock()
        .enterAddressIntoSearchField("test");
        sleep(20000);
    }
}
