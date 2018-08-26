package com.epam.ria.cucumber;

import com.epam.ria.webtests.config.Browser;
import com.epam.ria.webtests.pages.BuAutoPage;
import com.epam.ria.webtests.pages.NewAutoPage;
import com.epam.ria.webtests.pages.RiaMainPage;
import org.openqa.selenium.WebDriver;

public class DataStorage {
  public static final String BASE_URL = "https://auto.ria.com/";   //ChromeConfig.properties.getProperty("baseUrl");
  protected static WebDriver driver = Browser.getInstance();
  public static RiaMainPage riaMainPage = new RiaMainPage();

  public static NewAutoPage newAutoPage = new NewAutoPage();
  public static BuAutoPage buAutoPage = new BuAutoPage();
}
