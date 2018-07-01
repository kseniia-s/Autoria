package com.epam.ria.webtests.pages;

import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class SkodaResultsPage {
  private WebDriver webDriver;
  private WebElement moreBodyTypes;
  private WebElement CarBodyType;


  public SkodaResultsPage(WebDriver driver) {
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    this.webDriver = driver;
    initElements();
  }

  private void initElements() {
    moreBodyTypes = webDriver.findElement(By.xpath("//*[@class = 'row']//a[@class = 'el-selected open']"));


  }

  public void chooseCarParameters(){
    moreBodyTypes.click();

  }

}
