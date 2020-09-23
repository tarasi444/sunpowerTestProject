package pages.blocks;

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

public class CalculateEnergySavingsBlock {
    private final SelenideElement calculateEnergySavingsFrame = $(By.xpath("//iframe[contains(@name, " +
            "'savings_calculator') and contains(@class, 'xcomponent-component-frame xcomponent-visible')]"));
    private final SelenideElement addressSearchField = $(By.xpath("//input[contains(@class, 'address-input')]"));
    private final ElementsCollection addressSearchFieldDropdownItems = $$(By.xpath("//div[@class = 'pac-item']"));
    private final SelenideElement nextButton = $(By.xpath("//*[contains(@style,'visibility: visible')]//button[contains" +
            "(text(), 'Next')]"));
    private final SelenideElement firstNameField = $(By.xpath("//input[@name = 'first-name']"));
    private final SelenideElement lastNameField = $(By.xpath("//input[@name = 'last-name']"));
    private final SelenideElement emailField = $(By.xpath("//input[@name = 'email']"));
    private final SelenideElement telephoneField = $(By.xpath("//input[@name = 'telephone']"));
    private final SelenideElement getQuoteButton = $(By.xpath("//button[contains(text(), 'Get a quote')]"));

    @Step("Switch frame to the 'Calculate Energy Savings' frame")
    public CalculateEnergySavingsBlock switchToCalculateEnergySavingsFrame() {
        switchTo().frame(calculateEnergySavingsFrame.shouldBe(Condition.visible));
        return this;
    }

    @Step("Enter an address into the 'search' field")
    public CalculateEnergySavingsBlock enterAddressIntoSearchField(HomeAddresses homeAddresses) {
        switchToCalculateEnergySavingsFrame();
        addressSearchField.sendKeys(homeAddresses.toString());
        return this;
    }

    @Step("Select place from the 'Search Address' dropdown")
    public CalculateEnergySavingsBlock selectPlaceFromTheSearchAddressDropdown(HomeAddresses homeAddresses) {
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

    @Step("Click the 'Next' button")
    public CalculateEnergySavingsBlock clickNextButton() {
        nextButton.shouldBe(Condition.enabled).scrollTo().click();
        return this;
    }

    @Step("Enter a name into the 'Fist name' field")
    public CalculateEnergySavingsBlock enterNameIntoFirstNameField(String value) {
        firstNameField.sendKeys(value);
        return this;
    }

    @Step("Enter a lat name into the 'Last name' field")
    public CalculateEnergySavingsBlock enterLastNameIntoLastNameField(String value) {
        lastNameField.sendKeys(value);
        return this;
    }

    @Step("Enter an email into the 'Email address' field")
    public CalculateEnergySavingsBlock enterEmailIntoEmailAddressField(String value) {
        emailField.sendKeys(value);
        return this;
    }

    @Step("Enter a telephone into the 'Telephone' field")
    public CalculateEnergySavingsBlock enterTelephoneIntoTelephoneField(String value) {
        telephoneField.sendKeys(value);
        return this;
    }

    @Step("Select an item in the 'Do you own the home' radio box")
    public CalculateEnergySavingsBlock selectItemInTheDoYouOwnTheHomeRadioBox(boolean yesOrNot) {
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
