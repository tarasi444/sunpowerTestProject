package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Models the 'Sunpower main' page
 */
public class MainPage {
    private SelenideElement exploreSunpowerStorageButton = $x("//a[contains(@href, 'solar-battery-storage')]");

    @Step("Scrolled and opened the 'Solar Battery Storage'")
    public SolarBatteryStoragePage scrollAndOpenSolarBatteryStorage() {
        exploreSunpowerStorageButton.scrollTo().click();
        return new SolarBatteryStoragePage();
    }
}
