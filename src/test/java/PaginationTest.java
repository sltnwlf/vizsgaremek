import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class PaginationTest {
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
    @DisplayName("TC8")
    @Severity(SeverityLevel.NORMAL)
    public void testPagination() {
        String username = "test";
        String password = "test";
        RegistrationAndLoginPage registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        registrationAndLoginPage.clickOnTermsAndConditionsAccept();
        registrationAndLoginPage.registration(username, password);
        registrationAndLoginPage.login(username, password);
        LandingPage landingPage = new LandingPage(driver);
        //landingPage.clickOnBlogButton();
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        landingPage.clickOnSeeAllPostButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        RecentsArticlePage recentsArticlePage = new RecentsArticlePage(driver);
        int actual = 0;
        while (true) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            actual += recentsArticlePage.numberOfPosts();
            if (!recentsArticlePage.isThereNextButton()) {
                break;
            }
            recentsArticlePage.clickOnNextButton();
        }
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }

    @AfterEach
    public void dispose(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}
