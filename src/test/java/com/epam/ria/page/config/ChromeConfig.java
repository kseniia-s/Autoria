package com.epam.ria.page.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.URL;

@Test

public class ChromeConfig {
  public static WebDriver config() {
    URL url = ChromeConfig.class.getClassLoader().getResource("chromedriver.exe");

    System.setProperty("webdriver.chrome.driver", url.getPath());
    return new ChromeDriver();
  }
}
