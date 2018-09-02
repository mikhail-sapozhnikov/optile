package net.optile.dropboxtests;

import net.optile.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        initDriver();
    }


    @Parameters({"login", "pass"})
    @Test
    public void dropboxLogin(String login, String pass) {

        // Login

        openDropboxPage();
        clickOn(loginPage.btnSignIn);
        enterCredentials(login, pass);
        clickOn(loginPage.btnLogin);
        waitUntilUrlIsChangedTo("https://www.dropbox.com/h");

        // Logout

        clickOn(mainPage.btnAvatar);
        clickOn(mainPage.btnLogout);
        waitUntilUrlIsChangedTo("https://www.dropbox.com/login?src=logout");

    }


    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

}
