package com.epam.ria.webtests.config;

import org.openqa.selenium.WebDriver;

public class Browser {

  private static WebDriver instance;

  private Browser() {
  }

  public static WebDriver getInstance() {
    if (instance == null) {
      instance = ChromeConfig.getDriver();
    }
    return instance;
  }

  public static void closeBrowser() {
    instance.quit();
    instance = null;
  }
}
