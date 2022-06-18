package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RegLogPage {
    private final WebDriver driver;
    private WebDriverWait wait;
    private final By acceptButton = By.xpath("//*[@id=\"terms-and-conditions-button\"]");
    private final By closeButton = By.xpath("//*[@id=\"overlay\"]/div/div[1]");
    private final By popupWindow = By.xpath("//*[@id=\"overlay\"]/div");
    private final By registerTab = By.xpath("(//*[@id=\"register-form-button\"])[1]");
    private final By registerUsername = By.xpath("//*[@id=\"register-username\"]");
    private final By registerPassword = By.xpath("//*[@id=\"register-password\"]");
    private final By registerEmail = By.xpath("//*[@id=\"register-email\"]");
    private final By registerDescription = By.xpath("//*[@id=\"register-description\"]");
    private final By registerButton = By.xpath("//*[@id=\"register\"]/form/div[6]/button");
    private final By registerAlertMessage = By.xpath("//*[@id=\"register-alert\"]");
    private final By loginTab = By.xpath("//*[@id=\"register\"]/Button[@id=\"login-form-button\"]");
    private final By loginUsername = By.xpath("//*[@id=\"email\"]");
    private final By loginPassword = By.xpath("//*[@id=\"password\"]");
    private final By loginButton = By.xpath("//*[@id=\"login\"]/form/div[4]/button");
    private final By loginWindow = By.xpath("//*[@id=\"login\"]");

    public RegLogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnTermsAndConditionsAccept() {
        driver.findElement(acceptButton).click();
    }
    public void clickOnTermsAndConditionsIgnore() {
        driver.findElement(closeButton).click();
    }
    public boolean isThereTermsAndConditionsWindow() {
        try {
            wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(popupWindow));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void clickOnRegisterTab() {
        driver.findElement(registerTab).click();
    }
    public void fillRegisterUsername(String regUsername) {
        driver.findElement(registerUsername).sendKeys(regUsername);
    }
    public void fillRegisterPassword(String regPassword) {
        driver.findElement(registerPassword).sendKeys(regPassword);
    }
    public void fillRegisterEmail(String regEmail) {
        driver.findElement(registerEmail).sendKeys(regEmail);
    }
    public void fillRegisterDescription(String regDescription) {
        driver.findElement(registerDescription).sendKeys(regDescription);
    }
    public void registration(String regUsername,
                             String regPassword,
                             String regEmail,
                             String regDescription) {
        driver.findElement(registerTab).click();
        driver.findElement(registerUsername).sendKeys(regUsername);
        driver.findElement(registerPassword).sendKeys(regPassword);
        driver.findElement(registerEmail).sendKeys(regEmail);
        driver.findElement(registerDescription).sendKeys(regDescription);
        driver.findElement(registerButton).click();
    }
    public boolean isThereRegisterAlertMessage() {
        try {
            wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(registerAlertMessage));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public String getRegisterAlertMessage() {
        return driver.findElement(registerAlertMessage).getText();
    }
    public void fillLoginUsername(String logUsername) {
        driver.findElement(registerUsername).sendKeys(logUsername);
    }
    public void fillLoginPassword(String logPassword) {
        driver.findElement(registerPassword).sendKeys(logPassword);
    }
    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }
    public LandingPage login(String logUsername, String logPassword) {
        driver.findElement(loginUsername).sendKeys(logUsername);
        driver.findElement(loginPassword).sendKeys(logPassword);
        driver.findElement(loginButton).click();
        return new LandingPage(driver);
    }
    public LandingPage registrationAndLogin(String regUsername,
                                            String regPassword,
                                            String regEmail,
                                            String regDescription,
                                            String logUsername,
                                            String logPassword) {
        driver.findElement(registerTab).click();
        driver.findElement(registerUsername).sendKeys(regUsername);
        driver.findElement(registerPassword).sendKeys(regPassword);
        driver.findElement(registerEmail).sendKeys(regEmail);
        driver.findElement(registerDescription).sendKeys(regDescription);
        driver.findElement(registerButton).click();
        driver.findElement(loginTab).click();
        driver.findElement(loginUsername).sendKeys(logUsername);
        driver.findElement(loginPassword).sendKeys(logPassword);
        driver.findElement(loginButton).click();
        return new LandingPage(driver);
    }
    public boolean isThereLoginWindow() {
        try {
            wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginWindow));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void registrationSequentiallyAndContinuouslyFromDatasource() {
        Utils u = new Utils(driver);
        BufferedReader reader;
        try {
            ArrayList<By> inputFieldList = new ArrayList<>();
            inputFieldList.add(registerUsername);
            inputFieldList.add(registerPassword);
            inputFieldList.add(registerEmail);
            inputFieldList.add(registerDescription);

            reader = new BufferedReader(new FileReader("RegisterTestData.txt"));
            String line = "";
            ArrayList<String> lineList = new ArrayList<>();
            while (line != null) {
                line = reader.readLine();
                lineList.add(line);
            }

            lineList.remove(lineList.size()-1);
            int listLength = lineList.size();
            int i = 0;
            while (i < listLength) {
                driver.findElement(registerTab).click();
                for (int j = 0; j < inputFieldList.size(); j++) {
                    driver.findElement(inputFieldList.get(j)).sendKeys(lineList.get(i));
                    i++;
                }
                driver.findElement(registerButton).click();
                u.refresh();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        u.refresh();
    }
    public void loginSequentiallyAndContinuouslyFromDatasource() {
        Utils u = new Utils(driver);
        BufferedReader reader;
        try {
            ArrayList<By> inputFieldList = new ArrayList<>();
            inputFieldList.add(loginUsername);
            inputFieldList.add(loginPassword);

            reader = new BufferedReader(new FileReader("LoginTestData.txt"));
            String line = "";
            ArrayList<String> lineList = new ArrayList<>();
            while (line != null) {
                line = reader.readLine();
                lineList.add(line);
            }

            lineList.remove(lineList.size()-1);
            int listLength = lineList.size();
            int i = 0;
            while (i < listLength) {
                for (int j = 0; j < inputFieldList.size(); j++) {
                    driver.findElement(inputFieldList.get(j)).sendKeys(lineList.get(i));
                    i++;
                }
                clickOnLoginButton();
                LandingPage landPage = new LandingPage(driver);
                landPage.clickOnLogoutButton();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        u.refresh();
    }
    public void regLogRepeatedlyAndContinuouslyFromDatasource() {
        Utils u = new Utils(driver);
        BufferedReader registerReader;
        try {
            ArrayList<By> inputFieldList = new ArrayList<>();
            inputFieldList.add(registerUsername);
            inputFieldList.add(registerPassword);
            inputFieldList.add(registerEmail);
            inputFieldList.add(registerDescription);

            registerReader = new BufferedReader(new FileReader("RegisterTestData.txt"));
            String line = "";
            ArrayList<String> lineList = new ArrayList<>();
            while (line != null) {
                line = registerReader.readLine();
                lineList.add(line);
            }

            lineList.remove(lineList.size()-1);
            int listLength = lineList.size();
            int i = 0;
            while (i < listLength) {
                driver.findElement(registerTab).click();
                for (int j = 0; j < inputFieldList.size(); j++) {
                    driver.findElement(inputFieldList.get(j)).sendKeys(lineList.get(i));
                    i++;
                }
                driver.findElement(registerButton).click();
                u.refresh();
            }
            registerReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        u.refresh();
        BufferedReader loginReader;
        try {
            ArrayList<By> inputFieldList = new ArrayList<>();
            inputFieldList.add(loginUsername);
            inputFieldList.add(loginPassword);

            loginReader = new BufferedReader(new FileReader("LoginTestData.txt"));
            String line = "";
            ArrayList<String> lineList = new ArrayList<>();
            while (line != null) {
                line = loginReader.readLine();
                lineList.add(line);
            }

            lineList.remove(lineList.size()-1);
            int listLength = lineList.size();
            int i = 0;
            while (i < listLength) {
                for (int j = 0; j < inputFieldList.size(); j++) {
                    driver.findElement(inputFieldList.get(j)).sendKeys(lineList.get(i));
                    i++;
                }
                clickOnLoginButton();
                LandingPage landPage = new LandingPage(driver);
                landPage.clickOnLogoutButton();
            }
            loginReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        u.refresh();
    }

}