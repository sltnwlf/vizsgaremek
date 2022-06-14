import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

public class DataInputTests extends BaseTest {

    @RepeatedTest(2)
    @DisplayName("TC11")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputSuccessful() {
        String data = "test";
        String emailData = "test@test.test";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(data, data);
        registrationAndLoginPage.login(data, data);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnGetInTouchButton();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillName(data);
        contactPage.fillEmail(emailData);
        contactPage.fillMessage(data);
        contactPage.clickOnCheckbox();
        contactPage.clickOnButton();
        boolean actual = contactPage.isThereStatusMessage();

        Assertions.assertTrue(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC12")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputSuccessfulEmptyMessage() {
        String data = "test";
        String emailData = "test@test.test";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(data, data);
        registrationAndLoginPage.login(data, data);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnGetInTouchButton();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillName(data);
        contactPage.fillEmail(emailData);
        contactPage.clickOnCheckbox();
        contactPage.clickOnButton();
        boolean actual = contactPage.isThereStatusMessage();

        Assertions.assertTrue(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC13")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputUnsuccessfulEmptyCheckbox() {
        String data = "test";
        String emailData = "test@test.test";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(data, data);
        registrationAndLoginPage.login(data, data);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnGetInTouchButton();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillName(data);
        contactPage.fillEmail(emailData);
        contactPage.clickOnButton();
        boolean actual = contactPage.isThereStatusMessage();

        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC14")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputUnsuccessfulEmptyEmail() {
        String data = "test";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(data, data);
        registrationAndLoginPage.login(data, data);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnGetInTouchButton();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillName(data);
        contactPage.clickOnCheckbox();
        contactPage.clickOnButton();
        boolean actual = contactPage.isThereStatusMessage();

        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC15")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputUnsuccessfulWithoutAtSign(){
        String data = "test";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(data, data);
        registrationAndLoginPage.login(data, data);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnGetInTouchButton();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillName(data);
        contactPage.fillEmail(data);
        contactPage.clickOnCheckbox();
        contactPage.clickOnButton();
        boolean actual = contactPage.isThereStatusMessage();

        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC16")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputUnsuccessfulEmptyAfterAtSign() {
        String data = "test";
        String emailData = "test@";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(data, data);
        registrationAndLoginPage.login(data, data);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnGetInTouchButton();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillName(data);
        contactPage.fillEmail(emailData);
        contactPage.clickOnCheckbox();
        contactPage.clickOnButton();
        boolean actual = contactPage.isThereStatusMessage();

        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC17")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputUnsuccessfulEmptyBeforeAtSign() {
        String data = "test";
        String emailData = "@test.test";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(data, data);
        registrationAndLoginPage.login(data, data);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnGetInTouchButton();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillName(data);
        contactPage.fillEmail(emailData);
        contactPage.clickOnCheckbox();
        contactPage.clickOnButton();
        boolean actual = contactPage.isThereStatusMessage();

        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC18")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputUnsuccessfulWithoutDot() {
        String data = "test";
        String emailData = "test@test";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(data, data);
        registrationAndLoginPage.login(data, data);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnGetInTouchButton();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillName(data);
        contactPage.fillEmail(emailData);
        contactPage.clickOnCheckbox();
        contactPage.clickOnButton();
        boolean actual = contactPage.isThereStatusMessage();

        Assertions.assertFalse(actual);
    }
    @RepeatedTest(2)
    @DisplayName("TC19")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputUnsuccessfulEmptyName() {
        String data = "test";
        String emailData = "test@test.test";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(data, data);
        registrationAndLoginPage.login(data, data);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnGetInTouchButton();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillEmail(emailData);
        contactPage.clickOnCheckbox();
        contactPage.clickOnButton();
        boolean actual = contactPage.isThereStatusMessage();

        Assertions.assertFalse(actual);
    }
}
