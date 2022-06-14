import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class TermsAndConditionsTests extends BaseTest {
    private final String username = "test";
    private final String password = "test";

    @RepeatedTest(2)
    @DisplayName("TC01")
    @Severity(SeverityLevel.NORMAL)
    public void testAcceptTermsAndConditions(){
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(username, password);
        registrationAndLoginPage.login(username, password);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnPortioLogo();
        boolean actual = registrationAndLoginPage.isThereTermsAndConditionsPopupWindow();

        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC02")
    @Severity(SeverityLevel.NORMAL)
    public void testIgnoreTermsAndConditions() {
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsIgnore();
        registrationAndLoginPage.registration(username, password);
        registrationAndLoginPage.login(username, password);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnPortioLogo();
        boolean actual = registrationAndLoginPage.isThereTermsAndConditionsPopupWindow();

        Assertions.assertTrue(actual);
    }

}
