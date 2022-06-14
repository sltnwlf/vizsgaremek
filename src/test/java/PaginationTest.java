import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class PaginationTest extends BaseTest {

    @RepeatedTest(2)
    @DisplayName("TC09")
    @Severity(SeverityLevel.NORMAL)
    public void testPagination() {
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
        int expected = 9;
        int actual = 0;
        while (true) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            actual += recentsArticlePage.numberOfPosts();
            if (!recentsArticlePage.isThereNextButton()) {
                break;
            }
            recentsArticlePage.clickOnNextButton();
        }

        Assertions.assertEquals(expected, actual);
    }
}
