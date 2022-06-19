package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class LogoutTests extends TestBase {

    @RepeatedTest(2)
    @DisplayName("TC16")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogoutWithLogoutButton(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        landing.clickOnLogoutButton();
        boolean actual = regLog.isThereLoginWindow();
        Assertions.assertTrue(actual);
    }

}
