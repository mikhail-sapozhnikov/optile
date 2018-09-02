package net.optile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SettingsPage extends BasePage {

    @FindBy(id = "general")
    public WebElement btnGeneral;
    @FindBy(xpath = "//div[3]/div/button/span/span[text()='Edit']")
    public WebElement btnEditName;
    @FindBy(name = "fname")
    public WebElement fieldName;
    @FindBy(name = "lname")
    public WebElement fieldSurname;
    @FindBy(xpath = "//button[text()='Change name']")
    public WebElement btnChangeName;


    public SettingsPage(WebDriver driver) {
        super(driver);
    }
}
