package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class Utils {
    protected WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }
    public void goBack() {
        driver.navigate().back();
    }
    public void goForward() {
        driver.navigate().forward();
    }
    public void refresh() {
        driver.navigate().refresh();
    }
    public void createNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
    public void sleep(int timeInMillis) throws InterruptedException {
        Thread.sleep(timeInMillis);
    }
    public String[] readFromFile(String fileName) {
        BufferedReader reader;
        ArrayList<String> lineList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while (line != null) {
                line = reader.readLine();
                lineList.add(line);
            }
            lineList.remove(lineList.size()-1);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] resultStrArr = new String[lineList.size()];
        for (int i = 0; i < lineList.size(); i++) {
            resultStrArr[i] = lineList.get(i);
        }
        return resultStrArr;
    }
    public Set<Cookie> getCookies() {
        return driver.manage().getCookies();
    }

}
