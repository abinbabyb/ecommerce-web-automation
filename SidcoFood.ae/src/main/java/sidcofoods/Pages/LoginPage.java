package sidcofoods.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By popupcloseButton = By.xpath("//button[contains(text(), 'Dismiss')]");
	
	
	private By signInButton = By.xpath("//p[contains(text(), 'Account')]");
	/*
	 * @FindBy(xpath =
	 * "/html/body/header/section[2]/div/div/div[4]/ul/li[2]/a/span/p") private
	 * WebElement SignInButton;
	 */

	private By Userid = By.xpath("/html/body/section[1]/div/div/div/div[2]/div/form/div/div[1]/input");
	/*
	 * @FindBy(name = "email") private WebElement usernameField;
	 */

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath ="/html/body/section[1]/div/div/div/div[2]/div/form/div/button")
    private WebElement loginButton;

	/*
	 * @FindBy(xpath ="//div[contains(text(), 'Welcome')]") private WebElement
	 * welcomeMessage;
	 */
    
    private By successMessage = By.xpath("//div[contains(text(), 'Welcome')]");
    
    private By Errormessage = By.xpath("//div[contains(text(), \"We couldn't find your account\")]");
    private By Emptyerror = By.xpath("/html/body/section[1]/div/div/div/div[2]/div/form/div/div[2]/span");
    /*
	 * @FindBy(xpath = "//div[contains(text(), 'We couldn't find your account')]")
	 * private WebElement errorMessage;
	 */
    

    
 // Methods
    
    public LoginPage(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    
    
    public void closePopup() {
        try {
            WebElement popup = wait.until(ExpectedConditions.presenceOfElementLocated(popupcloseButton));
            popup.click();
            System.out.println("Popup closed successfully.");
        } catch (Exception e) {
            System.out.println("Popup did not appear or could not be closed.");
        }
    }
        
    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public void enterUsername(String name) {
        WebElement emailId = wait.until(ExpectedConditions.visibilityOfElementLocated(Userid));
        emailId.sendKeys(name);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
    	
        loginButton.click();
        
    }

    public String getWelcomeMessage() {
    	WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return message.getText();
    }

    public String getErrorMessage() {
    	WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(Errormessage));
        return message.getText();
    }
    public String EmptyErrorMessage() {
    	WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(Emptyerror));
        return message.getText();
    }
    public HomePage loginWithValidCredentials(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new HomePage(driver);
        }
}

