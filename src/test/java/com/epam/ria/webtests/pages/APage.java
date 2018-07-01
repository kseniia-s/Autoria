package com.epam.ria.webtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public abstract class APage {

  protected WebDriver driver;

  public APage(WebDriver driver) {
    this.driver = driver;
    initElements();
  }

  protected abstract void initElements();

  protected void selectDropDownOptionByText(String id, String text) {
    Select select = new Select(driver.findElement(By.id(id)));
    selectOptionByText(select, text);
  }

  protected void selectOptionByText(Select select, String text) {
    List<WebElement> allOptions = select.getOptions();
    for(WebElement option:allOptions){
      if(option.getText().contains(text)) {
        option.click(); //select option
      }
    }
  }

  protected void enterText(String text, WebElement element){
    element.sendKeys(text);
  }


}
