import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
    private final WebDriver driver;
    private WebDriverWait wait;
    private final By name = By.xpath("//*[@id=\"contact-form\"]/div[1]/div[1]/input");
    private final By email = By.xpath("//*[@id=\"contact-form\"]/div[1]/div[2]/input");
    private final By message = By.xpath("//*[@id=\"message\"]");
    private final By checkbox = By.xpath("//*[@id=\"aggrement\"]");
    private final By button = By.xpath("//*[@id=\"contact-form-button\"]");
    private final By status = By.xpath("//*[@id=\"contact-form-status\"]");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillName(String input) {
        driver.findElement(name).sendKeys(input);
    }
    public void fillEmail(String input) {
        driver.findElement(email).sendKeys(input);
    }
    public void fillMessage(String input) {
        driver.findElement(message).sendKeys(input);
    }
    public void clickOnCheckbox() {
        driver.findElement(checkbox).click();
    }
    public void clickOnButton() {
        driver.findElement(button).click();
    }
    public boolean isThereStatusMessage() {
        try {
            wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(status));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
