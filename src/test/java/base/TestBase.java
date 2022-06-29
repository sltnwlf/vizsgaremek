package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import utils.Utils;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/*******************************************************************************************************************
                                       Minden teszt keretét megadó class.
 ******************************************************************************************************************/
public class TestBase {

    /*******************************************************************************************************************
               Az extends kulcsszó hazsnálatával az itt létrehozott driver átörökíthető a tesztosztályokba,
                                  így nem kell majd azokban is külön létrehozni.
                     Az egyes oldalakat inicializálás nélkül osztály szintű változókba mentem.
     ******************************************************************************************************************/
    protected WebDriver driver;
    protected BlogPage blog;
    protected ContactPage contact;
    protected LandingPage landing;
    protected RegLogPage regLog;
    protected ProfilePage profile;
    protected Utils utils;

    /*******************************************************************************************************************
                       A @BeforeEach annotációnak köszönhetően, minden egyes teszt előtt lefut.
          Létrehozzuk a WebDriverManager-t, ami lehetővé teszi a WebDriver beállítását tényleges letöltés nélkül.
                  Példányosítunk egy új ChromeOptions-t, amivel további beállításokat eszközölhetünk.
                   A létrehozott ChromeOptions-höz egyenként hozzáadjuk az általunk kívánt opciókat.
                               Például, hogy mindig inkognitó módban induljon a teszt.
                            A driver inicializálásakor, példányosítunk egy ChromeDriver-t.
                              Paraméterként átadjuk neki a fentebb kiválasztott opciókat.
                                          A tesztelendő oldalra navigálunk.
                  Várakoztatunk 10 másodpercet, hogy az oldal biztosan betöltsön, mielőtt továbblépnénk.
                                            Maximáljuk az ablak méretét.
        Az egyes oldalakhoz tartozó változókat úgy inicializálom, hogy az adott oldal egy új példányát adják vissza,
               ezzel a tesztekben elég lesz a változókra hivatkozni és úgy meghívni az adott oldal metódusait,
                             tehát külön már nem kell majd példányosítanom az oldalakat.
     ******************************************************************************************************************/
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
        blog = new BlogPage(driver);
        contact = new ContactPage(driver);
        landing = new LandingPage(driver);
        profile = new ProfilePage(driver);
        regLog = new RegLogPage(driver);
        utils = new Utils(driver);
    }

    /*******************************************************************************************************************
                      Az @AfterEach annotációnak köszönhetően, minden egyes teszt után lefut.
     * A makeScreenshot() minden tesztről képernyőfotót készít (!!! ELVILEG !!! MEGKÉRDEZNI HA NEM JÖVÖK RÁ !!!)
                    A deleteAllCookies() töröl minden, a teszt során létrehozott tárolt adatot.
                          A quit() bezárja az összes, a teszt során megnyitott ablakot.
     ******************************************************************************************************************/
    @AfterEach
    public void dispose(){
        utils.makeScreenshot();
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
