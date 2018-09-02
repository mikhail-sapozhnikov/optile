package net.optile.dropboxtests;

import net.optile.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateFolderTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        initDriver();
    }

    @Parameters({"login", "pass"})
    @Test
    public void createFolder(String login, String pass) {

        loginToDropbox(login, pass);

        clickOn(mainPage.menuBtnFiles);
        clickOn(filesPage.btnNewFolder);
        enterFolderNameAndCheckIfCreated();

    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

}
