import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class LogoutTest extends BaseTest {

    @RepeatedTest(2)
    @DisplayName("TC16")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogoutWithLogoutButton(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationAndLogin(username,password,emailValid,description,username,password);
        landing.clickOnLogoutButton();
        boolean actual = regLog.isThereLoginWindow();
        Assertions.assertTrue(actual);
    }

}
