package sidcofoods.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public SearchPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
}

    // WebElements
    private By popupcloseButton = By.xpath("//button[contains(text(), 'Dismiss')]");
    
    
    private By searchBar = By.xpath("//input[@placeholder = 'Search for any delicious product']"); 
    
    
    private By searchButton = By.xpath("//div[@class='absolute top-[50%] ltr:right-4 rtl:left-4 -translate-y-[50%] text-base text-[#E8E8E8]']//img[@loading=\"lazy\"]"); 
    private By searchResults = By.xpath("//h5[contains(text(), 'Results Found')]"); 
    private By noResultsMessage = By.xpath("//h5[contains(text(), '0 Results Found')]"); 
    
    private By productLocator = By.xpath("/html/body/div[2]/section[2]/div/div[2]/div[3]/div/div/div/div[1]/article/div[1]/a");
    
    private By suggestedProducts = By.xpath("//p[contains(text(), 'Mango Pulp Alphonso (1 kg)')]");

    // Methods
    
    public SearchPage(WebDriver driver) {
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
    
    
    public void enterSearchKeyword(String keyword) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    

    public void clickSearchButton() {
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchBtn.click();
    }

    public boolean areSearchResultsDisplayed() {
        try {
            WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
            return results.isDisplayed() && results.getText().contains("Results Found");
        } catch (Exception e) {
            return false;
        }
    }

    public String getSearchResultsMessage() {
        try {
            WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
            return results.getText();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isNoResultsMessageDisplayed() {
        try {
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(noResultsMessage));
            return message.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areSuggestedProductsDisplayed() {
        try {
            WebElement suggestions = wait.until(ExpectedConditions.visibilityOfElementLocated(suggestedProducts));
            return suggestions.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickSuggestedProduct(String productName) {
        By suggestedProductLocator = By.xpath("/html/body/header/section[2]/div/div/div[3]/div/div[2]/div/ul/li[1]/a"); 
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(suggestedProductLocator));
        product.click();
    }
    
    public void selectProduct(String productName) {
        
        WebElement product = wait.until(ExpectedConditions.presenceOfElementLocated(productLocator));
        product.click();
    }
}