package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class LoginTests extends TestBase {

    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Login tests")
    @Description("Everything is filled test")
    @DisplayName("TC11")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginEverythingIsFilled() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        boolean actual = regLog.isThereRegLogForm();
        Assertions.assertFalse(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Login tests")
    @Description("Username is empty test")
    @DisplayName("TC12")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginUsernameIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.empty,
                TestDataCollection.regLogPassword);
        boolean actual = regLog.isThereRegLogForm();
        Assertions.assertTrue(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Login tests")
    @Description("Password is empty test")
    @DisplayName("TC13")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginPasswordIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.empty);
        boolean actual = regLog.isThereRegLogForm();
        Assertions.assertTrue(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Login tests")
    @Description("Password is unregistered test")
    @DisplayName("TC14")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginPasswordIsUnregistered() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.empty,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        boolean actual = regLog.isThereRegLogForm();
        Assertions.assertTrue(actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Login tests")
    @Description("Username is unregistered test")
    @DisplayName("TC15")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginUsernameIsUnregistered() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.empty,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        boolean actual = regLog.isThereRegLogForm();
        Assertions.assertTrue(actual);
    }

}