package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class LoginTests extends TestBase {

    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Login tests")
    @DisplayName("TC11, Everything is filled test")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginEverythingIsFilled() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        boolean actual = regLog.isThereRegLogForm();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Login tests")
    @DisplayName("TC12, Username is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginUsernameIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.empty,
                TestDataCollection.regLogPassword);
        boolean actual = regLog.isThereRegLogForm();
        Assertions.assertTrue(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Login tests")
    @DisplayName("TC13, Password is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginPasswordIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.empty);
        boolean actual = regLog.isThereRegLogForm();
        Assertions.assertTrue(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Login tests")
    @DisplayName("TC14, Password is unregistered test")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginPasswordIsUnregistered() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.empty,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        boolean actual = regLog.isThereRegLogForm();
        Assertions.assertTrue(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Login tests")
    @DisplayName("TC15, Username is unregistered test")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginUsernameIsUnregistered() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.empty,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        boolean actual = regLog.isThereRegLogForm();
        Assertions.assertTrue(actual);
    }

}