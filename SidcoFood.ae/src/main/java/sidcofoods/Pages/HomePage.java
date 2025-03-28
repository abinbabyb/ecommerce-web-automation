package sidcofoods.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // WebElements
    private By successMessage = By.xpath("//div[contains(text(), 'Welcome')]");
    
    /*@FindBy(xpath = "//div[@class='welcome-message']")
    private WebElement welcomeMessage;*/

    @FindBy(xpath = "//p[contains(text(), 'Account')]")
    private WebElement accountLink;

   // @FindBy(xpath = "/html/body/section[1]/div/div/div[1]/div/ul/li[8]/p")
    private By logoutButton = By.xpath("//p[@aria-haspopup='dialog']");
    
	/*
	 * @FindBy(xpath = "//*[@id=\"radix-:ra:\"]/button[2]") private WebElement
	 * Logout;
	 */
    
    //private By confirmlogout = By.xpath("//*[@id=\"radix-:ra:\"]/button[2]");
    private By confirmlogout= By.xpath("//button[text()='Logout']");
    
    // Constructor 
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //method to get the welcome message
    public String getWelcomeMessage() {
    	WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    	//System.out.println("Successfully logined");
        return message.getText();
        
            }


    // Method to navigate to the account page
    public void goToAccount() {
        accountLink.click();
    }

    // Method to log out
    public void logout() {
    	WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logout.click();
    }
    
    public void confirmLogout() {
    	try {
    	WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(confirmlogout));
        confirmButton.click();
        System.out.println("Clicked 'Logout' in the confirmation dialog.");
        
        
    	}catch (Exception e) {
            System.out.println("Confirmation dialog did not appear or could not be closed.");
        }
    }
}