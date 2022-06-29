package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RegLogPage {

    private final WebDriver driver;
    private WebDriverWait wait;
    private final By termsAndConditionsPopup = By.xpath("//*[@id=\"overlay\"]/div");
    private final By termsAndConditionsAccept = By.id("terms-and-conditions-button");
    private final By termsAndConditionsClose = By.className("CloseIcon");
    private final By regLogForm = By.xpath("//*[@id=\"login\"]");
    private final By registerForm = By.xpath("(//*[@id=\"register-form-button\"])[1]");
    private final By registerUsername = By.xpath("//*[@id=\"register-username\"]");
    private final By registerPassword = By.xpath("//*[@id=\"register-password\"]");
    private final By registerEmail = By.xpath("//*[@id=\"register-email\"]");
    private final By registerDescription = By.xpath("//*[@id=\"register-description\"]");
    private final By registerButton = By.xpath("//*[@id=\"register\"]/form/div[6]/button");
    private final By registerStatus = By.xpath("//*[@id=\"register-alert\"]");
    private final By loginForm = By.xpath("//*[@id=\"register\"]/Button[@id=\"login-form-button\"]");
    private final By loginUsername = By.xpath("//*[@id=\"email\"]");
    private final By loginPassword = By.xpath("//*[@id=\"password\"]");
    private final By loginButton = By.xpath("//*[@id=\"login\"]/form/div[4]/button");

    public RegLogPage(WebDriver driver) {
        this.driver = driver;
    }

    /*******************************************************************************************************************
                               Egyszerű metódus, ami elfogadja az adatvédelmi nyilatkozatot.
     ******************************************************************************************************************/
    public void clickOnTermsAndConditionsAccept() {
        driver.findElement(termsAndConditionsAccept).click();
    }

    /*******************************************************************************************************************
                  Egyszerű metódus, ami elfogadás nélkül bezárja az adatvédelmi nyilatkozat popup ablakát.
     ******************************************************************************************************************/
    public void clickOnTermsAndConditionsClose() {
        driver.findElement(termsAndConditionsClose).click();
    }

    /*******************************************************************************************************************
                     Metódus, ami ellenőrzi, hogy megjelent-e az adatvédelmi nyilatkozat popup ablaka
                                   és az ennek megfelelő boolean értékkel tér vissza.
     ******************************************************************************************************************/
    public boolean isThereTermsAndConditionsPopup() {
        try {
            wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(termsAndConditionsPopup));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    /*******************************************************************************************************************
                                       Metódus, ami végrhajt egy registrációt.
                 Átkattint a register formra, feltölti az inputokat, és rákattint a regisztráció gombra.
     ******************************************************************************************************************/
    public void registration(String regUsername,
                             String regPassword,
                             String regEmail,
                             String regDescription) {
        driver.findElement(registerForm).click();
        driver.findElement(registerUsername).sendKeys(regUsername);
        driver.findElement(registerPassword).sendKeys(regPassword);
        driver.findElement(registerEmail).sendKeys(regEmail);
        driver.findElement(registerDescription).sendKeys(regDescription);
        driver.findElement(registerButton).click();
    }

    /*******************************************************************************************************************
                     Metódus, ami ellenőrzi, hogy megjelent-e a regisztrációval kapcsolatos üzenet,
                                   és az ennek megfelelő boolean értékkel tér vissza.
     ******************************************************************************************************************/
    public boolean isThereRegisterStatus() {
        try {
            wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(registerStatus));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    /*******************************************************************************************************************
                   Egyszerű metódus, ami regisztrációval kapcsolatos üzenet String értékével tér vissza.
     ******************************************************************************************************************/
    public String getRegisterStatus() {
        return driver.findElement(registerStatus).getText();
    }

    /*******************************************************************************************************************
                                    Egyszerű metódus, ami rákattint a login gombra.
     ******************************************************************************************************************/
    public void clickOnLogin() {
        driver.findElement(loginButton).click();
    }

    /*******************************************************************************************************************
                           Metódus, ami feltölti a login inputokat és rákattint a login gombra.
     ******************************************************************************************************************/
    public void login(String logUsername, String logPassword) {
        driver.findElement(loginUsername).sendKeys(logUsername);
        driver.findElement(loginPassword).sendKeys(logPassword);
        driver.findElement(loginButton).click();
    }

    /*******************************************************************************************************************
                         Metódus, ami egyszerre regisztrál be és jelentkeztet be egy felhasználót.
     ******************************************************************************************************************/
    public void regLog(String regUsername,
                       String regPassword,
                       String regEmail,
                       String regDescription,
                       String logUsername,
                       String logPassword) {
        driver.findElement(registerForm).click();
        driver.findElement(registerUsername).sendKeys(regUsername);
        driver.findElement(registerPassword).sendKeys(regPassword);
        driver.findElement(registerEmail).sendKeys(regEmail);
        driver.findElement(registerDescription).sendKeys(regDescription);
        driver.findElement(registerButton).click();
        driver.findElement(loginForm).click();
        driver.findElement(loginUsername).sendKeys(logUsername);
        driver.findElement(loginPassword).sendKeys(logPassword);
        driver.findElement(loginButton).click();
    }

    /*******************************************************************************************************************
                           Metódus, ami azt ellenőrzi, hogy megjelent-e a bejelentkező ablak
                                 és az ennek megfelelő boolean értékkel tér vissza.
     ******************************************************************************************************************/
    public boolean isThereRegLogForm() {
        try {
            wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(regLogForm));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    /*******************************************************************************************************************
                          Metódus, ami ismételten és sorozatosan regisztrál felhasználókat,
                                   egy külső adatforrásból beolvasott adatokkal.
                   Egy FileReader-nek átadjuk a beolvasni kívánt adatokat tartalmazó fájl nevét.
      Létrehozunk egy ArrayList-et, amibe egy while ciklus segítségével belerakjuk a megadott fájl tartalmát soronként.
                     Létrehozunk egy ArrayList-et, amit a regisztrációs inputokkal töltünk fel.
            Egy újabb while ciklus segítségével, amíg nem érjük el az ArrayList-ben található String sorok számát,
               egy for ciklus segítségével újra és újra  végigiterálunk az inputokon és minden inputnak átadjuk
               a megfelelő sort tartalmazó Stringet, majd rákattintunk a regisztrációra és frissítjük az oldalt.
     ******************************************************************************************************************/
    public void registrationRepeatedlyAndContinuouslyFromDatasource() {
        Utils u = new Utils(driver);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("RegTestData.txt"));

            ArrayList<String> lineList = new ArrayList<>();
            String line = "";
            while (line != null) {
                line = reader.readLine();
                lineList.add(line);
            } lineList.remove(lineList.size()-1);

            ArrayList<By> inputFieldList = new ArrayList<>();
            inputFieldList.add(registerUsername);
            inputFieldList.add(registerPassword);
            inputFieldList.add(registerEmail);
            inputFieldList.add(registerDescription);
            int i = 0;
            while (i < lineList.size()) {
                driver.findElement(registerForm).click();
                for (By by : inputFieldList) {
                    driver.findElement(by).sendKeys(lineList.get(i));
                    i++;
                }
                driver.findElement(registerButton).click();
                u.refresh();
            } reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } u.refresh();
    }

    /*******************************************************************************************************************
                 Metódus, ami ismételten és sorozatosan regisztrál, majd bejelentkeztet felhasználókat,
                                   két külön adatforrásból beolvasott adatokkal.
                     Egy FileReader-nek átadjuk a beolvasni kívánt adatokat tartalmazó fájl nevét.
      Létrehozunk egy ArrayList-et, amibe egy while ciklus segítségével belerakjuk a megadott fájl tartalmát soronként.
                       Létrehozunk egy ArrayList-et, amit a regisztrációs inputokkal töltünk fel.
           Egy újabb while ciklus segítségével, amíg nem érjük el az ArrayList-ben található String sorok számát,
              egy for ciklus segítségével újra és újra végigiterálunk az inputokon és minden inputnak átadjuk
             a megfelelő sort tartalmazó Stringet, majd rákattintunk a regisztrációra és frissítjük az oldalt.
                                      Miután beregisztráltuk a felhasználókat,
                   egy FileReader-nek átadjuk a beolvasni kívánt adatokat tartalmazó fájl nevét.
      Létrehozunk egy ArrayList-et, amibe egy while ciklus segítségével belerakjuk a megadott fájl tartalmát soronként.
                     Létrehozunk egy ArrayList-et, amit a bejelentkező inputokkal töltünk fel.
          Egy újabb while ciklus segítségével, amíg nem érjük el az ArrayList-ben található String sorok számát,
             egy for ciklus segítségével újra és újra végigiterálunk az inputokon és minden inputnak átadjuk
        a megfelelő sort tartalmazó Stringet, rákattintunk a login-ra, majd a logout-ra is és frissítjük az oldalt.
     ******************************************************************************************************************/
    public void regLogRepeatedlyAndContinuouslyFromDatasource() {
        Utils u = new Utils(driver);

        // REGISTER
        BufferedReader registerReader;
        try {
            registerReader = new BufferedReader(new FileReader("RegTestData.txt"));

            ArrayList<String> lineList = new ArrayList<>();
            String line = "";
            while (line != null) {
                line = registerReader.readLine();
                lineList.add(line);
            } lineList.remove(lineList.size()-1);

            ArrayList<By> inputFieldList = new ArrayList<>();
            inputFieldList.add(registerUsername);
            inputFieldList.add(registerPassword);
            inputFieldList.add(registerEmail);
            inputFieldList.add(registerDescription);
            int i = 0;
            while (i < lineList.size()) {
                driver.findElement(registerForm).click();
                for (By by : inputFieldList) {
                    driver.findElement(by).sendKeys(lineList.get(i));
                    i++;
                }
                driver.findElement(registerButton).click();
                u.refresh();
            } registerReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } u.refresh();

        // LOGIN
        BufferedReader loginReader;
        try {
            loginReader = new BufferedReader(new FileReader("LogTestData.txt"));

            ArrayList<String> lineList = new ArrayList<>();
            String line = "";
            while (line != null) {
                line = loginReader.readLine();
                lineList.add(line);
            } lineList.remove(lineList.size()-1);

            ArrayList<By> inputFieldList = new ArrayList<>();
            inputFieldList.add(loginUsername);
            inputFieldList.add(loginPassword);
            int i = 0;
            while (i < lineList.size()) {
                for (By by : inputFieldList) {
                    driver.findElement(by).sendKeys(lineList.get(i));
                    i++;
                } clickOnLogin();
                LandingPage landPage = new LandingPage(driver);
                landPage.clickOnLogout();
            } loginReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } u.refresh();
    }

}