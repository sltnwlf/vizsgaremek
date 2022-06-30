package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class DataInputRepeatedlyAndContinuouslyFromDatasourceTests extends TestBase {

    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input repeatedly and continuously from datasource tests")
    @DisplayName("TC28, Data input on registration repeatedly and continuously from datasource test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputOnRegistrationRepeatedlyAndContinuouslyFromDatasource() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationRepeatedlyAndContinuouslyFromDatasource();
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int expected = 6;
        int actual = cookieSet.size();
        Assertions.assertEquals(expected,actual);
    }
    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data input repeatedly and continuously from datasource tests")
    @DisplayName("TC29, Data input on login repeatedly and continuously from datasource test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputOnLoginRepeatedlyAndContinuouslyFromDatasource() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLogRepeatedlyAndContinuouslyFromDatasource();
        regLog.login(
                TestDataCollection.regLogUsernameFromFile,
                TestDataCollection.regLogPasswordFromFile);
        boolean logActual = regLog.isThereRegLogForm();
        Assertions.assertFalse(logActual);
    }

}
