package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class DataInputTests extends TestBase {

    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC19, Everything is filled test")
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
    @DisplayName("TC20, Message is empty test")
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
    @DisplayName("TC21, Checkbox is empty test")
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
        utils.scrollDown200pixels();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        utils.makeScreenshot();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC22, Email is empty test")
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
        utils.scrollDown200pixels();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        utils.makeScreenshot();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC23, Email without at test")
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
        utils.scrollDown200pixels();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        utils.makeScreenshot();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC24, Email, nothing after at test")
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
        utils.scrollDown200pixels();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        utils.makeScreenshot();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC25, Email, nothing before at test")
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
        utils.scrollDown200pixels();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        utils.makeScreenshot();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC26, Email without dot test")
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
        utils.scrollDown200pixels();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        utils.makeScreenshot();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC27, Name is empty test")
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
        utils.scrollDown200pixels();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        utils.makeScreenshot();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }

}

