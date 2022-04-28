package pages;

import core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObject {

    By usernameTextBox = By.id("username");
    By passwordTextBox = By.id("password");
    By loginButton = By.xpath("//button[contains(text(),'Log in ')]");
//    By cancel = By.xpath("//*[@id=\"verifyModel\"]/div/div/div[2]/form/div[2]/div[1]/button[2]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        enter(username, usernameTextBox);
    }

    public void enterPassword(String password) {
        enter(password, passwordTextBox);
    }

    public DashboardPage clickLogin() {
        click(loginButton);
//        click(cancel);
        return new DashboardPage(webDriver);
    }
}
