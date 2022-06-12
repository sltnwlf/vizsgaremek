import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RecentsArticlePage {

    WebDriver driver;
    WebDriverWait wait;
    private final By posts = By.xpath("//*[@id=\"content\"]/section/div/div/div");
    private final By nextButton = By.xpath("//*[@id=\"content\"]/section/div/div/nav/ul/li[3]/a");

    public RecentsArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    public int numberOfPosts() {
        int num = 0;

        List<WebElement> postList = driver.findElements(posts);
        num = postList.size();

        return num;
    }

    public boolean isThereNextButton() {
        try {
            wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void clickOnNextButton() {
        if (isThereNextButton()) {
            driver.findElement(nextButton).click();
        }
    }

}
