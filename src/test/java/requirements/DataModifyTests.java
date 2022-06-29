package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.Cookie;
import java.util.Set;

public class DataModifyTests extends TestBase {

    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data modify tests")
    @Description("Profile data modify test")
    @DisplayName("TC31")
    @Severity(SeverityLevel.CRITICAL)
    public void testProfileDataModify() {
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
