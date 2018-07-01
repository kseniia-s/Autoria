package com.epam.ria.webtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends APage{

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @Override
  protected void initElements() {
  }

  public void performLogin(String login, String password){
    driver.switchTo().frame("login_frame");
    //if we are in frame:
    WebElement loginField = driver.findElement(By.xpath("//form[@id='login-form']//input[@id='emailloginform-email']"));
    WebElement passwordField = driver.findElement(By.id("emailloginform-password"));
    WebElement loginButton = driver.findElement(By.xpath("//form[@id='login-form']//button[@type='submit']"));

    enterText(login, loginField);
    enterText(password, passwordField);
    loginButton.click();
    driver.switchTo().defaultContent();
  }

}
