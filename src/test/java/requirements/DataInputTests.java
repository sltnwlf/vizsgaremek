package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class DataInputTests extends TestBase {

    @RepeatedTest(2)
    @DisplayName("TC19")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEverythingIsFilled() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(
                TestDataCollection.name,
                TestDataCollection.emailValid,
                TestDataCollection.message);
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
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(
                TestDataCollection.name,
                TestDataCollection.emailValid,
                TestDataCollection.empty);
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
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(
                TestDataCollection.name,
                TestDataCollection.emailValid,
                TestDataCollection.message);
        contact.clickOnSendButton();
        boolean actual = contact.isThereStatusMessage();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC22")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(
                TestDataCollection.name,
                TestDataCollection.empty,
                TestDataCollection.message);
        contact.clickOnCheckbox();
        contact.clickOnSendButton();
        boolean actual = contact.isThereStatusMessage();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC23")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailWithoutAt(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(
                TestDataCollection.name,
                TestDataCollection.emailWithoutAt,
                TestDataCollection.message);
        contact.clickOnCheckbox();
        contact.clickOnSendButton();
        boolean actual = contact.isThereStatusMessage();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC24")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailNothingAfterAt() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(
                TestDataCollection.name,
                TestDataCollection.emailNothingAfterAt,
                TestDataCollection.message);
        contact.clickOnCheckbox();
        contact.clickOnSendButton();
        boolean actual = contact.isThereStatusMessage();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC25")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailNothingBeforeAt() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(
                TestDataCollection.name,
                TestDataCollection.emailNothingBeforeAt,
                TestDataCollection.message);
        contact.clickOnCheckbox();
        contact.clickOnSendButton();
        boolean actual = contact.isThereStatusMessage();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC26")
    @Description("Description") // manuális tesztbe is beírni mint név?? Tomi mondta
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailWithoutDot() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(
                TestDataCollection.name,
                TestDataCollection.emailWithoutDot,
                TestDataCollection.message);
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
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        landing.clickOnGetInTouchButton();
        contact.fillForm(
                TestDataCollection.empty,
                TestDataCollection.emailValid,
                TestDataCollection.message);
        contact.clickOnCheckbox();
        contact.clickOnSendButton();
        boolean actual = contact.isThereStatusMessage();
        Assertions.assertFalse(actual);
    }

}

