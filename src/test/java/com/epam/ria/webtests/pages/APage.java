package com.epam.ria.webtests.pages;

import com.epam.ria.webtests.config.Browser;
import com.epam.ria.webtests.config.ChromeConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public abstract class APage {
  private static final Logger LOG = LogManager.getLogger(APage.class);
  protected static WebDriver driver = Browser.getInstance();
  private String URL;

  protected void selectDropDownOptionByTextId(String id, String text) {
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

  public String getURL() {
    return URL;
  }

}
