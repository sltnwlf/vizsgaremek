package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class RegistrationTests extends TestBase {

    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC03, Everything is filled test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEverythingIsFilled(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription);
        String actual = regLog.getRegisterStatus();
        String expected = "User registered!";
        Assertions.assertEquals(expected, actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC04, Description is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationDescriptionIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.empty);
        String actual = regLog.getRegisterStatus();
        String expected = "User registered!";
        Assertions.assertEquals(expected, actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC05, Email and description are empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEmailAndDescriptionAreEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.empty,
                TestDataCollection.empty);
        String actual = regLog.getRegisterStatus();
        String expected = "User registered!";
        Assertions.assertEquals(expected, actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC06, Email without at test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEmailWithoutAt(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.emailWithoutAt,
                TestDataCollection.regLogDescription);
        utils.makeScreenshot();
        boolean actual = regLog.isThereRegisterStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC07, Email without dot test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEmailWithoutDot(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.emailWithoutDot,
                TestDataCollection.regLogDescription);
        utils.makeScreenshot();
        boolean actual = regLog.isThereRegisterStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC08, Password is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationPasswordIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.regLogUsername,
                TestDataCollection.empty,
                TestDataCollection.email,
                TestDataCollection.regLogDescription);
        utils.makeScreenshot();
        boolean actual = regLog.isThereRegisterStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC09, Username is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationUsernameIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.empty,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription);
        utils.makeScreenshot();
        boolean actual = regLog.isThereRegisterStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC10, Everything is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEverythingIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.empty,
                TestDataCollection.empty,
                TestDataCollection.empty,
                TestDataCollection.empty);
        utils.makeScreenshot();
        boolean actual = regLog.isThereRegisterStatus();
        Assertions.assertFalse(actual);
    }

}
