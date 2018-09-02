package net.optile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(id = "sign-up-in")
    public WebElement btnSignIn;
    @FindBy(name = "login_email")
    private WebElement fieldLogin;
    @FindBy(name = "login_password")
    private WebElement fieldPassword;
    @FindBy(className = "signin-text")
    public WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void enterLogin(String login) {
        fieldLogin.sendKeys(login);
    }

    public void enterPassword(String pass) {
        fieldPassword.sendKeys(pass);
    }

}
