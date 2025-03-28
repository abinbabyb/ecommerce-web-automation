package sidcofoods;

import sidcofoods.Pages.LoginPage;
import sidcofoods.Pages.HomePage;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;

	
    @Test(priority = 1, description = "Verify Logout after successful login")
    public void testLogout() {
    	loginPage = new LoginPage(driver, wait);
       // driver.get("https://www.sidcofoods.ae/"); 

      //close popup
        loginPage.closePopup();
        
        //click signIn
        loginPage.clickSignIn();
    	
    	
        // login with valid credentials
        homePage = loginPage.loginWithValidCredentials("abinbaby1221@gmail.com", "Abin2123@");

		/*
		 * Alert alert = driver.switchTo().alert(); alert.accept();
		 */
        // verify the user is logged in
        String welcomeMessage = homePage.getWelcomeMessage();
        Assert.assertTrue(welcomeMessage.contains("Welcome"), "Login was not successful.");
        //System.out.println(welcomeMessage);

        //go to the account page
        homePage.goToAccount();

        //click the logout button
        homePage.logout();
        
        //popup login button
        homePage.confirmLogout();

        //verify the user is redirected to the login page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("sidcofoods.ae"), "User was not redirected to the home page after logout.");
    }
}