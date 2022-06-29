package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class DataDeleteTests extends TestBase {

    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data delete tests")
    @Description("Profile data delete test")
    @DisplayName("TC32")
    @Severity(SeverityLevel.CRITICAL)
    public void testProfileDataDelete() {
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
        int numberOfCookies1 = utils.getCookies().size();
        utils.refresh();
        profile.deleteAtOnce();
        int numberOfCookies2 = utils.getCookies().size();
        boolean isTrue = numberOfCookies1 == numberOfCookies2;
        Assertions.assertFalse(isTrue);
    }

}
