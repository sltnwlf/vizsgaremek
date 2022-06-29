package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class TermsAndConditionsTests extends TestBase {

    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Terms and conditions tests")
    @Description("Accept test")
    @DisplayName("TC01")
    @Severity(SeverityLevel.CRITICAL)
    public void testAcceptTermsAndConditions(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.empty,
                TestDataCollection.empty,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnLogout();
        boolean actual = regLog.isThereTermsAndConditionsPopup();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Terms and conditions tests")
    @Description("Close test")
    @DisplayName("TC02")
    @Severity(SeverityLevel.CRITICAL)
    public void testCloseTermsAndConditions() {
        regLog.clickOnTermsAndConditionsClose();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.empty,
                TestDataCollection.empty,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnLogout();
        boolean actual = regLog.isThereTermsAndConditionsPopup();
        Assertions.assertTrue(actual);
    }

}
