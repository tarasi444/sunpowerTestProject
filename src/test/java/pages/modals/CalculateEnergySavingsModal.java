package pages.modals;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utils.enums.HomeAddresses;

import java.util.concurrent.atomic.AtomicInteger;

import static com.codeborne.selenide.Selenide.*;

public class CalculateEnergySavingsModal {
    private SelenideElement calculateEnergySavingsFrame = $x("//iframe[contains(@name,'savings_calculator')" +
            " and contains(@class, 'xcomponent-component-frame xcomponent-visible')]");
    private ElementsCollection addressSearchFieldDropdownItems = $$x("//div[@class = 'pac-item']");
    private SelenideElement nextButton = $x("//*[contains(@style,'visibility: visible')]//button[contains" +
            "(text(), 'Next')]");
    private SelenideElement firstNameField = $x("//input[@name = 'first-name']");
    private SelenideElement lastNameField = $x("//input[@name = 'last-name']");
    private SelenideElement emailField = $x("//input[@name = 'email']");
    private SelenideElement telephoneField = $x("//input[@name = 'telephone']");
    private SelenideElement getQuoteButton = $x("//button[contains(text(), 'Get a quote')]");
    private SelenideElement addressSearchField = $x("//input[contains(@class, 'address-input')]");

    @Step("Switched frame to the 'Calculate Energy Savings' frame")
    public CalculateEnergySavingsModal switchToCalculateEnergySavingsFrame() {
        switchTo().frame(calculateEnergySavingsFrame.shouldBe(Condition.visible));
        return this;
    }

    @Step("Entered an address into the 'search' field")
    public CalculateEnergySavingsModal enterAddressIntoSearchField(HomeAddresses homeAddresses) {
        switchToCalculateEnergySavingsFrame();
        addressSearchField.sendKeys(homeAddresses.toString());
        return this;
    }

    @Step("Selected place from the 'Search Address' dropdown")
    public CalculateEnergySavingsModal selectPlaceFromTheSearchAddressDropdown(HomeAddresses homeAddresses) {
        AtomicInteger clickArrowDownTimes = new AtomicInteger(0);
        Actions actions = actions();

        addressSearchFieldDropdownItems
                .shouldBe(CollectionCondition.sizeGreaterThan(0))
                .stream()
                .peek(e -> clickArrowDownTimes.incrementAndGet())
                .filter(e -> e.getText().contains(homeAddresses.toString()))
                .findFirst()
                .get();

        for (int clickArrowDown = 0; clickArrowDown < clickArrowDownTimes.intValue(); clickArrowDown++) {
            actions.sendKeys(Keys.ARROW_DOWN);
        }
        actions.sendKeys(Keys.ENTER).build().perform();
        return this;
    }

    @Step("Clicked the 'Next' button")
    public CalculateEnergySavingsModal clickNextButton() {
        nextButton.shouldBe(Condition.enabled).scrollTo().click();
        return this;
    }

    @Step("Entered a name into the 'Fist name' field")
    public CalculateEnergySavingsModal enterNameIntoFirstNameField(String value) {
        firstNameField.sendKeys(value);
        return this;
    }

    @Step("Entered a lat name into the 'Last name' field")
    public CalculateEnergySavingsModal enterLastNameIntoLastNameField(String value) {
        lastNameField.sendKeys(value);
        return this;
    }

    @Step("Entered an email into the 'Email address' field")
    public CalculateEnergySavingsModal enterEmailIntoEmailAddressField(String value) {
        emailField.sendKeys(value);
        return this;
    }

    @Step("Entered a telephone into the 'Telephone' field")
    public CalculateEnergySavingsModal enterTelephoneIntoTelephoneField(String value) {
        telephoneField.sendKeys(value);
        return this;
    }

    @Step("Selected an item in the 'Do you own the home' radio box")
    public CalculateEnergySavingsModal selectYesOrNoInTheDoYouOwnTheHomeRadioBox(boolean yesOrNot) {
        String answer;
        if (yesOrNot) {
            answer = "yes";
        } else {
            answer = "no";
        }
        String locator = String.format("//mat-radio-button[@ng-reflect-value = '%s']//div[@class = 'mat-radio-inner-circle']", answer);
        $(By.xpath(locator)).click();
        return this;
    }

    @Step("Is the 'Get A Quote' button enabled")
    public boolean isTheGetQuoteButtonEnabled() {
        return getQuoteButton.shouldBe(Condition.enabled).isEnabled();
    }

}
