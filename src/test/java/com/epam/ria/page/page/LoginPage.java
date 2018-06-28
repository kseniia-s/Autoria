package com.epam.ria.page.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends APage{

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @Override
  protected void initElements() {
  }

  public void performLogin(String login, String password){
    webDriver.switchTo().frame("login_frame");
    //if we are in frame:
    WebElement loginField = webDriver.findElement(By.xpath("//form[@id='login-form']//input[@id='emailloginform-email']"));
    WebElement passwordField = webDriver.findElement(By.id("emailloginform-password"));
    WebElement loginButton = webDriver.findElement(By.xpath("//form[@id='login-form']//button[@type='submit']"));

    enterText(login, loginField);
    enterText(password, passwordField);
    loginButton.click();
    webDriver.switchTo().defaultContent();
  }

}
