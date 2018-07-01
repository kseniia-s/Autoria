package com.epam.ria.page.pages.googlepages;

import com.epam.ria.page.pages.APage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage extends APage {

    private WebElement searchField;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    protected void initElements() {
        searchField = driver.findElement(By.name("q"));
    }

    public void fillSearchRequest(String text) {
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
    }
}
