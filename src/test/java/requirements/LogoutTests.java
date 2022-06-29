package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class LogoutTests extends TestBase {

    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Logout tests")
    @Description("Logout twice on different tabs with logout button test")
    @DisplayName("TC16")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogoutTwiceOnDifferentTabsWithLogoutButton() throws InterruptedException {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnLogout();
        boolean actualFirstTab = regLog.isThereRegLogForm();
        utils.createNewTab();
        utils.navigateToPortio();
        regLog.login(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        utils.sleep(2000);
        landing.clickOnLogout();
        boolean actualSecondTab = regLog.isThereRegLogForm();
        Assertions.assertTrue(actualFirstTab);
        Assertions.assertTrue(actualSecondTab);
    }

}
