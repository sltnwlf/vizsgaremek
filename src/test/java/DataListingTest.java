import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class DataListingTest extends BaseTest {

    @RepeatedTest(2)
    @DisplayName("TC18")
    @Severity(SeverityLevel.NORMAL)
    public void testDataListing() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,username,password);
        landing.clickOnSeeAllPostButton();
        String[] actual = articles.listPostTitles();
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
