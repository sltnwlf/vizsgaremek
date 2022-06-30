package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class PaginationTests extends TestBase {

    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Pagination tests")
    @DisplayName("TC17, Pagination on blog page test")
    @Severity(SeverityLevel.CRITICAL)
    public void testPaginationOnBlogPage() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnSeeAllPost();
        int expected = 9;
        int actual = blog.articleCounter();
        Assertions.assertEquals(expected, actual);
    }

}
