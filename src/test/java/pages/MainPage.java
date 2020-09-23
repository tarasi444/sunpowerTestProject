package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement exploreSunpowerStorageButton = $(By.xpath("//a[contains(@href, 'solar-battery-storage')]"));

    public SolarBatteryStoragePage scrollAndOpenSolarBatteryStorage() {
        exploreSunpowerStorageButton.scrollTo().click();
        return new SolarBatteryStoragePage();
    }
}
