package sidcofoods;

import org.testng.Assert;
import org.testng.annotations.Test;

import sidcofoods.Pages.CartPage;
import sidcofoods.Pages.CheckOutPage;
import sidcofoods.Pages.LoginPage;
import sidcofoods.Pages.SearchPage;

public class CartTest extends BaseTest {
	private LoginPage loginPage;
	private SearchPage searchPage;
    private CartPage cartPage;
    private CheckOutPage checkoutPage;




    @Test(priority = 1, description = "Verify adding single and multiple products to the cart")
    public void testAddToCart() throws InterruptedException {
    	SearchPage searchPage = new SearchPage(driver,wait);
    	CartPage cartPage = new CartPage(driver, wait);

       

        // Navigate to the website
        //driver.get("https://www.sidcofoods.ae/");

        // Close any popups
        searchPage.closePopup();
        // Search for a product
        searchPage.enterSearchKeyword("chicken");
        searchPage.clickSearchButton();
        
       // Thread.sleep(5);
     

        // Select a product
       searchPage.selectProduct("alt=\"Ramadan Premium Iftar Box (For 5 to 6 People)\"");

        
        // Add to cart
        cartPage.clickAddToCart();

        // Verify cart icon is updated
        int itemCount = cartPage.getCartItemCount();
        System.out.println(itemCount);
        Assert.assertEquals(itemCount, 0, "Cart icon is not updated after adding a product.");

    }

    
    

    @Test(priority = 2, description = "Verify adding a product to the cart, viewing the cart,")
    public void testViewCartAndCheckout() throws InterruptedException {
    	loginPage = new LoginPage(driver, wait);
    	SearchPage searchPage = new SearchPage(driver,wait);
    	CartPage cartPage = new CartPage(driver, wait);
    	
    	// Navigate to the website
        //driver.get("https://www.sidcofoods.ae/");

        // Close any popups
        searchPage.closePopup();
        
        
        
        
        
        // Search for a product
        searchPage.enterSearchKeyword("Chicken");
        searchPage.clickSearchButton();

        // Select a product
        searchPage.selectProduct("alt=\"Ramadan Premium Iftar Box (For 5 to 6 People)\"");

        // Add to cart
        cartPage.clickAddToCart();

        //Thread.sleep(5);
        cartPage.clickViewCart();
        
        //checkoutPage.clickViewCart();
        // View cart
        cartPage.clickViewCart();
        System.out.println("Cart running...");
        //cartPage.clickViewCart();
        System.out.println("Cart running...2");

        // Verify redirection to cart page
       // String cartUrl = cartPage.getCurrentUrl();
        //Assert.assertTrue(cartUrl.contains("cart"), "User is not redirected to the cart page.");
      
        //Thread.sleep(5);
        // Proceed to checkout
        cartPage.clickCheckout();
        
        cartPage.clickloginButton();
        
        loginPage.enterUsername("abinbaby1221@gmail.com");
        loginPage.enterPassword("Abin2123@");
        loginPage.clickLoginButton();

        // Verify redirection to checkout page
        String checkoutUrl = cartPage.getCurrentUrl();
        System.out.println(checkoutUrl);
        Assert.assertTrue(checkoutUrl.contains("cart"), "User is not redirected to the checkout page.");
    }
}