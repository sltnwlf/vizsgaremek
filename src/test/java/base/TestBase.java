package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.ArticlePage;
import pages.ContactPage;
import pages.LandingPage;
import pages.RegLogPage;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected RegLogPage regLog;
    protected LandingPage landing;
    protected ArticlePage articles;
    protected ContactPage contact;
    protected final String username = "Felhasznalonev";
    protected final String usernameForLoginAssertion = "Felhasznalonev03";
    protected final String password = "Jelszo01";
    protected final String passwordForLoginAssertion = "Jelszo03";
    protected final String emailValid = "teszt@email.hu";
    protected final String emailNothingAfterAtSign = "teszt@";
    protected final String emailNothingBeforeAtSign = "@email.hu";
    protected final String emailWithoutAtSign = "email.hu";
    protected final String emailWithoutDot = "teszt@email";
    protected final String description = "Egy rovid leiras.";
    protected final String name = "Nev";
    protected final String message = "Egy rovid uzenet.";
    protected final String empty = "";

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
        regLog = new RegLogPage(driver);
        landing = new LandingPage(driver);
        articles = new ArticlePage(driver);
        contact = new ContactPage(driver);
    }

    @AfterEach
    public void dispose(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
