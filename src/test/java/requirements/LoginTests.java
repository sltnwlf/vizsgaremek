package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class LoginTests extends TestBase {

    @RepeatedTest(2)
    @DisplayName("TC11")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginEverythingIsFilled() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        boolean actual = regLog.isThereLoginWindow();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC12")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginUsernameIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.empty,
                TestDataCollection.password);
        boolean actual = regLog.isThereLoginWindow();
        Assertions.assertTrue(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC13")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginPasswordIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.empty);
        boolean actual = regLog.isThereLoginWindow();
        Assertions.assertTrue(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC14")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginPasswordIsUnregistered() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.empty,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        boolean actual = regLog.isThereLoginWindow();
        Assertions.assertTrue(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC15")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginUsernameIsUnregistered() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.empty,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        boolean actual = regLog.isThereLoginWindow();
        Assertions.assertTrue(actual);
    }

}