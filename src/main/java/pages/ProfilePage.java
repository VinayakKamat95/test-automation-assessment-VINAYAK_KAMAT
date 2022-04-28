package pages;

import core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends PageObject {

    By profileName = By.xpath("//*[@id=\"Employee\"]/div[1]/div/div/div[2]/div/div[2]/div/div[1]/h4");
    By employeeNumber = By.xpath("//table/tbody/tr[1]/td");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getProfileName() {
        return getText(profileName);
    }

    public String getEmployeeNumber() {return getText(employeeNumber);}
}
