package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class RegistrationTests extends TestBase {

    @RepeatedTest(2)
    @DisplayName("TC03")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEverythingIsFilled(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description);
        String actual = regLog.getRegisterAlert();
        String expected = "User registered!";
        Assertions.assertEquals(expected, actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC04")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationDescriptionIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.empty);
        String actual = regLog.getRegisterAlert();
        String expected = "User registered!";
        Assertions.assertEquals(expected, actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC05")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEmailAndDescriptionAreEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.empty,
                TestDataCollection.empty);
        String actual = regLog.getRegisterAlert();
        String expected = "User registered!";
        Assertions.assertEquals(expected, actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC06")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEmailWithoutAt(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailWithoutAt,
                TestDataCollection.description);
        boolean actual = regLog.isThereRegisterAlertMessage();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC07")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEmailWithoutDot(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailWithoutDot,
                TestDataCollection.description);
        boolean actual = regLog.isThereRegisterAlertMessage();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC08")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationPasswordIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.username,
                TestDataCollection.empty,
                TestDataCollection.emailValid,
                TestDataCollection.description);
        boolean actual = regLog.isThereRegisterAlertMessage();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC09")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationUsernameIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.empty,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description);
        boolean actual = regLog.isThereRegisterAlertMessage();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC10")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEverythingIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.empty,
                TestDataCollection.empty,
                TestDataCollection.empty,
                TestDataCollection.empty);
        boolean actual = regLog.isThereRegisterAlertMessage();
        Assertions.assertFalse(actual);
    }

}
