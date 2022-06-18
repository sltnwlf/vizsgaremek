package requirements;

import base.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class RegistrationTests extends TestBase {

    @RepeatedTest(2)
    @DisplayName("TC03")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEverythingIsFilled(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(username,password,emailValid,description);
        String actual = regLog.getRegisterAlertMessage();
        String expected = "User registered!";
        Assertions.assertEquals(expected, actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC04")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationDescriptionIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(username,password,emailValid,empty);
        String actual = regLog.getRegisterAlertMessage();
        String expected = "User registered!";
        Assertions.assertEquals(expected, actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC05")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEmailAndDescriptionAreEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(username,password,empty,empty);
        String actual = regLog.getRegisterAlertMessage();
        String expected = "User registered!";
        Assertions.assertEquals(expected, actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC06")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEmailWithoutAtSign(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(username,password,emailWithoutAtSign,description);
        boolean actual = regLog.isThereRegisterAlertMessage();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC07")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEmailWithoutDot(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(username,password,emailWithoutDot,description);
        boolean actual = regLog.isThereRegisterAlertMessage();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC08")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationPasswordIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(username,empty,emailValid,description);
        boolean actual = regLog.isThereRegisterAlertMessage();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC09")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationUsernameIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(empty,password,emailValid,description);
        boolean actual = regLog.isThereRegisterAlertMessage();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC10")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEverythingIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(empty,empty,empty,empty);
        boolean actual = regLog.isThereRegisterAlertMessage();
        Assertions.assertFalse(actual);
    }

}
