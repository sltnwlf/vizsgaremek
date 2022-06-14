import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;
public class DataListingTest extends BaseTest {

    @RepeatedTest(2)
    @DisplayName("TC10")
    @Severity(SeverityLevel.NORMAL)
    public void testDataListing() {
        String username = "test";
        String password = "test";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(username, password);
        registrationAndLoginPage.login(username, password);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnSeeAllPostButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        RecentsArticlePage recentsArticlePage = new RecentsArticlePage(driver);
        String[] actual = recentsArticlePage.listPostTitles();
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
