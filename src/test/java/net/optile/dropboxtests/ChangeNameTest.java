package net.optile.dropboxtests;

import net.optile.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ChangeNameTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        initDriver();
    }

    @Parameters({"login", "pass"})
    @Test
    public void changeName(String login, String pass) {

        loginToDropbox(login, pass);

        clickOn(mainPage.btnAvatar);
        clickOn(mainPage.btnSettings);
        clickOn(settingsPage.btnGeneral);
        clickOn(settingsPage.btnEditName);
        enterNewNameAndCheckIfChanged();

    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
