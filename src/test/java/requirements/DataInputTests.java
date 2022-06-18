package requirements;

import base.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class DataInputTests extends TestBase {

    @RepeatedTest(2)
    @DisplayName("TC19")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEverythingIsFilled() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,username,password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(name,emailValid,message);
        contact.clickOnCheckbox();
        contact.clickOnSendButton();
        boolean actual = contact.isThereStatusMessage();
        Assertions.assertTrue(actual);
    }

    @RepeatedTest(2)
    @DisplayName("TC20")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputMessageEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,username,password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(name,emailValid,empty);
        contact.clickOnCheckbox();
        contact.clickOnSendButton();
        boolean actual = contact.isThereStatusMessage();
        Assertions.assertTrue(actual);
    }

    @RepeatedTest(2)
    @DisplayName("TC21")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputCheckboxEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,username,password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(name,emailValid,message);
        contact.clickOnSendButton();
        boolean actual = contact.isThereStatusMessage();
        Assertions.assertFalse(actual);
    }

    @RepeatedTest(2)
    @DisplayName("TC22")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,username,password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(name,empty,message);
        contact.clickOnCheckbox();
        contact.clickOnSendButton();
        boolean actual = contact.isThereStatusMessage();
        Assertions.assertFalse(actual);
    }

    @RepeatedTest(2)
    @DisplayName("TC23")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailWithoutAtSign(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,username,password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(name,emailWithoutAtSign,message);
        contact.clickOnCheckbox();
        contact.clickOnSendButton();
        boolean actual = contact.isThereStatusMessage();
        Assertions.assertFalse(actual);
    }

    @RepeatedTest(2)
    @DisplayName("TC24")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailNothingAfterAtSign() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,username,password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(name,emailNothingAfterAtSign,message);
        contact.clickOnCheckbox();
        contact.clickOnSendButton();
        boolean actual = contact.isThereStatusMessage();
        Assertions.assertFalse(actual);
    }

    @RepeatedTest(2)
    @DisplayName("TC25")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailNothingBeforeAtSign() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,username,password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(name,emailNothingBeforeAtSign,message);
        contact.clickOnCheckbox();
        contact.clickOnSendButton();
        boolean actual = contact.isThereStatusMessage();
        Assertions.assertFalse(actual);
    }

    @RepeatedTest(2)
    @DisplayName("TC26")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailWithoutDot() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,username,password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(name,emailWithoutDot,message);
        contact.clickOnCheckbox();
        contact.clickOnSendButton();
        boolean actual = contact.isThereStatusMessage();
        Assertions.assertFalse(actual);
    }

    @RepeatedTest(2)
    @DisplayName("TC27")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputNameEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,username,password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(empty,emailValid,message);
        contact.clickOnCheckbox();
        contact.clickOnSendButton();
        boolean actual = contact.isThereStatusMessage();
        Assertions.assertFalse(actual);
    }

}

