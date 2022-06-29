package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BlogPage {

    private final WebDriver driver;
    private final By articles = By.xpath("//*[@id=\"content\"]/section/div/div/div");
    private final By articleLinks = By.xpath("//a[starts-with(@class,\"text-dark\")]");
    private final By next = By.xpath("//*[@id=\"content\"]/section/div/div/nav/ul/li[3]/a");

    public BlogPage(WebDriver driver) {
        this.driver = driver;
    }


    /*******************************************************************************************************************
                           Egyszerű metódus az adott oldalon található cikkek megszámolására.
                      Egy listába tesszük a fellelhető cikkeket, majd visszaadjuk a lista hosszát.
     ******************************************************************************************************************/
    public int numberOfArticles() {
        List<WebElement> articleList = driver.findElements(articles);
        return articleList.size();
    }

    /*******************************************************************************************************************
                         Metódus a következő oldalra léptető gomb láthatóságának ellenőrzésére.
         Egy WebDriverWait-tel 5 másodpercig várakozunk arra, hogy látható-e az adott oldalon léptető gomb vagy sem,
                                 és az ennek megfelelő boolean értékkel térünk vissza.
     ******************************************************************************************************************/
    public boolean isThereButtonNext() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(next));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    /*******************************************************************************************************************
              Metódus, ami a következő oldalra léptet, amennyiben látható még a következő oldalra léptető gomb.
     ******************************************************************************************************************/
    public void clickOnButtonNext() {
        if (isThereButtonNext()) {
            driver.findElement(next).click();
        }
    }

    /*******************************************************************************************************************
             Metódus, ami a többoldalas bloglista első oldalán található cikkek címéből egy listát állít össze.
        Egy listába mentjük a cikkek linkjeit, majd egy String[]-et hozunk létre az előző lista méretére beállítva.
        Egy for ciklussal végigiterálva a linkeken, a getText() metódussal minden iterációban kiszedjük a címeket,
                                 egyenesen a string[]-be amit a végén vissza is adunk.
     ******************************************************************************************************************/
    public String[] listArticleTitlesOnFirstPage() {
        List<WebElement> articleLinkList = driver.findElements(articleLinks);
        String[] titleList = new String[articleLinkList.size()];
        for (int i = 0; i < articleLinkList.size(); i++) {
            String title = articleLinkList.get(i).getText();
            titleList[i] = title;
        }
        return titleList;
    }

    /*******************************************************************************************************************
                           Metódus, ami a blog oldalakon található összes cikket összeszámolja.
                              Létrehozunk egy számlálot, ami kezdeti értékének nullát adunk.
                           Egy while ciklus segítségével, addig lépkedünk tovább az oldalakon,
                                   amíg megtaláljuk a következő oldalra léptető gombot,
         eközben pedog minden oldalon hozzáadjuk a számlálóhoz az éppen aktuális oldalon található cikkek számát.
     ******************************************************************************************************************/
    public int articleCounter() {
        int actual = 0;
        while (true) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            actual += numberOfArticles();
            if (!isThereButtonNext()) {
                break;
            }
            clickOnButtonNext();
        }
        return actual;
    }

    /*******************************************************************************************************************
                    Metódus, ami a blog oldalakon található összes cikk címét egy listába rendezi.
      Létrehozunk egy WebElement-ekből álló listát inicializálatlanul, és egy String-eket tartalmazó új ArrayListet is.
           Egy while ciklus segítségével, minden iterációban megkeressük, az adott oldalon található cikkek linkjét.
           Ezen belül pedig egy for ciklus segítségével végigiterálunk az összes aktuális oldalon található linken,
                   kiszedjük a címeket, majd az előre létrehozott ArrayList-et fel is töltjük ezekkel.
                   Ugyaezt megtesszük az utolsó oldalon is és vissza is adjuk a kész ArrayList-ünket.
     ******************************************************************************************************************/
    public ArrayList<String> listArticleTitlesOnAllPage() {
        List<WebElement> articleLinkList;
        ArrayList<String> titleList = new ArrayList<>();
        while (isThereButtonNext()) {
            articleLinkList = driver.findElements(articleLinks);
            for (WebElement articleLink : articleLinkList) {
                titleList.add(articleLink.getAttribute("innerHTML"));
            }
            clickOnButtonNext();
        }
        articleLinkList = driver.findElements(articleLinks);
        for (WebElement articleLink : articleLinkList) {
            titleList.add(articleLink.getAttribute("innerHTML"));
        }
        return titleList;
    }

    /*******************************************************************************************************************
               Metódus, ami a blog oldalakon található összes cikk címét egy txt kiterjesztésű fájlba rendezi.
           Létrehozunk egy új FileWriter-t aminek paraméterként átadjuk az általunk kiválasztott leendő fájl nevét.
               A listArticleTitlesOnAllPage() metódusommal, megkapjuk a címeket tartalmazó String ArrayList-et.
                        Egy while ciklus segítségével, az új fájlban minden címet új sorba írunk.
     ******************************************************************************************************************/
    public void saveArticleTitlesIntoFile() {
        try {
            FileWriter writer = new FileWriter("ArticleTitles.txt");
            BufferedWriter out = new BufferedWriter(writer);
            ArrayList<String> articleTitles = listArticleTitlesOnAllPage();
            int i = 0;
            while (i < articleTitles.size()) {
                out.write(i+1 + ". article title: " + articleTitles.get(i) + "\n");
                i++;
            }
            out.close();
        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }

}