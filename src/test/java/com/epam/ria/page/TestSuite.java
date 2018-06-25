package com.epam.ria.page;


import com.epam.ria.page.config.ChromeConfig;
import com.epam.ria.page.page.GoogleHomePage;
import com.epam.ria.page.page.GoogleResultsPage;
import com.epam.ria.page.page.RiaMainPage;
import com.epam.ria.page.page.SkodaResultsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSuite {

  private WebDriver driver;

  @BeforeClass
  public void setup() {
    driver = ChromeConfig.config();
  }

  @AfterClass
  public void cleanup() {
    System.out.println("Clean up");
    driver.close();
  }

  @Test(description = "Search on google page")
  public void startSearchGoogle(){
    driver.manage().window().maximize();
    driver.get("http://www.google.com");
    GoogleHomePage page = new GoogleHomePage(driver);
    page.fillSearchRequest("autoria");
    GoogleResultsPage googleResult = new GoogleResultsPage(driver);
    googleResult.isTextPresent("https://auto.ria.com");
    googleResult.firstLinkResults();
    RiaMainPage riaMain = new RiaMainPage(driver);
    riaMain.searchCarQuickly();
    SkodaResultsPage skodaResults = new SkodaResultsPage(driver);
    skodaResults.chooseCarParameters();
  }
}
