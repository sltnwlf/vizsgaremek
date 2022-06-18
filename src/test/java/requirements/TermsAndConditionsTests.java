package requirements;

import base.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class TermsAndConditionsTests extends TestBase {

    @RepeatedTest(2)
    @DisplayName("TC01")
    @Severity(SeverityLevel.NORMAL)
    public void testAcceptTermsAndConditions(){
        regLog.clickOnTermsAndConditionsAccept();
        landing = regLog.registrationAndLogin(username,password,empty,empty,username,password);
        landing.clickOnLogoutButton();
        boolean actual = regLog.isThereTermsAndConditionsWindow();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC02")
    @Severity(SeverityLevel.NORMAL)
    public void testIgnoreTermsAndConditions() {
        regLog.clickOnTermsAndConditionsIgnore();
        regLog.registrationAndLogin(username,password,empty,empty,username,password);
        landing.clickOnLogoutButton();
        boolean actual = regLog.isThereTermsAndConditionsWindow();
        Assertions.assertTrue(actual);
    }

}
