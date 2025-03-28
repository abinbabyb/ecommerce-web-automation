package sidcofoods;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    
    protected WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        
    	//Hide info bar
    	ChromeOptions chrome = new ChromeOptions();
    	chrome.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
    	
    	System.out.println("driver executing");
        driver = new ChromeDriver(chrome); //-> initialize the driver
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); //-> initialize WebDriverWait
        driver.manage().window().maximize(); //-> maximize the browser window
        driver.get("https://www.sidcofoods.ae/");
    }

	
	  @AfterMethod public void clearBrowser() { 
		  if (driver != null) 
		  {
	  driver.manage().deleteAllCookies(); 
	  } 
		  }
	 

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); 
        }
    }
}