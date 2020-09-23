package tests.solar_battery_storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.common.BaseTest;
import utils.DriveHelper;
import utils.Utils;

import static utils.enums.HomeAddresses.RIO_ROBLES_SAN_JOSE_CA_USA;

public class CalculateYourBackupPotentialTest extends BaseTest {

    @DisplayName("Make sure that can get a quote")
    @Test
    public void makeSureThaCanGetQuote() {
        DriveHelper.openHomePage();
        mainPage.scrollAndOpenSolarBatteryStorage()
                .scrollAndOpenCalculateEnergySavingsBlock()
                .enterAddressIntoSearchField(RIO_ROBLES_SAN_JOSE_CA_USA)
                .selectPlaceFromTheSearchAddressDropdown(RIO_ROBLES_SAN_JOSE_CA_USA)
                .clickNextButton()
                .clickNextButton()
                .clickNextButton()
                .enterNameIntoFirstNameField(Utils.generateRandomString(5))
                .enterLastNameIntoLastNameField(Utils.generateRandomString(5))
                .enterEmailIntoEmailAddressField(Utils.generateRandomEmail(5))
                .enterTelephoneIntoTelephoneField(Utils.generateRandomNumeric(10))
                .selectYesOrNoInTheDoYouOwnTheHomeRadioBox(false);

        Assertions.assertTrue(solarBatteryStoragePage.calculateEnergySavingsBlock.isTheGetQuoteButtonEnabled()
                , "The 'Get A QUOTE' button is not enabled |");
    }
}
