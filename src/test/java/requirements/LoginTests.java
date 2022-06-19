package requirements;

import base.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class LoginTests extends TestBase {

    @RepeatedTest(3)
    @DisplayName("TC11")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginEverythingIsFilled() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,username,password);
        boolean actual = regLog.isThereLoginWindow();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(3)
    @DisplayName("TC12")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginUsernameIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,empty,password);
        boolean actual = regLog.isThereLoginWindow();
        Assertions.assertTrue(actual);
    }
    @RepeatedTest(3)
    @DisplayName("TC13")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginPasswordIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,username,empty);
        boolean actual = regLog.isThereLoginWindow();
        Assertions.assertTrue(actual);
    }
    @RepeatedTest(3)
    @DisplayName("TC14")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginPasswordIsUnregistered() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,empty,emailValid,description,username,password);
        boolean actual = regLog.isThereLoginWindow();
        Assertions.assertTrue(actual);
    }
    @RepeatedTest(3)
    @DisplayName("TC15")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginUsernameIsUnregistered() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(empty, password,emailValid,description,username,password);
        boolean actual = regLog.isThereLoginWindow();
        Assertions.assertTrue(actual);
    }

}