package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/***********************************************************************************************************************
                                Általános felhasználásra készített metódusok osztálya.
 **********************************************************************************************************************/
public class Utils {

    protected WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    /*******************************************************************************************************************
                                  Egyszerű navigációs metódus a tesztelendő oldalra.
     ******************************************************************************************************************/
    public void navigateToPortio() {
        driver.get("https://lennertamas.github.io/portio/");
    }

    /*******************************************************************************************************************
                                          Egyszerű, oldal frissítés metódus.
     ******************************************************************************************************************/
    public void refresh() {
        driver.navigate().refresh();
    }

    /*******************************************************************************************************************
                                      Egyszerű, Thread.sleep várakoztató metódus.
     ******************************************************************************************************************/
    public void sleep(int timeInMillis) throws InterruptedException {
        Thread.sleep(timeInMillis);
    }

    /*******************************************************************************************************************
                                     Egyszerű, implicitlyWait várakoztató metódus.
     ******************************************************************************************************************/
    public void implicitlyWait(int timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(timeInSeconds,TimeUnit.SECONDS);
    }

    /*******************************************************************************************************************
                                      Egyszerű, cookie álományt visszaadó metódus.
     ******************************************************************************************************************/
    public Set<Cookie> getCookies() {
        return driver.manage().getCookies();
    }

    /*******************************************************************************************************************
                               Egyszerű screenshot készítő metódus az allure report-hoz.
     ******************************************************************************************************************/
    public void makeScreenshot() {
        Allure.addAttachment("Screenshot of Tested Page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    /*******************************************************************************************************************
                            A JavascriptExecutor segítségével új tabot megnyitó metódus.
     ******************************************************************************************************************/
    public void createNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    /*******************************************************************************************************************
                  A JavascriptExecutor segítségével a paraméterben megadott pixelnyit görgető metódus.
     ******************************************************************************************************************/
    public void scrollOnPage(int pixels) {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+ pixels +")","");
    }

    /*******************************************************************************************************************
                    A JavascriptExecutor segítségével a megkeresett WebElement-hez görgető metódus.
               Egy kis korekcióra volt szükség, mivel felső menűsáv miatt kitakarta a kattintandó gombot,
                                  így 200 pixelnyit még feljebb kellett görgetni.
     ******************************************************************************************************************/
    public void scrollToElement(By element) {
        WebElement button = driver.findElement(element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",button);
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-200)", "");
    }

    /*******************************************************************************************************************
                  Fájlból olvasó metódus, aminek paraméterben átadjuk az olvasni kívánt fájl nevét,
                     egy ArrayList-be mentjük a sorok listáját és soronként elkezdjük beolvasni.
                          Amíg vannak sorok egyenként feltöltjük velük az ArrayList-ünket.
       Ezután létrehozunk egy String[]-et, majd egy for ciklus segítségével, feltöltjük az ArrayList-ünk tartalmával.
                                    Végül pedig vissza is adjuk a String[]-et.
     ******************************************************************************************************************/
    public String[] readFromFile(String fileName) {
        BufferedReader reader;
        ArrayList<String> lineList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while (line != null) {
                line = reader.readLine();
                lineList.add(line);
            }
            lineList.remove(lineList.size()-1);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] resultStrArr = new String[lineList.size()];
        for (int i = 0; i < lineList.size(); i++) {
            resultStrArr[i] = lineList.get(i);
        }
        return resultStrArr;
    }

}
