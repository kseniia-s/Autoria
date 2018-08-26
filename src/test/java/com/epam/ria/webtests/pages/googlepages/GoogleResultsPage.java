package com.epam.ria.webtests.pages.googlepages;

import com.epam.ria.webtests.pages.APage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleResultsPage extends APage {

  @FindBy(xpath = "//h3[@class='r']/a")
  private WebElement searchResultLink;

  public GoogleResultsPage() {
    PageFactory.initElements(driver, this);
  }

  public void clickFirstLinkResults(){
    searchResultLink.click();
  }

  public boolean isTextPresent(String text){
    List<WebElement> elementsList = driver.findElements(By.xpath("//*[contains(text(), \""+text+"\")]"));
    return !elementsList.isEmpty();
  }
}

