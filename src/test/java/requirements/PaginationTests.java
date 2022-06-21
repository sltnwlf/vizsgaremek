package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class PaginationTests extends TestBase {

    @RepeatedTest(2)
    @DisplayName("TC17")
    @Severity(SeverityLevel.CRITICAL)
    public void testPaginationOnArticles() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        landing.clickOnSeeAllPostButton();
        int expected = 9;
        int actual = articles.postCounter();
        Assertions.assertEquals(expected, actual);
    }
}
