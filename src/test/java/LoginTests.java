import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginTests {

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
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920, 1080");
        //options.addArguments("--user-agent='Mozilla/5.0 (Windows Phone 10.0; Android 4.2.1; Microsoft; Lumia 640 XL LTE) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Mobile Safari/537.36 Edge/12.10166'");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);

        driver.navigate().to("https://lennertamas.github.io/portio/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @RepeatedTest(2)
    @DisplayName("TC5")
    @Severity(SeverityLevel.CRITICAL)
    public void testSuccessfulLogin(){
        String username = "Zoli";
        String password = "123";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(username, password);
        registrationAndLoginPage.login(username, password);
        boolean actual = registrationAndLoginPage.isThereLoginWindow();

        Assertions.assertFalse(actual);
    }

    @RepeatedTest(2)
    @DisplayName("TC6")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithWrongUsername() {
        String username = "";
        String password = "123";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(username, password);
        registrationAndLoginPage.login(username, password);
        boolean actual = registrationAndLoginPage.isThereLoginWindow();

        Assertions.assertTrue(actual);
    }

    @RepeatedTest(2)
    @DisplayName("TC7")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithWrongPassword() {
        String username = "";
        String password = "";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(username, password);
        registrationAndLoginPage.login(username, password);
        boolean actual = registrationAndLoginPage.isThereLoginWindow();

        Assertions.assertTrue(actual);
    }

    @AfterEach
    public void dispose(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
