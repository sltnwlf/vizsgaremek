package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class DataInputRepeatedlyAndContinuouslyFromDatasourceTests extends TestBase {

    @RepeatedTest(2)
    @DisplayName("TC28")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputOnRegistrationRepeatedlyAndContinuouslyFromDatasource() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationSequentiallyAndContinuouslyFromDatasource();
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int expected = 6;
        int actual = cookieSet.size();
        Assertions.assertEquals(expected,actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC29")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputOnLoginRepeatedlyAndContinuouslyFromDatasource() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLogRepeatedlyAndContinuouslyFromDatasource();
        regLog.login(
                TestDataCollection.usernameTestDataFromFile,
                TestDataCollection.passwordTestDataFromFile);
        boolean logActual = regLog.isThereLoginWindow();
        Assertions.assertFalse(logActual);
    }
}
