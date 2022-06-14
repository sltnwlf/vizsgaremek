import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class LogoutTest extends BaseTest {

    @RepeatedTest(2)
    @DisplayName("TC08")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogoutSuccessful(){
        String username = "test";
        String password = "test";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(username, password);
        registrationAndLoginPage.login(username, password);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnLogoutButton();
        boolean actual = registrationAndLoginPage.isThereLoginWindow();

        Assertions.assertTrue(actual);
    }
}
