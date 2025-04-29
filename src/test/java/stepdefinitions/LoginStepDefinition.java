package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;


public class LoginStepDefinition {

    private WebDriver driver = DriverManager.getDriver("CHROME");
    LoginPage loginPage = new LoginPage(driver);

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("user enters the {string} in the username field")
    public void userEntersTheUsernameInTheUsernameField(String username) {
        loginPage.enterUsername(username);
    }

    @And("user enters the password {string} in the password field")
    public void userEntersThePasswordInThePasswordField(String password) {
        loginPage.enterPassword(password);
    }

    @When("user clicks on the login button")
    public void userClicksOnTheLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("user lands on the dashboard page")
    public void userLandsOnTheDashboardPage() {
        System.out.println("Landed on the Dashboard Page");
    }
}