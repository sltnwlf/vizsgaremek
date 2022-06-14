import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class LoginTests extends BaseTest {

    @RepeatedTest(2)
    @DisplayName("TC05")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginSuccessful(){
        String username = "test";
        String password = "test";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(username, password);
        registrationAndLoginPage.login(username, password);
        boolean actual = registrationAndLoginPage.isThereLoginWindow();

        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC06")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithWrongUsername() {
        String username = "test";
        String password = "test";
        String wrongUsername = "";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(username, password);
        registrationAndLoginPage.login(wrongUsername, password);
        boolean actual = registrationAndLoginPage.isThereLoginWindow();

        Assertions.assertTrue(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC07")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithWrongPassword() {
        String username = "test";
        String password = "test";
        String wrongPassword = "";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(username, password);
        registrationAndLoginPage.login(username, wrongPassword);
        boolean actual = registrationAndLoginPage.isThereLoginWindow();

        Assertions.assertTrue(actual);
    }
}
