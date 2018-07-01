package com.epam.ria.webtests.pages.elements;

import com.epam.ria.webtests.pages.APage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchForm extends APage {
  private WebElement buCarRadioBut;
  private WebElement newCarRadioBut;

  private WebElement newCarRadioButLabel;

  public SearchForm (WebDriver driver) {
    super(driver);
  }

  public void initElements() {
    buCarRadioBut = driver.findElement(By.id("buRadioType"));
    newCarRadioBut = driver.findElement(By.id("naRadioType"));
    newCarRadioButLabel = driver.findElement(By.xpath("//label[@for='naRadioType']"));
  }

  public WebElement getBuCarRadioBut() {
    return buCarRadioBut;
  }

  public WebElement getNewCarRadioBut() {
    return newCarRadioBut;
  }

  public void performNewCarRadioButClick() {
    newCarRadioButLabel.click();
  }
}
