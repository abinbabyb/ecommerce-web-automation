package sidcofoods;


import org.testng.Assert;
import org.testng.annotations.Test;

import sidcofoods.Pages.SearchPage;

public class SearchTest extends BaseTest {
  

   

    @Test(priority = 1, description = "Verify Search with Valid Keyword")
    public void testValidSearch() {
    	SearchPage searchPage = new SearchPage(driver);
    	//driver.get("https://www.sidcofoods.ae/"); 
    	//close popup
        searchPage.closePopup();
        searchPage.enterSearchKeyword("fruits");
        searchPage.clickSearchButton();

        // Verify search results message
        boolean areResultsDisplayed = searchPage.areSearchResultsDisplayed();
        Assert.assertTrue(areResultsDisplayed, "Search results are not displayed for valid keyword.");
    }

    @Test(priority = 2, description = "Verify Search with Invalid Keyword")
    public void testInvalidSearch() {
    	SearchPage searchPage = new SearchPage(driver);
    	//driver.get("https://www.sidcofoods.ae/"); 
    	//close popup
        searchPage.closePopup();
        
        
        searchPage.enterSearchKeyword("XYZ123");
        searchPage.clickSearchButton();
        Assert.assertTrue(searchPage.isNoResultsMessageDisplayed(), "No results message is not displayed for invalid keyword.");
    }

    @Test(priority = 3, description = "Verify Search with Partial Keyword")
    public void testPartialSearch() {
    	SearchPage searchPage = new SearchPage(driver);
    	//driver.get("https://www.sidcofoods.ae/"); 
    	//close popup
        searchPage.closePopup();
        
        searchPage.enterSearchKeyword("fru");
        searchPage.clickSearchButton();
        Assert.assertTrue(searchPage.areSearchResultsDisplayed(), "Search results are not displayed for partial keyword.");
    }

    @Test(priority = 4, description = "Verify SQL Injection Attempt in Search")
    public void testSQLInjectionSearch() {
    	
    	SearchPage searchPage = new SearchPage(driver);
    	//driver.get("https://www.sidcofoods.ae/"); 
    	//close popup
        searchPage.closePopup();
        searchPage.enterSearchKeyword("' OR 1=1 --");
        searchPage.clickSearchButton();
        Assert.assertTrue(searchPage.isNoResultsMessageDisplayed(), "SQL injection attempt was not handled properly.");
    }

    @Test(priority = 6, description = "Verify XSS in Search")
    public void testXSSSearch() {
    	
    	SearchPage searchPage = new SearchPage(driver);
    	//driver.get("https://www.sidcofoods.ae/"); 
    	//close popup
        searchPage.closePopup();
        searchPage.enterSearchKeyword("<script>alert('test')</script>");
        searchPage.clickSearchButton();
        Assert.assertTrue(searchPage.isNoResultsMessageDisplayed(), "XSS attempt was not handled properly.");
    }

    @Test(priority = 5, description = "Verify search and click on suggested product")
    public void testSuggestedProductClick() {
    	SearchPage searchPage = new SearchPage(driver);
    	//driver.get("https://www.sidcofoods.ae/"); 
    	//close popup
        searchPage.closePopup();
        searchPage.enterSearchKeyword("fruits");
        Assert.assertTrue(searchPage.areSuggestedProductsDisplayed(), "Suggested products are not displayed.");
        searchPage.clickSuggestedProduct("Mango Pulp Alphonso (1 kg)");
      
    }
}