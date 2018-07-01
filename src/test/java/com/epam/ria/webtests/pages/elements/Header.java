package com.epam.ria.webtests.pages.elements;

import com.epam.ria.webtests.pages.APage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header extends APage {
  private WebElement loginLink;
  private WebElement newCarMenuItem;
  private WebElement buCarMenuItem;
  private WebElement sellCarButton;

  public Header (WebDriver driver){ super(driver);}

  public void initElements(){
    loginLink = driver.findElement(By.xpath("//a[@href='https://auto.ria.com/login.html']"));
    newCarMenuItem = driver.findElement(By.xpath("//a[@data-type='new']"));
    buCarMenuItem = driver.findElement(By.xpath("//a[@data-type='bu']"));
    sellCarButton = driver.findElement(By.xpath("//a[contains (@href, '/add_auto.html') and contains (@class, 'button-add')]"));
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
