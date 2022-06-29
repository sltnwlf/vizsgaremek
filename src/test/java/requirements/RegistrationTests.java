package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class RegistrationTests extends TestBase {

    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Registration tests")
    @Description("Everything is filled test")
    @DisplayName("TC03")
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
    @Description("Description is empty test")
    @DisplayName("TC04")
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
    @Description("Email and description are empty test")
    @DisplayName("TC05")
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
    @Description("Email without at test")
    @DisplayName("TC06")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEmailWithoutAt(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.emailWithoutAt,
                TestDataCollection.regLogDescription);
        boolean actual = regLog.isThereRegisterStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Registration tests")
    @Description("Email without dot test")
    @DisplayName("TC07")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEmailWithoutDot(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.emailWithoutDot,
                TestDataCollection.regLogDescription);
        boolean actual = regLog.isThereRegisterStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Registration tests")
    @Description("Password is empty test")
    @DisplayName("TC08")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationPasswordIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.regLogUsername,
                TestDataCollection.empty,
                TestDataCollection.email,
                TestDataCollection.regLogDescription);
        boolean actual = regLog.isThereRegisterStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Registration tests")
    @Description("Username is empty test")
    @DisplayName("TC09")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationUsernameIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.empty,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription);
        boolean actual = regLog.isThereRegisterStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Registration tests")
    @Description("Everything is empty test")
    @DisplayName("TC10")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEverythingIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestDataCollection.empty,
                TestDataCollection.empty,
                TestDataCollection.empty,
                TestDataCollection.empty);
        boolean actual = regLog.isThereRegisterStatus();
        Assertions.assertFalse(actual);
    }

}
