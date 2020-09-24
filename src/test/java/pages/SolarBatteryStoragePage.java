package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.modals.CalculateEnergySavingsModal;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Models the 'Solar Battery Storage' page'
 */
public class SolarBatteryStoragePage {
    public CalculateEnergySavingsModal CalculateEnergySavingsModal;

    private SelenideElement calculateYourBackupPotentialButton = $x("//a[contains(text(), 'Calculate " +
            "Your Backup Potential') and @class = 'open-savings-calculator-button']");

    public SolarBatteryStoragePage() {
        CalculateEnergySavingsModal = new CalculateEnergySavingsModal();
    }

    @Step("Scrolled and opened the 'Calculate Energy Savings' block")
    public CalculateEnergySavingsModal scrollAndOpenCalculateEnergySavingsBlock() {
        calculateYourBackupPotentialButton.should(Condition.visible).click();
        return new CalculateEnergySavingsModal();
    }
}
