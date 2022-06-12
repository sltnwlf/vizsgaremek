import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TermsAndConditionsTests {

    private WebDriver driver;
    private final String username = "test";
    private final String password = "test";

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("−−incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920, 1080");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://lennertamas.github.io/portio/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @RepeatedTest(2)
    @DisplayName("TC1")
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
    @DisplayName("TC2")
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

    @AfterEach
    public void dispose(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
