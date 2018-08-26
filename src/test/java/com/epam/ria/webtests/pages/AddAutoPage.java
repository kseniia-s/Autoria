package com.epam.ria.webtests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAutoPage extends APage {

  @FindBy(id = "login_frame")
  private WebElement loginIframe;

  public AddAutoPage() {
    PageFactory.initElements(driver, this);
  }

  public WebElement getLoginIframe(){
    return loginIframe;
  }
}
