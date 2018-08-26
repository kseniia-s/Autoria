package com.epam.ria.webtests.pages.googlepages;

import com.epam.ria.webtests.pages.APage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends APage {

    @FindBy(name = "q")
    private WebElement searchField;

    public GoogleHomePage() {
        PageFactory.initElements(driver, this);
    }

    public void fillSearchRequest(String text) {
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
    }
}
