package sidcofoods.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // WebElements
    private By addToCartButton = By.xpath("//div[@class = 'flex-1 lg:w-72 lg:flex-none']//button[contains(text(), 'Add to cart')]");
    
    
    
    private By quantityInput = By.xpath("/html/body/header/section[2]/div/div/div[4]/ul/li[4]/a/div"); 
    //private By cartIcon = By.cssSelector(".cart-icon"); 
    
    private By cartItemCount = By.xpath("//div[contains(@class, 'absolute') and contains(@class, 'text-[8px]') and contains(@class, 'bg-gradient-to-r')]");
    
    
    private By viewCartButton = By.xpath("(//img[@data-nimg='1'])[6]");
    //private By viewCartButton = By.xpath("");
    
    
    private By checkoutButton = By.xpath("/html/body/section[1]/div/div/div[2]/div/div/div[2]/a"); 
    
    
    private By loginButton = By.xpath("/html/body/section[1]/div/div/div/div[1]/ul/li[2]/a");

    // Methods
    
    
    public void clickAddToCart() {
    	
        WebElement addToCartbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        addToCartbtn.click();
    }
    public void scrollDown() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

	/*
	 * public void setQuantity(int quantity) { WebElement quantityField =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(quantityInput));
	 * quantityField.clear(); quantityField.sendKeys(String.valueOf(quantity)); }
	 */

    public int getCartItemCount() {
        WebElement itemCount = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemCount));
        return Integer.parseInt(itemCount.getText());
    }

	

    public void clickViewCart() {
        WebElement viewCartbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartButton));
        viewCartbtn.click();
    }

    public void clickCheckout() {
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutBtn.click();
    }

   public void clickloginButton() {
    	
        WebElement addToCartbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        addToCartbtn.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
    
}