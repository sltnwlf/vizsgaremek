package requirements;

import base.TestBase;
import base.TestDataCollection;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class DataListingTests extends TestBase {

    @RepeatedTest(2)
    @DisplayName("TC18")
    @Severity(SeverityLevel.NORMAL)
    public void testDataListingOnFirstArticlePage() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(
                TestDataCollection.username,
                TestDataCollection.password,
                TestDataCollection.emailValid,
                TestDataCollection.description,
                TestDataCollection.username,
                TestDataCollection.password);
        landing.clickOnSeeAllPostButton();
        String[] actual = articles.listPostTitlesOnFirstPage();
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
