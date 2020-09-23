package pages.blocks;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.atomic.AtomicInteger;

import static com.codeborne.selenide.Selenide.*;

public class CalculateEnergySavingsBlock {
    private final SelenideElement calculateEnergySavingsFrame = $(By.xpath("//iframe[contains(@name, 'savings_calculator') " +
            "and contains(@class, 'xcomponent-component-frame xcomponent-visible')]"));
    private final SelenideElement addressSearchField = $(By.xpath("//input[contains(@class, 'address-input')]"));
    private final ElementsCollection addressSearchFieldDropdownItems = $$(By.xpath("//div[@class = 'pac-item']"));

    @Step("Switch frame to the 'Calculate Energy Savings' frame")
    public CalculateEnergySavingsBlock switchToCalculateEnergySavingsFrame() {
        switchTo().frame(calculateEnergySavingsFrame.shouldBe(Condition.visible));
        return this;
    }

    @Step("Enter an address into the 'search' field")
    public CalculateEnergySavingsBlock enterAddressIntoSearchField(String value) {
        switchToCalculateEnergySavingsFrame();
        addressSearchField.sendKeys(value);
        return this;
    }

    @Step("Select place from the 'Search Address' dropdown")
    public void selectPlaceFromTheSearchAddressDropdown(String addressName) {
        AtomicInteger clickArrowDownTimes = new AtomicInteger(0);
        Actions actions = actions();

        addressSearchFieldDropdownItems
                .shouldBe(CollectionCondition.sizeGreaterThan(0))
                .stream()
                .peek(e -> clickArrowDownTimes.incrementAndGet())
                .filter(e -> e.getText().contains(addressName))
                .findFirst()
                .get();

        for (int clickArrowDown = 0; clickArrowDown < clickArrowDownTimes.intValue(); clickArrowDown++) {
            actions.sendKeys(Keys.ARROW_DOWN);
        }
        actions.sendKeys(Keys.ENTER).build().perform();
    }
}
