package net.optile.dropboxtests;

import net.optile.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UploadFileTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        initDriver();
    }

    @Parameters({"login", "pass", "filePath", "fileName"})
    @Test
    public void uploadFile(String login, String pass, String filePath, String fileName) {

        loginToDropbox(login, pass);

        clickOn(mainPage.menuBtnFiles);
        clickOn(filesPage.btnUpload);
        uploadFileWithPath(filePath);
        checkFileUploadedSuccessfully(fileName);
        clickOn(filesPage.btnDelete);
        clickOn(filesPage.btnDeleteConfirmation);

    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

}
