import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RegistrationTests {

    private WebDriver driver;

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
    @DisplayName("TC3")
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
    @DisplayName("TC4")
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

    @AfterEach
    public void dispose(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
