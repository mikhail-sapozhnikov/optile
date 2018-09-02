package net.optile.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(className = "mc-avatar-image")
    public WebElement btnAvatar;
    @FindBy(xpath = "//a[contains(@href,'logout')]")
    public WebElement btnLogout;
    @FindBy(id = "files")
    public WebElement menuBtnFiles;
    @FindBy(xpath = "//a[text()='Settings']")
    public WebElement btnSettings;


    public MainPage(WebDriver driver) {
        super(driver);
    }

}
