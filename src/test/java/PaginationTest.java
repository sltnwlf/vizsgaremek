import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class PaginationTest extends BaseTest {

    @RepeatedTest(2)
    @DisplayName("TC17")
    @Severity(SeverityLevel.NORMAL)
    public void testPagination() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,username,password);
        landing.clickOnSeeAllPostButton();
        int expected = 9;
        int actual = articles.postCounter();
        Assertions.assertEquals(expected, actual);
    }

}
