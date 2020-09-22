package pages.blocks;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CalculateEnergySavingsBlock {
    private SelenideElement calculateEnergySavingsFrame = $(By.xpath("//iframe[contains(@name, 'savings_calculator')]"));
    private SelenideElement addressSearchField = $(By.xpath("//input[contains(@class, 'address-input')]"));

    public CalculateEnergySavingsBlock switchToCalculateEnergySavingsFrame() {
        switchTo().frame(calculateEnergySavingsFrame);
        return this;
    }

    public CalculateEnergySavingsBlock enterAddressIntoSearchField(String value) {
        switchToCalculateEnergySavingsFrame();
        addressSearchField.sendKeys(value);
        return this;
    }

}
