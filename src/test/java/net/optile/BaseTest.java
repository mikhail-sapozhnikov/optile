package net.optile;


import net.optile.pages.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;

public class BaseTest {

    private static WebDriver driver;
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected FilesPage filesPage;
    protected SettingsPage settingsPage;
    private String baseUrl = "https://www.dropbox.com/";
    private BasePage basePage = new BasePage(driver);

    protected void openDropboxPage() {
        driver.get(baseUrl);
    }

    protected void initDriver() {
        driver = basePage.getDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        filesPage = new FilesPage(driver);
        settingsPage = new SettingsPage(driver);
    }

    protected void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void sleep(int millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    protected void clickOn(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }

    protected void waitUntilVisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    protected void waitUntilUrlIsChangedTo(String newUrl) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(newUrl));

    }

    protected void enterCredentials(String login, String pass) {

        loginPage.enterLogin(login);
        loginPage.enterPassword(pass);

    }

    protected void loginToDropbox(String login, String pass) {

        openDropboxPage();
        clickOn(loginPage.btnSignIn);
        enterCredentials(login, pass);
        clickOn(loginPage.btnLogin);
        waitUntilUrlIsChangedTo("https://www.dropbox.com/h");

    }

    protected void enterFilePathInUploadFileDialog(String filePath) throws AWTException {

        Robot robot = new Robot();

        robot.setAutoDelay(2000);
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        robot.setAutoDelay(1000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.setAutoDelay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    protected void uploadFileWithPath(String filePath) {

        clickOn(filesPage.btnUploadFiles);
        try {
            enterFilePathInUploadFileDialog(filePath);
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    protected void checkFileUploadedSuccessfully(String filePath) {

        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='" + getFileNameFromPath(filePath) + "']")).isDisplayed());

    }

    protected void enterFolderNameAndCheckIfCreated() {

        Random rand = new Random();
        int randomNumber = rand.nextInt(10000);

        String folderName = "Folder_" + randomNumber;
        driver.switchTo().activeElement().sendKeys(folderName);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);

        waitUntilVisible(driver.findElement(By.xpath("//span[text()='" + folderName + "']")));

    }

    protected void enterNewNameAndCheckIfChanged() {

        String randomName = RandomStringUtils.random(5, true, false);
        String randomSurname = RandomStringUtils.random(8, true, false);

        settingsPage.fieldName.clear();
        settingsPage.fieldName.sendKeys(randomName);
        settingsPage.fieldSurname.clear();
        settingsPage.fieldSurname.sendKeys(randomSurname);

        clickOn(settingsPage.btnChangeName);

        waitUntilVisible(driver.findElement(By.xpath("//span[text()='" + randomName + " " + randomSurname + "']")));

    }

    protected String getFileNameFromPath(String filePath) {

        File f = new File(filePath);
        return f.getName();

    }

}
