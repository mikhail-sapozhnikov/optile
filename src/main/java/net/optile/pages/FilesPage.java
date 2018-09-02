package net.optile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FilesPage extends BasePage {

    @FindBy(className = "action-upload")
    public WebElement btnUpload;
    @FindBy(xpath = "//div[@class='mc-popover-content-scroller']/button[1]")
    public WebElement btnUploadFiles;
    @FindBy(className = "uee-AppActionsView-SecondaryActionMenu-text-new-folder")
    public WebElement btnNewFolder;
    @FindBy(className = "uee-AppActionsView-SecondaryActionMenu-text-delete")
    public WebElement btnDelete;
    @FindBy(xpath = "//span[text()='Delete']")
    public WebElement btnDeleteConfirmation;


    public FilesPage(WebDriver driver) {
        super(driver);
    }

}
