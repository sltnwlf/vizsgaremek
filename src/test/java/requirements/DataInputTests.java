package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class DataInputTests extends TestBase {

    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @Description("Everything is filled test")
    @DisplayName("TC19")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEverythingIsFilled() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestDataCollection.contactName,
                TestDataCollection.email,
                TestDataCollection.contactMessage);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertTrue(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @Description("Message is empty test")
    @DisplayName("TC20")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputMessageIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestDataCollection.contactName,
                TestDataCollection.email,
                TestDataCollection.empty);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertTrue(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @Description("Checkbox is empty test")
    @DisplayName("TC21")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputCheckboxIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestDataCollection.contactName,
                TestDataCollection.email,
                TestDataCollection.contactMessage);
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @Description("Email is empty test")
    @DisplayName("TC22")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestDataCollection.contactName,
                TestDataCollection.empty,
                TestDataCollection.contactMessage);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @Description("Email without at test")
    @DisplayName("TC23")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailWithoutAt(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestDataCollection.contactName,
                TestDataCollection.emailWithoutAt,
                TestDataCollection.contactMessage);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @Description("Email, nothing after at test")
    @DisplayName("TC24")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailNothingAfterAt() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestDataCollection.contactName,
                TestDataCollection.emailNothingAfterAt,
                TestDataCollection.contactMessage);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @Description("Email, nothing before at test")
    @DisplayName("TC25")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailNothingBeforeAt() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestDataCollection.contactName,
                TestDataCollection.emailNothingBeforeAt,
                TestDataCollection.contactMessage);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @Description("Email without dot test")
    @DisplayName("TC26")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailWithoutDot() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestDataCollection.contactName,
                TestDataCollection.emailWithoutDot,
                TestDataCollection.contactMessage);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @Description("Name is empty test")
    @DisplayName("TC27")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputNameEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestDataCollection.empty,
                TestDataCollection.email,
                TestDataCollection.contactMessage);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }

}

