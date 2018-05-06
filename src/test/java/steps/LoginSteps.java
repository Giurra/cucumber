package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utils.DriverUtils;

import java.util.logging.Logger;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginSteps {
    private WebDriver driver;
    Logger log = Logger.getLogger(LoginSteps.class.getName());

    @Before
    public void startBrowser() {
        driver = DriverUtils.getDriver();
        log.info("Creating browser instance.");
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
            scenario.write("Scenario failed");
            log.info("Scenario failed. Saving the screenshot.");
        } else {
            scenario.write("Scenario passed");
            log.info("Scenario passed.");
        }

        driver.quit();
    }

    @Given("^That user opens \"([^\"]*)\"$")
    public void that_user_opens(String url) {
        driver.get(url);
        log.info("Opening the page.");
    }

    @And("^Clicks Login$")
    public void clicksLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginButton.click();
        log.info("Clicking 'Log In' button.");
    }

    @And("^User enters valid username (.*)$")
    public void userEntersValidUsernameUsername(String username) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailInput.sendKeys(username);
        log.info("Entering the email.");
    }

    @And("^User enters valid password (.*)$")
    public void userEntersValidPasswordPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.passwordInput.sendKeys(password);
        log.info("Entering the password.");
    }

    @When("^User clicks submit$")
    public void user_clicks_submit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSubmitButton.click();
        log.info("Clicking 'Log In' submit button.");
    }

    @Then("^User should be logged in$")
    public void user_should_be_logged_in() {
        LoginPage loginPage = new LoginPage(driver);
        (new WebDriverWait(driver, 30))
                .until(presenceOfElementLocated(By.cssSelector("[data-test-name='footer-logout']")));
        log.info("Verifying if the user is logged in.");
        Assert.assertTrue(loginPage.logoutButton.isDisplayed());
    }

    @And("^User enters invalid username (.*)$")
    public void userEntersInvalidUsernameUsername(String invalidUsername) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailInput.sendKeys(invalidUsername);
        log.info("Entering the invalid username.");
    }

    @And("^User enters invalid password (.*)$")
    public void userEntersInvalidPasswordPassword(String invalidPassword) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.passwordInput.sendKeys(invalidPassword);
        log.info("Entering the invalid password.");
    }

    @Then("^User should still see login popup$")
    public void userShouldStillSeeLoginPopup() {
        LoginPage loginPage = new LoginPage(driver);
        log.info("Verifying if the user is not logged in.");
        Assert.assertEquals(0, loginPage.logoutButtonList.size());
    }

}
