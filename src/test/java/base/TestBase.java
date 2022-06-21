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

    /**
     * GENERAL
     * Az extends kulcsszó hazsnálatával az itt létrehozott driver átörökíthető a tesztosztályokba, így nem kell majd azokban is külön létrehozni.
     * Az egyes oldalakat inicializálás nélkül osztály szintű változókba mentem.
     * */
    protected WebDriver driver;
    protected ArticlePage articles;
    protected ContactPage contact;
    protected LandingPage landing;
    protected RegLogPage regLog;
    protected ProfilePage profile;
    protected Utils utils;

    /**
     * @BeforeEach
     * Minden egyes teszt előtt lefut.
     * Létrehozom a WebDriverManager-t, ami lehetővé teszi a WebDriver beállítását tényleges letöltés nélkül.
     * Példányosítok egy új ChromeOptions-t, amivel további beállításokat eszközölhetek.
     * A létrehozott ChromeOptions-höz egyenként hozzáadom az általam kívánt opciókat. Pl.: Mindig inkognitó módban induljon a teszt.
     * A driver inicializálásakor, példányosítok egy ChromeDriver-t és paraméterként átadom neki a fentebb kiválasztott opciókat.
     * A tesztelendő oldalra navigálok.
     * Várakoztatok 10 másodpercet, hogy az oldal biztosan betöltsön, mielőtt továbblépnénk.
     * Maximálom az ablak méretét.
     * Az egyes oldalakhoz tartozó változóimat úgy inicializálom, hogy az adott oldal egy új példányát adják vissza,
     * ezzel a tesztekben elég lesz a változókra hivatkozni és úgy meghívni az adott oldal metódusait,
     * tehát külön már nem kell példányosítanom az oldalakat.
     */
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

    /**
     * @AfterEach
     * Minden egyes teszt után lefut.
     * A deleteAllCookies() töröl minden, a teszt során létrehozott tárolt adatot.
     * A quit() bezárja az összes, a teszt során megnyitott ablakot.
     */
    @AfterEach
    public void dispose(){
        driver.manage().deleteAllCookies();
        //driver.quit();
    }

}
