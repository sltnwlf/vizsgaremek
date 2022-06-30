package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class DataListingTests extends TestBase {

    @RepeatedTest(1)
    @Epic("Portio")
    @Story("Data listing tests")
    @DisplayName("TC18, Listing on first blog page test")
    @Severity(SeverityLevel.NORMAL)
    public void testDataListingOnFirstBlogPage() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword,
                TestDataCollection.email,
                TestDataCollection.regLogDescription,
                TestDataCollection.regLogUsername,
                TestDataCollection.regLogPassword);
        landing.clickOnSeeAllPost();
        String[] actual = blog.listArticleTitlesOnFirstPage();
        String[] expected = {
                "Markdown Formatting Demo",
                "Designer Conference at Florida 2020",
                "Benjamin Franklins thoughts about new designers",
                "Designers thoughts about mobile UI",
                "How to become acreative designer",
                "New designers limitations"};
        Assertions.assertArrayEquals(expected, actual);
    }

}
