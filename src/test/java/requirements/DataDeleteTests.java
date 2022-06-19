package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class DataDeleteTests extends TestBase {

    @RepeatedTest(2)
    @DisplayName("TC32")
    @Severity(SeverityLevel.CRITICAL)
    public void testProfileDataDelete() {
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
        int numberOfCookies1 = utils.getCookies().size();
        utils.refresh();
        profile.deleteAccount();
        int numberOfCookies2 = utils.getCookies().size();
        boolean isTrue = numberOfCookies1 == numberOfCookies2;
        System.out.println(isTrue);
        Assertions.assertFalse(isTrue);
    }

}
