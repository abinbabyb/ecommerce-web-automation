package sidcofoods;

import sidcofoods.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @Test(priority = 3, description = " Verify Login with Valid Credentials")
    public void testValidLogin() {
    	loginPage = new LoginPage(driver, wait);
        //driver.get("https://www.sidcofoods.ae/"); 

        //close popup
        loginPage.closePopup();
        
        //click signIn
        loginPage.clickSignIn();

        //enter valid credentials
        loginPage.enterUsername("abinbaby1221@gmail.com");
        loginPage.enterPassword("Abin2123@");
        loginPage.clickLoginButton();

        // welcome message
        String welcomeMessage = loginPage.getWelcomeMessage();
        Assert.assertTrue(welcomeMessage.contains("Welcome"), "Login was not successful.");
    }

    @Test(priority = 2, description = " Verify Login with Invalid Credentials")
    public void testInvalidLogin() {
    	loginPage = new LoginPage(driver, wait);
        //driver.get("https://www.sidcofoods.ae/"); // Navigate to the website

        //popup close
        loginPage.closePopup();
        
        //click on sign in
        loginPage.clickSignIn();
        
        // invalid credentials
        loginPage.enterUsername("aby1221@gmail.com");
        loginPage.enterPassword("Abinbb");
        loginPage.clickLoginButton();

        // verify error message
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("We couldn't find your account"), "Error message not displayed for invalid login.");
    }

    @Test(priority = 1, description = " Verify Login with Empty Fields")
    public void testEmptyFieldsLogin() {
    	loginPage = new LoginPage(driver, wait);
        //driver.get("https://www.sidcofoods.ae/"); 

      //close popup
        loginPage.closePopup();
        
        //click signIn
        loginPage.clickSignIn();

        //leave user name and password feilds empty
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();

        //verify error message
        String errorMessage = loginPage.EmptyErrorMessage();
        Assert.assertTrue(errorMessage.contains("Password is required"), "Error message not displayed for empty fields.");
    }
}