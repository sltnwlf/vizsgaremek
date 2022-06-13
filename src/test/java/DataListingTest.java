import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DataListingTest {

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
    @DisplayName("TC10")
    @Severity(SeverityLevel.NORMAL)
    public void testDataListing() {
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
        String[] actual = recentsArticlePage.listPostTitles();
        String[] expected = {
                "Markdown Formatting Demo",
                "Designer Conference at Florida 2020",
                "Benjamin Franklins thoughts about new designers",
                "Designers thoughts about mobile UI",
                "How to become acreative designer",
                "New designers limitations"
        };
        Assertions.assertArrayEquals(expected, actual);
    }

    @AfterEach
    public void dispose(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
