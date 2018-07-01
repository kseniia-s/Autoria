package com.epam.ria.webtests.pages.googlepages;

import com.epam.ria.webtests.pages.APage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleResultsPage extends APage {

  private WebElement searchResultLink;
  private WebElement elemOnPage;
  private WebElement allText;
  private WebElement nextPageElem;

  public GoogleResultsPage(WebDriver driver) {
    super(driver);
  }

  protected void initElements() {
    searchResultLink = driver.findElement(By.xpath("//h3[@class='r']/a"));
    elemOnPage = driver.findElement(By.xpath("//*[@id=\'rso\']/div"));
    nextPageElem = driver.findElement(By.xpath("//*[@id=\'pnnext\']/span[2]"));
  }

  public void firstLinkResults(){
    searchResultLink.click();
  }

  public boolean isTextPresent(String text){
    List<WebElement> elementsList = driver.findElements(By.xpath("//*[contains(text(), \""+text+"\")]"));
    return !elementsList.isEmpty();
  }
}

