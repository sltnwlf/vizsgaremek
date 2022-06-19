package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import utils.Utils;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected ArticlePage articles;
    protected ContactPage contact;
    protected LandingPage landing;
    protected RegLogPage regLog;
    protected ProfilePage profile;
    protected Utils utils;
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
        articles = new ArticlePage(driver);
        contact = new ContactPage(driver);
        landing = new LandingPage(driver);
        profile = new ProfilePage(driver);
        regLog = new RegLogPage(driver);
        utils = new Utils(driver);
    }
    @AfterEach
    public void dispose(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
