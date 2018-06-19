package com.epam.ria.page.page;

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
    searchResultLink = webDriver.findElement(By.xpath("//h3[@class='r']/a"));
    elemOnPage = webDriver.findElement(By.xpath("//*[@id=\'rso\']/div"));
    nextPageElem = webDriver.findElement(By.xpath("//*[@id=\'pnnext\']/span[2]"));
  }

  public void firstLinkResults(){
    searchResultLink.click();
  }

  public boolean isTextPresent(String text){
    List<WebElement> elementsList = webDriver.findElements(By.xpath("//*[contains(text(), \""+text+"\")]"));
    return !elementsList.isEmpty();
  }
}

