package com.epam.ria.webtests.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCarResultPage extends APage {

  @FindBy(xpath = "//label[@for='leftFilterBodyStyle_1']")
  private WebElement typeCar;
  @FindBy(xpath = "//*[@id='searchResult']//h2[@class='message size16']")
  private WebElement messageNotFoundCar;

  public SearchCarResultPage() {
    PageFactory.initElements(driver, this);
  }

  public SearchCarResultPage chooseCarParameters() {
    typeCar.click();
    return this;
  }

  public String getMessageNotFoundCar() {
//    WebElement messageNotFoundCar = webDriver.findElement(By.xpath("//*[@id='searchResult']//h2[@class='message size16']"));
    return messageNotFoundCar.getText();
  }
}
