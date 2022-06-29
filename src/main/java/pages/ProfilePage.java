package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    protected WebDriver driver;
    private final By name = By.xpath("//*[@id=\"name\"]");
    private final By bio = By.xpath("//*[@id=\"bio\"]");
    private final By phone = By.xpath("//*[@id=\"phone-number\"]");
    private final By save = By.xpath("//*[@id=\"edit-profile\"]/form/div[5]/button");
    private final By delete = By.xpath("//*[@id=\"edit-profile\"]/form/div[6]/button");
    private final By deleteSurely = By.xpath("//*[@id=\"delete-account-btn\"]");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    /*******************************************************************************************************************
                                   Egyszerű metódus, ami feltölti a name inputot.
     ******************************************************************************************************************/
    public void fillName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    /*******************************************************************************************************************
                                   Egyszerű metódus, ami feltölti a bio inputot.
     ******************************************************************************************************************/
    public void fillBio(String bio) {
        driver.findElement(this.bio).sendKeys(bio);
    }

    /*******************************************************************************************************************
                                   Egyszerű metódus, ami feltölti a phone inputot.
     ******************************************************************************************************************/
    public void fillPhone(String phone) {
        driver.findElement(this.phone).sendKeys(phone);
    }

    /*******************************************************************************************************************
                                Egyszerű metódus, ami rákattint a save profile gombra.
     ******************************************************************************************************************/
    public void clickOnSave() {
        driver.findElement(save).click();
    }

    /*******************************************************************************************************************
                               Egyszerű metódus, ami rákattint a delete account gombra.
     ******************************************************************************************************************/
    public void clickOnDelete() {
        driver.findElement(delete).click();
    }

    /*******************************************************************************************************************
                             Egyszerű metódus, ami rákattint a delete account surely gombra.
     ******************************************************************************************************************/
    public void clickOnDeleteSurely() {
        driver.findElement(deleteSurely).click();
    }

    /*******************************************************************************************************************
                             Metódus, ami feltölti az összes inputot és a mentésre is rákattint.
     ******************************************************************************************************************/
    public void fillAll(String name, String bio, String phone) {
        fillName(name);
        fillBio(bio);
        fillPhone(phone);
        clickOnSave();
    }

    /*******************************************************************************************************************
                              Metódus, ami egyszerre törli az összes input aktuális tartalmát.
     ******************************************************************************************************************/
    public void clearAll() {
        driver.findElement(name).clear();
        driver.findElement(bio).clear();
        driver.findElement(phone).clear();
    }

    /*******************************************************************************************************************
                              Metódus, ami a kétlépcsős account törlést egyszerre végrehajtja.
     ******************************************************************************************************************/
    public void deleteAtOnce() {
        clickOnDelete();
        clickOnDeleteSurely();
    }

}
