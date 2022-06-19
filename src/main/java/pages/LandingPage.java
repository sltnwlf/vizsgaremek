package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private final WebDriver driver;
    private final By seeAllPostButton = By.xpath("//*[@id=\"blog\"]/div[2]/div[1]/div[2]/div/a");
    private final By logoutButton = By.xpath("//*[@id=\"logout-link\"]/a");
    private final By getInTouchButton = By.xpath("//*[@id=\"contact\"]/div[2]/div[1]/div/div/div[4]/a");
    private final By profileButton = By.xpath("//*[@id=\"profile-btn\"]");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSeeAllPostButton() {
        driver.findElement(seeAllPostButton).click();
    }
    public void clickOnLogoutButton() {
        driver.findElement(logoutButton).click();
    }
    public void clickOnGetInTouchButton() {
        driver.findElement(getInTouchButton).click();
    }
    public void clickOnProfileButton() {
        driver.findElement(profileButton).click();
    }

}