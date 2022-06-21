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

public class DataModifyTests extends TestBase {

    @RepeatedTest(2)
    @DisplayName("TC31")
    @Severity(SeverityLevel.CRITICAL)
    public void testProfileDataModify() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        landing.clickOnProfileButton();
        profile.profileInputFiller(
                TestDataCollection.profileName1,
                TestDataCollection.profileBio1,
                TestDataCollection.profilePhone1);
        Set<Cookie> cookies1 = utils.getCookies();
        utils.refresh();
        profile.profileInputFiller(
                TestDataCollection.profileName2,
                TestDataCollection.profileBio2,
                TestDataCollection.profilePhone2);
        utils.getCookies();
        Set<Cookie> cookies2 = utils.getCookies();
        boolean isTrue = cookies1 == cookies2;
        Assertions.assertFalse(isTrue);
    }
}
