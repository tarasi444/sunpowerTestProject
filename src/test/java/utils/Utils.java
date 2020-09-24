package utils;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Utils for tests
 */
public class Utils {

    @Step("Generate random string")
    public static String generateRandomString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    @Step("Generate random numeric")
    public static String generateRandomNumeric(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    @Step("Generate random email")
    public static String generateRandomEmail(int length) {
        return RandomStringUtils.randomAlphanumeric(length) + "@gmail.com";
    }
}
