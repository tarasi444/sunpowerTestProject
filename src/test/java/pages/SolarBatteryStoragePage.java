package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.blocks.CalculateEnergySavingsBlock;

import static com.codeborne.selenide.Selenide.$;

public class SolarBatteryStoragePage {
    public CalculateEnergySavingsBlock calculateEnergySavingsBlock;

    private final SelenideElement calculateYourBackupPotentialButton = $(By.xpath("//a[contains(text(), 'Calculate Your Backup " +
            "Potential') and @class = 'open-savings-calculator-button']"));

    public SolarBatteryStoragePage() {
        calculateEnergySavingsBlock = new CalculateEnergySavingsBlock();
    }

    public CalculateEnergySavingsBlock scrollAndOpenCalculateEnergySavingsBlock() {
        calculateYourBackupPotentialButton.should(Condition.visible).click();
        return new CalculateEnergySavingsBlock();
    }
}
