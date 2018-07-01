package com.epam.ria.webtests.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class APage {
  private static final Logger LOG = LogManager.getLogger(APage.class);

  protected WebDriver driver;

  public APage(WebDriver driver) {
    this.driver = driver;
  }

  protected void selectDropDownOptionByText(String id, String text) {
    Select select = new Select(driver.findElement(By.id(id)));
    selectOptionByText(select, text);
  }

  protected void selectOptionByText(Select select, String text) {
    List<WebElement> allOptions = select.getOptions();
    for(WebElement option:allOptions){
      LOG.trace(option.getText());
      if(option.getText().contains(text)) {
        option.click(); //select option
      }
    }
  }

  protected void enterText(String text, WebElement element){
    element.sendKeys(text);
  }

}
