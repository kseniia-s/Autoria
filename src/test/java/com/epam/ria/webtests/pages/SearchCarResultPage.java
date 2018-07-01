package com.epam.ria.webtests.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCarResultPage{

  @FindBy(xpath = "//label[@for='leftFilterBodyStyle_1']")
  WebElement typeCar;
  @FindBy(xpath = "//*[@id='searchResult']//h2[@class='message size16']")
  WebElement messageNotFoundCar;

  WebDriver webDriver;

  public SearchCarResultPage(WebDriver driver) {
    this.webDriver = driver;
    PageFactory.initElements(driver, this);
  }

  public SearchCarResultPage chooseCarParameters(){
    typeCar.click();
    return this;
  }

  public String getMessageNotFoundCar(){
//    WebElement messageNotFoundCar = webDriver.findElement(By.xpath("//*[@id='searchResult']//h2[@class='message size16']"));
    return messageNotFoundCar.getText();
  }
}
