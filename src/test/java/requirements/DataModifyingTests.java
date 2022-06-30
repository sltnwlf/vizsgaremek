package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.Cookie;
import java.util.Set;

public class DataModifyingTests extends TestBase {

    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data modifying tests")
    @DisplayName("TC31, Modifying on profile test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataModifyingProfile() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnProfile();
        profile.fillAll(
                TestDataCollection.profileName1,
                TestDataCollection.profileBio1,
                TestDataCollection.profilePhone1);
        Set<Cookie> cookies1 = utils.getCookies();
        profile.clearAll();
        profile.fillAll(
                TestDataCollection.profileName2,
                TestDataCollection.profileBio2,
                TestDataCollection.profilePhone2);
        utils.getCookies();
        Set<Cookie> cookies2 = utils.getCookies();
        boolean isTrue = cookies1 == cookies2;
        Assertions.assertFalse(isTrue);
    }

}
