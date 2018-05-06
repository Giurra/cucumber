package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-test-name='login-button']")
    public WebElement loginButton;

    @FindBy(css = "[type='email']")
    public WebElement emailInput;

    @FindBy(css = "[type='password']")
    public WebElement passwordInput;

    @FindBy(css = "[data-test-name='EnabledLoginButton']")
    public WebElement loginSubmitButton;

    @FindBy(css = "[data-test-name='footer-logout']")
    public WebElement logoutButton;

    @FindBy(css = "[data-test-name='footer-logout']")
    public List<WebElement> logoutButtonList;

}
