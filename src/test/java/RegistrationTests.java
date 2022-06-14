import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class RegistrationTests extends BaseTest {

    @RepeatedTest(2)
    @DisplayName("TC03")
    @Severity(SeverityLevel.CRITICAL)
    public void testSuccessfulRegistration(){
        String username = "test";
        String password = "test";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(username, password);
        String actual = registrationAndLoginPage.getRegisterAlertMessage();
        String expected = "User registered!";

        Assertions.assertEquals(expected, actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC04")
    @Severity(SeverityLevel.CRITICAL)
    public void testUnsuccessfulRegistration() {
        String username = "";
        String password = "";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(username, password);
        String actual = registrationAndLoginPage.getRegisterAlertMessage();
        String expected = "Invalid data";

        Assertions.assertEquals(expected, actual);
    }
}
