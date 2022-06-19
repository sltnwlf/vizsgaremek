package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ArticlePage {
    private final WebDriver driver;
    private final By posts = By.xpath("//*[@id=\"content\"]/section/div/div/div");
    private final By nextButton = By.xpath("//*[@id=\"content\"]/section/div/div/nav/ul/li[3]/a");
    private final By postLinks = By.xpath("//a[starts-with(@class, \"text-dark\")]");
    private int actual = 0;

    public ArticlePage(WebDriver driver) {
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
            WebDriverWait wait = new WebDriverWait(driver, 5);
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
    public String[] listPostTitlesOnFirstPage() {
        List<WebElement> postLinkList = driver.findElements(postLinks);
        String[] titleList = new String[postLinkList.size()];
        for (int i = 0; i < postLinkList.size(); i++) {
            String title = postLinkList.get(i).getText();
            titleList[i] = title;
        }
        return titleList;
    }
    public int postCounter() {
        while (true) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            actual += numberOfPosts();
            if (!isThereNextButton()) {
                break;
            }
            clickOnNextButton();
        }
        return actual;
    }

    public ArrayList<String> listPostTitlesOnAllPage() {
        List<WebElement> postLinkList;
        ArrayList<String> titleList = new ArrayList<>();
        while (isThereNextButton()) {
            postLinkList = driver.findElements(postLinks);
            for (WebElement postLink : postLinkList) {
                titleList.add(postLink.getText());
            }
            clickOnNextButton();
        }
        postLinkList = driver.findElements(postLinks);
        for (WebElement postLink : postLinkList) {
            titleList.add(postLink.getText());
        }
        return titleList;
    }
    public void savingPostTitlesIntoFile() {
        try {
            FileWriter writer = new FileWriter("PostTitles.txt");
            BufferedWriter out = new BufferedWriter(writer);
            ArrayList<String> postTitles = listPostTitlesOnAllPage();
            int i = 0;
            while (i < postTitles.size()) {
                out.write(postTitles.get(i) + "\n");
                i++;
            }
            out.close();
        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }

}