package com.epam.ria.webtests.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ChromeConfig {
  private static final Logger LOG = LogManager.getLogger(ChromeConfig.class);

  public static Properties properties;

  protected static void loadProperties() {
    URL path = ChromeConfig.class.getClassLoader().getResource("application.yml");
    properties = new Properties();
    try {
      properties.load(new FileInputStream(path.getFile()));
    } catch (IOException e) {
      LOG.error(e.getMessage(), e);
    }
  }

  public static WebDriver config() {
    loadProperties();
    URL url = ChromeConfig.class.getClassLoader().getResource("chromedriver.exe");

    System.setProperty("webdriver.chrome.driver", url.getPath());
    WebDriver driver = new ChromeDriver();

    int pageWaitTimeout = Integer.parseInt(properties.getProperty("pageWaitTimeoutSeconds", "5"));
    driver.manage().timeouts().pageLoadTimeout(pageWaitTimeout, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    return driver;
  }
}
