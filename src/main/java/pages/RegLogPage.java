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
    private final By acceptTermsAndConditionsButton = By.xpath("//*[@id=\"terms-and-conditions-button\"]");
    private final By closeTermsAndConditionsButton = By.xpath("//*[@id=\"overlay\"]/div/div[1]");
    private final By termsAndConditionsWindow = By.xpath("//*[@id=\"overlay\"]/div");
    private final By registerFormButton = By.xpath("(//*[@id=\"register-form-button\"])[1]");
    private final By registerUsername = By.xpath("//*[@id=\"register-username\"]");
    private final By registerPassword = By.xpath("//*[@id=\"register-password\"]");
    private final By registerEmail = By.xpath("//*[@id=\"register-email\"]");
    private final By registerDescription = By.xpath("//*[@id=\"register-description\"]");
    private final By registerButton = By.xpath("//*[@id=\"register\"]/form/div[6]/button");
    private final By registerAlert = By.xpath("//*[@id=\"register-alert\"]");
    private final By loginFormButton = By.xpath("//*[@id=\"register\"]/Button[@id=\"login-form-button\"]");
    private final By loginUsername = By.xpath("//*[@id=\"email\"]");
    private final By loginPassword = By.xpath("//*[@id=\"password\"]");
    private final By loginButton = By.xpath("//*[@id=\"login\"]/form/div[4]/button");
    private final By regLogWindow = By.xpath("//*[@id=\"login\"]");

    public RegLogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnTermsAndConditionsAccept() {
        driver.findElement(acceptTermsAndConditionsButton).click();
    }
    public void clickOnTermsAndConditionsIgnore() {
        driver.findElement(closeTermsAndConditionsButton).click();
    }
    public boolean isThereTermsAndConditionsWindow() {
        try {
            wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(termsAndConditionsWindow));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void registration(String regUsername,
                             String regPassword,
                             String regEmail,
                             String regDescription) {
        driver.findElement(registerFormButton).click();
        driver.findElement(registerUsername).sendKeys(regUsername);
        driver.findElement(registerPassword).sendKeys(regPassword);
        driver.findElement(registerEmail).sendKeys(regEmail);
        driver.findElement(registerDescription).sendKeys(regDescription);
        driver.findElement(registerButton).click();
    }
    public boolean isThereRegisterAlertMessage() {
        try {
            wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(registerAlert));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public String getRegisterAlert() {
        return driver.findElement(registerAlert).getText();
    }
    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }
    public void login(String logUsername, String logPassword) {
        driver.findElement(loginUsername).sendKeys(logUsername);
        driver.findElement(loginPassword).sendKeys(logPassword);
        driver.findElement(loginButton).click();
    }
    public void registrationAndLogin(String regUsername,
                                            String regPassword,
                                            String regEmail,
                                            String regDescription,
                                            String logUsername,
                                            String logPassword) {
        driver.findElement(registerFormButton).click();
        driver.findElement(registerUsername).sendKeys(regUsername);
        driver.findElement(registerPassword).sendKeys(regPassword);
        driver.findElement(registerEmail).sendKeys(regEmail);
        driver.findElement(registerDescription).sendKeys(regDescription);
        driver.findElement(registerButton).click();
        driver.findElement(loginFormButton).click();
        driver.findElement(loginUsername).sendKeys(logUsername);
        driver.findElement(loginPassword).sendKeys(logPassword);
        driver.findElement(loginButton).click();
    }
    public boolean isThereLoginWindow() {
        try {
            wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(regLogWindow));
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
            reader = new BufferedReader(new FileReader("RegisterTestData.txt"));

            ArrayList<By> inputFieldList = new ArrayList<>();
            inputFieldList.add(registerUsername);
            inputFieldList.add(registerPassword);
            inputFieldList.add(registerEmail);
            inputFieldList.add(registerDescription);

            ArrayList<String> lineList = new ArrayList<>();
            String line = "";
            while (line != null) {
                line = reader.readLine();
                lineList.add(line);
            }
            lineList.remove(lineList.size()-1);

            int i = 0;
            while (i < lineList.size()) {
                driver.findElement(registerFormButton).click();
                for (By by : inputFieldList) {
                    driver.findElement(by).sendKeys(lineList.get(i));
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
    public void regLogRepeatedlyAndContinuouslyFromDatasource() {
        Utils u = new Utils(driver);
        BufferedReader registerReader;
        try {
            registerReader = new BufferedReader(new FileReader("RegisterTestData.txt"));

            ArrayList<By> inputFieldList = new ArrayList<>();
            inputFieldList.add(registerUsername);
            inputFieldList.add(registerPassword);
            inputFieldList.add(registerEmail);
            inputFieldList.add(registerDescription);

            ArrayList<String> lineList = new ArrayList<>();
            String line = "";
            while (line != null) {
                line = registerReader.readLine();
                lineList.add(line);
            }
            lineList.remove(lineList.size()-1);

            int i = 0;
            while (i < lineList.size()) {
                driver.findElement(registerFormButton).click();
                for (By by : inputFieldList) {
                    driver.findElement(by).sendKeys(lineList.get(i));
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
            loginReader = new BufferedReader(new FileReader("LoginTestData.txt"));

            ArrayList<By> inputFieldList = new ArrayList<>();
            inputFieldList.add(loginUsername);
            inputFieldList.add(loginPassword);

            ArrayList<String> lineList = new ArrayList<>();
            String line = "";
            while (line != null) {
                line = loginReader.readLine();
                lineList.add(line);
            }
            lineList.remove(lineList.size()-1);

            int i = 0;
            while (i < lineList.size()) {
                for (By by : inputFieldList) {
                    driver.findElement(by).sendKeys(lineList.get(i));
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