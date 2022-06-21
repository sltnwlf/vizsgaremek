package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    protected WebDriver driver;
    private final By nameInput = By.xpath("//*[@id=\"name\"]");
    private final By bioInput = By.xpath("//*[@id=\"bio\"]");
    private final By phoneInput = By.xpath("//*[@id=\"phone-number\"]");
    private final By saveProfileButton = By.xpath("//*[@id=\"edit-profile\"]/form/div[5]/button");
    private final By deleteAccount = By.xpath("//*[@id=\"edit-profile\"]/form/div[6]/button");
    private final By deleteAccountSurely = By.xpath("//*[@id=\"delete-account-btn\"]");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void nameInputFiller(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }
    public void bioInputFiller(String bio) {
        driver.findElement(bioInput).sendKeys(bio);
    }
    public void phoneInputFiller(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }
    public void clickOnSaveButton() {
        driver.findElement(saveProfileButton).click();
    }
    public void clickOnDeleteAccount() {
        driver.findElement(deleteAccount).click();
    }
    public void clickOnDeleteAccountSurely() {
        driver.findElement(deleteAccountSurely).click();
    }
    public void profileInputFiller(String name, String bio, String phone) {
        nameInputFiller(name);
        bioInputFiller(bio);
        phoneInputFiller(phone);
        clickOnSaveButton();
    }
    public void deleteAccount() {
        clickOnDeleteAccount();
        clickOnDeleteAccountSurely();
    }

}
