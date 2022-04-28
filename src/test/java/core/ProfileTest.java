package core;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PeoplePage;
import pages.ProfilePage;

public class ProfileTest extends BaseTest {

    @Test(dataProvider = "getCredentialsFromJson", dataProviderClass = TestDataProvider.class)
    public void testProfileName(final String username, final String password, final String expectedFullName) {
        //Given
        openIceHrmAppInWeb();
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        DashboardPage dashboardPage = loginPage.clickLogin();
        //When
        ProfilePage profilePage = dashboardPage.clickViewProfile();
        String profileNameInPage = profilePage.getProfileName();
        //Then
        Assert.assertEquals(profileNameInPage, expectedFullName);
    }

    @Test(dataProvider = "getAdminCredentialsFromJson", dataProviderClass = TestDataProvider.class)
    public void addEmployee(final String username, final String password) throws InterruptedException {
        //Given
        openIceHrmAppInWeb();
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        DashboardPage dashboardPage = loginPage.clickLogin();
        //When
        PeoplePage peoplePage = dashboardPage.clickViewPeople();
        //peoplePage.clickAddEmployee();
        peoplePage.addAllEmployeeDetails();
        //Then
    }

}
