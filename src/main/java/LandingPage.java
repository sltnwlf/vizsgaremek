import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    WebDriver driver;

    private final By portioLogo = By.xpath("/html/body/nav/div/a/img");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnPortioLogo() {
        driver.findElement(portioLogo).click();
    }
}
