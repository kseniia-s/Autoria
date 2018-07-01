package com.epam.ria.webtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddAutoPage extends APage {

  private WebElement loginIframe;

  public AddAutoPage(WebDriver driver) {
    super(driver);
  }

  protected void initElements() {
    loginIframe = driver.findElement(By.id("login_frame"));
  }

  public WebElement getLoginIframe(){
    return loginIframe;
  }
}
