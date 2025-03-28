package sidcofoods;


import org.testng.Assert;
import org.testng.annotations.Test;

import sidcofoods.Pages.RegistrationPage;

public class RegistrationTest extends BaseTest {
    @Test(priority = 3, description = "Verify successful registration with valid inputs")
    public void testValidRegistration() {
    	
    	RegistrationPage registrationPage = new RegistrationPage(driver, wait);
        //driver.get("https://www.sidcofoods.ae/"); 

        //close popup
        registrationPage.closePopup();

        // Navigate to registration page
        registrationPage.clickSignIn();
        registrationPage.clickRegistrationLink();

        // Enter registration details
        registrationPage.enterName("Abin Baby");
        registrationPage.enterMobile("977232076");
        registrationPage.enterEmail("r9kk88123f4oo8@angun.com");
        registrationPage.enterPassword("Abin2123@");

        //scroll down and check terms checkbox
        registrationPage.scrollDown();
        registrationPage.checkTermsCheckbox();

        //click register button
        registrationPage.clickRegisterButton();

        //validate success message
        String successMessage = registrationPage.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("Abin"), "Welcome message does not contain the username.");
    }

    @Test(priority = 1, description = "Verify error message for invalid email format")
    public void testInvalidEmail() {
    	RegistrationPage registrationPage = new RegistrationPage(driver, wait);
        //driver.get("https://www.sidcofoods.ae/");

        // Close popup
        registrationPage.closePopup();

        // Navigate to registration page
        registrationPage.clickSignIn();
        registrationPage.clickRegistrationLink();

        //enter registration details with invalid email
        registrationPage.enterName("Abin Baby");
        registrationPage.enterMobile("97110098");
        registrationPage.enterEmail("amgqn.com");
        registrationPage.enterPassword("Abin2123@");

        //scroll down and check terms checkbox
        registrationPage.scrollDown();
        registrationPage.checkTermsCheckbox();

        //click register button
        registrationPage.clickRegisterButton();

        //validate error message
        Assert.assertTrue(registrationPage.isInvalidEmailErrorDisplayed(), "Error message for invalid email was not displayed.");
    }

    @Test(priority = 2, description = "Verify error message for weak password")
    public void testWeakPassword() {
    	RegistrationPage registrationPage = new RegistrationPage(driver, wait);
        //driver.get("https://www.sidcofoods.ae/");

        //close popup
        registrationPage.closePopup();

        //navigate to registration page
        registrationPage.clickSignIn();
        registrationPage.clickRegistrationLink();

        //enter registration details with weak password
        registrationPage.enterName("Abin Baby");
        registrationPage.enterMobile("9715555538");
        registrationPage.enterEmail("rejot60358@amgens.com");
        registrationPage.enterPassword("1234");

        //scroll down and check terms checkbox
        registrationPage.scrollDown();
        registrationPage.checkTermsCheckbox();

        //cick register button
        registrationPage.clickRegisterButton();

        //validate error message
        Assert.assertTrue(registrationPage.isWeakPasswordErrorDisplayed(), "Error message for weak password was not displayed.");
    }
}