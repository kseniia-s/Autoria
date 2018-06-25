package com.epam.ria.page;


import com.epam.ria.page.config.ChromeConfig;
import com.epam.ria.page.page.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSuite {

  private WebDriver driver;

  @BeforeClass
  public void setup() {
    driver = ChromeConfig.config();
  }

//  @AfterClass
//  public void cleanup() {
//    driver.close();
//  }

  @Test //simple test of searching the car
  public void startSearchGoogle(){
    driver.manage().window().maximize();
    driver.get("http://www.google.com");
    GoogleHomePage page = new GoogleHomePage(driver);
    page.fillSearchRequest("autoria");
    GoogleResultsPage googleResult = new GoogleResultsPage(driver);
    googleResult.isTextPresent("https://auto.ria.com");
    googleResult.firstLinkResults();

    // searching a new car
    RiaMainPage riaMain = new RiaMainPage(driver);
    riaMain.searchCarQuickly();
    SkodaResultsPage skodaResults = new SkodaResultsPage(driver);
    skodaResults.chooseCarParameters();
  }

  @Test //login
  public void loginTest(){
    driver.manage().window().maximize();
    driver.get("https://auto.ria.com");

    // navigation to login page
    RiaMainPage riaMain = new RiaMainPage(driver);
    Assert.assertFalse(riaMain.checkLoggedState());
    riaMain.navigateToLoginPage();

    //login
    LoginPage loginPage = new LoginPage(driver);
    loginPage.performLogin("+380630624774", "arygazupy");
    Assert.assertTrue(riaMain.checkLoggedState());
  }

}
