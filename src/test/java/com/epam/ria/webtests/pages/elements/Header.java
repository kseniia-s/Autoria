package com.epam.ria.webtests.pages.elements;

import com.epam.ria.webtests.pages.APage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends APage {

  @FindBy(xpath = "//a[@href='https://auto.ria.com/login.html']")
  WebElement loginLink;
  @FindBy(xpath = "//a[@data-type='new']")
  WebElement newCarMenuItem;
  @FindBy(xpath = "//a[@data-type='bu']")
  WebElement buCarMenuItem;
  @FindBy(xpath = "//a[contains (@href, '/add_auto.html') and contains (@class, 'button-add')]")
  WebElement sellCarButton;

  public Header (WebDriver driver){
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public WebElement getLoginLink(){
    return loginLink;
  }

  public WebElement getNewCarMenuItem() {
    return newCarMenuItem;
  }

  public WebElement getBuCarMenuItem() {
    return buCarMenuItem;
  }

  public WebElement getSellCarButton() {
    return sellCarButton;
  }
}
