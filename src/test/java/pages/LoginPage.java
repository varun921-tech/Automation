package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(name = "login")
    WebElement loginBtn;


    public void enterUsername(String username){
        usernameField.sendKeys(username);
    }

    public void enterPassword(String pwd){
        passwordField.sendKeys(pwd);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

}
