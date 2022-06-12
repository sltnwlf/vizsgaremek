import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LandingPage {

    WebDriver driver;
    WebDriverWait wait;

    private final By portioLogo = By.xpath("/html/body/nav/div/a/img");
    private final By blogButton = By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[7]/a");
    private final By seeAllPostButton = By.xpath("//*[@id=\"blog\"]/div[2]/div[1]/div[2]/div/a");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnPortioLogo() {
        driver.findElement(portioLogo).click();
    }

    public void clickOnBlogButton() {
        driver.findElement(blogButton).click();
    }

    public void clickOnSeeAllPostButton() {
        driver.findElement(seeAllPostButton).click();
    }
}
