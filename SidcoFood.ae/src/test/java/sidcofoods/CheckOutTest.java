package sidcofoods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;

import sidcofoods.Pages.CartPage;
import sidcofoods.Pages.CheckOutPage;
import sidcofoods.Pages.LoginPage;
import sidcofoods.Pages.SearchPage;

public class CheckOutTest extends BaseTest {
    private LoginPage loginPage;
    private SearchPage searchPage;
    private CartPage cartPage;
    private CheckOutPage checkoutPage;



    @Test(priority = 1, description = "Verify checkout process")
    public void testCheckout() throws InterruptedException {
    	
    	loginPage = new LoginPage(driver, wait);
        searchPage = new SearchPage(driver, wait);
        cartPage = new CartPage(driver, wait);
        checkoutPage = new CheckOutPage(driver, wait);

        //navigate to the website
        //driver.get("https://www.sidcofoods.ae/");

        //close the popups
        searchPage.closePopup();
        
        //search for a product
        searchPage.enterSearchKeyword("chicken");
        searchPage.clickSearchButton();

        //select a product
        searchPage.selectProduct("Ramadan Premium Iftar Box (For 5 to 6 People)");
        //searchPage.selectProduct("Ramadan Premium Iftar Box (For 5 to 6 People)");
        // Add to cart
        cartPage.clickAddToCart();

        // Wait for the cart icon to update
        //cartPage.waitForCartQuantityToUpdate(1);

        
        cartPage.clickViewCart();
        // try to click from checkoutpage
        checkoutPage.clickViewCart();
        
        //try to click from the cartpage 
        cartPage.clickViewCart();
        
        System.out.println("cart loading...");
        checkoutPage.clickViewCart();
        cartPage.clickViewCart();

        // Proceed to checkout

        cartPage.clickCheckout();
        
        cartPage.clickloginButton();

        // Enter login credentials
        loginPage.enterUsername("abinbaby1221@gmail.com");
        loginPage.enterPassword("Abin2123@");
        loginPage.clickLoginButton();
        
        
        //checkoutPage.scrollDown();
        
        checkoutPage.clickRadiobutton();
        
        //click on place order
        checkoutPage.ClickPlaceorder();
        
        

        // Verify redirection to checkout page
        String checkoutUrl = checkoutPage.getCurrentUrl();
        Assert.assertTrue(checkoutUrl.contains("checkout"), "User is not redirected to the checkout page.");
    }
}