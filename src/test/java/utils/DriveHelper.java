package utils;

import static com.codeborne.selenide.Selenide.open;

/**
 * Driver helper methods
 */
public class DriveHelper {

    public static void openHomePage() {
        open("/");
    }
}
