package sidcofoods.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CheckOutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // WebElements
    //private By addToCartButton = By.xpath("/html/body/div[2]/section[1]/div/div[1]/div[2]/div[6]/div[1]/div/button");
    
    
    private By viewCartButton = By.xpath("/html/body/header/section[2]/div/div/div[4]/ul/li[4]/a");
    
    
    private By checkoutButton = By.xpath("/html/body/section[1]/div/div/div[2]/div/div/div[2]/a");
    
    
    private By loginButton = By.xpath("/html/body/section[1]/div/div/div/div[1]/ul/li[2]/a");
    
    private By radioButton = By.xpath("//button[@id='cod']");
    
    private By placeorder = By.xpath("//*[@id=\"radix-:r26:\"]/div/div/button");

    // Methods
	/*
	 * public void clickAddToCart() { WebElement addToCartBtn =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
	 * addToCartBtn.click(); }
	 */

    public void clickViewCart() {
        WebElement viewCartbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartButton));
        viewCartbtn.click();
    }

    public void clickCheckout() {
        WebElement checkoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton));
        checkoutBtn.click();
    }

    public void clickLoginButton() {
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        loginBtn.click();
    }
    
    public void scrollDown() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
    
    public void clickRadiobutton() throws InterruptedException {
        WebElement radiobutton = wait.until(ExpectedConditions.elementToBeClickable(radioButton));
        //Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript(
        	    "window.scrollBy({top: 40, left: 0, behavior: 'smooth'});"
        	);
        Thread.sleep(3000);
        radiobutton.click();
    }
    
    public void ClickPlaceorder() throws InterruptedException {
        WebElement placeorderbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(placeorder));
        
        ((JavascriptExecutor) driver).executeScript(
        	    "window.scrollBy({top: 80, left: 0, behavior: 'smooth'});"
        	);
        Thread.sleep(3000);
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeorderbutton);
      
        placeorderbutton.click();
    }
    
    

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}