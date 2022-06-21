package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class TermsAndConditionsTests extends TestBase {

    @RepeatedTest(2)
    @DisplayName("TC01")
    @Severity(SeverityLevel.CRITICAL)
    public void testAcceptTermsAndConditions(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.empty,
                TestDataCollection.empty,
                TestDataCollection.username,
                TestDataCollection.password);
        landing.clickOnLogoutButton();
        boolean actual = regLog.isThereTermsAndConditionsWindow();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC02")
    @Severity(SeverityLevel.CRITICAL)
    public void testIgnoreTermsAndConditions() {
        regLog.clickOnTermsAndConditionsIgnore();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.empty,
                TestDataCollection.empty,
                TestDataCollection.username,
                TestDataCollection.password);
        landing.clickOnLogoutButton();
        boolean actual = regLog.isThereTermsAndConditionsWindow();
        Assertions.assertTrue(actual);
    }
}
