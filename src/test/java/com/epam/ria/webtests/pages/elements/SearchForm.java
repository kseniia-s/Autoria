package com.epam.ria.webtests.pages.elements;

import com.epam.ria.webtests.pages.APage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchForm extends APage {

  @FindBy(id = "buRadioType")
  WebElement buCarRadioBut;
  @FindBy(id = "naRadioType")
  WebElement newCarRadioBut;
  @FindBy(xpath = "//label[@for='naRadioType']")
  WebElement newCarRadioButLabel;

  public SearchForm () {
    PageFactory.initElements(driver, this);
  }

  public WebElement getBuCarRadioBut() {
    return buCarRadioBut;
  }

  public WebElement getNewCarRadioBut() {
    return newCarRadioBut;
  }

  public void clickNewCarRadioButton() {
    newCarRadioButLabel.click();
  }
}
