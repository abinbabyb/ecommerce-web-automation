package sidcofoods.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	    private WebDriver driver;
	    private WebDriverWait wait;

	    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
	        this.driver = driver;
	        this.wait = wait;
    }

    // WebElements
    private By popupCloseButton = By.xpath("//button[contains(text(), 'Dismiss')]");
    
    
    private By signInButton = By.xpath("//p[contains(text(), 'Account')]");
    
    
    private By registrationLink = By.xpath("//a[contains(text(), 'Register')]");
    
    private By nameField = By.id(":r0:-form-item");
    
	/*+
	 * @FindBy(id = "mobile" ) private WebElement mobileField;
	 */
    //private By mobileField = By.xpath("");
    private By mobileField = By.id("mobile");
    
    
    private By emailField = By.id(":r3:-form-item");
    
    private By passwordField = By.name("password");
    
    private By termsCheckbox = By.xpath("//input[@id='terms']");
    
    private By registerButton = By.xpath("//button[contains(text(), 'Register')]");
    
    private By successMessage = By.xpath("//div[contains(text(), 'Welcome')]");
    
    private By invalidEmailError = By.xpath("//p[contains(text(), 'Invalid Email Address')]");
    
    private By weakPasswordError = By.xpath("//p[contains(text(), 'Password must be at least 7 characters long')]");

    // Methods
	/*
	 * public void closePopup() { try { WebElement popup =
	 * wait.until(ExpectedConditions.presenceOfElementLocated(popupCloseButton));
	 * popup.click(); System.out.println("Popup closed successfully."); }
	 */

    public void closePopup() {
        try {
            WebElement popup = wait.until(ExpectedConditions.presenceOfElementLocated(popupCloseButton));
            popup.click();
            System.out.println("Popup closed successfully.");
        } catch (Exception e) {
            System.out.println("Popup did not appear or could not be closed.");
        }
    }
    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public void clickRegistrationLink() {
        WebElement registration = wait.until(ExpectedConditions.presenceOfElementLocated(registrationLink));
        registration.click();
    }

    public void enterName(String name) {
        WebElement nameelement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        nameelement.sendKeys(name);
    }

    public void enterMobile(String mobile) {
        driver.findElement(mobileField).sendKeys(mobile);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void checkTermsCheckbox() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox));
        checkbox.click();
    }

    public void clickRegisterButton() {
        WebElement register = wait.until(ExpectedConditions.presenceOfElementLocated(registerButton));
        register.click();
    }

    public String getSuccessMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return message.getText();
    }

    public boolean isInvalidEmailErrorDisplayed() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(invalidEmailError));
        return error.isDisplayed();
    }

    public boolean isWeakPasswordErrorDisplayed() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(weakPasswordError));
        return error.isDisplayed();
    }

    public void scrollDown() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
}