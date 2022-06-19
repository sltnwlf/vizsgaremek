package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
    private final WebDriver driver;
    private final By nameInput = By.xpath("//*[@id=\"contact-form\"]/div[1]/div[1]/input");
    private final By emailInput = By.xpath("//*[@id=\"contact-form\"]/div[1]/div[2]/input");
    private final By messageInput = By.xpath("//*[@id=\"message\"]");
    private final By agreeCheckbox = By.xpath("//*[@id=\"aggrement\"]");
    private final By sendMessageButton = By.xpath("//*[@id=\"contact-form-button\"]");
    private final By statusMessage = By.xpath("//*[@id=\"contact-form-status\"]");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillName(String input) {
        driver.findElement(nameInput).sendKeys(input);
    }
    public void fillEmail(String input) {
        driver.findElement(emailInput).sendKeys(input);
    }
    public void fillMessage(String input) {
        driver.findElement(messageInput).sendKeys(input);
    }
    public void fillForm(String name, String email, String message) {
        fillName(name);
        fillEmail(email);
        fillMessage(message);
    }
    public void clickOnCheckbox() {
        driver.findElement(agreeCheckbox).click();
    }
    public void clickOnSendButton() {
        driver.findElement(sendMessageButton).click();
    }
    public boolean isThereStatusMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(statusMessage));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}