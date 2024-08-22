package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class TravelokaSearchTest extends BaseTest {

    @Test
    public void testSearchHotelFunctionality() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.traveloka.com/");

        WebElement hotelTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='product-pill-Hotels']")));
        hotelTab.click();

        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='autocomplete-field']")));
        inputField.click();
        inputField.sendKeys("Jakarta");

        WebElement jakartaInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='autocomplete-item-name' and .//mark[text()='Jakarta']]")));
        jakartaInput.click();
        
        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='search-submit-button'")));
        searchButton.click();

        WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='total-property']")));
        assertTrue(searchResults.getText().contains("Jakarta"), "The search results did not contain 'Jakarta'");
    }
}
