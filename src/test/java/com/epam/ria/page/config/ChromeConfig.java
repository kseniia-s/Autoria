package com.epam.ria.page.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ChromeConfig {

  public static Properties properties;

  protected static void loadProperties() {
    URL path = ChromeConfig.class.getClassLoader().getResource("application.yml");
    properties = new Properties();
    try {
      properties.load(new FileInputStream(path.getFile()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static WebDriver config() {
    loadProperties();
    URL url = ChromeConfig.class.getClassLoader().getResource("chromedriver.exe");

    System.setProperty("webdriver.chrome.driver", url.getPath());
    WebDriver driver = new ChromeDriver();

    int pageWaitTimeout = Integer.parseInt(properties.getProperty("pageWaitTimeoutSeconds", "5"));
    driver.manage().timeouts().pageLoadTimeout(pageWaitTimeout, TimeUnit.SECONDS);

    return driver;
  }
}
