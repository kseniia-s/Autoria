package com.epam.ria.webtests;


import com.epam.ria.webtests.config.ChromeConfig;
import com.epam.ria.webtests.pages.*;
import com.epam.ria.webtests.pages.googlepages.GoogleHomePage;
import com.epam.ria.webtests.pages.googlepages.GoogleResultsPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners ({org.uncommons.reportng.HTMLReporter.class,
    org.uncommons.reportng.JUnitXMLReporter.class})
public class TestSuite {

  private final static Logger LOG = LogManager.getLogger(TestSuite.class);

  private WebDriver driver;
  private String baseUrl;

  @BeforeClass
  public void setup() {
    LOG.trace("Setup test classes;");
    driver = ChromeConfig.config();
    baseUrl = ChromeConfig.properties.getProperty("baseUrl");
    LOG.trace("Setup finished");
  }

  protected RiaMainPage openRiaMainPage(){
    driver.get(baseUrl);
    driver.manage().window().maximize();
    return new RiaMainPage(driver);
  }

  @AfterClass
  public void cleanup() {
    System.out.println("Clean up");
    driver.close();
  }

  @Test(description = "Search on google pages")
  public void searchGoogleTest(){
    driver.manage().window().maximize();
    driver.get("http://www.google.com");

    LOG.debug("opened google page");
    GoogleHomePage page = new GoogleHomePage(driver);
    page.fillSearchRequest("autoria");

    LOG.warn("opened google result page");
    GoogleResultsPage googleResult = new GoogleResultsPage(driver);
    googleResult.isTextPresent("https://auto.ria.com");
    googleResult.firstLinkResults();

    LOG.error("opened first link");
  }

  @Test(description = "Search a new car Skoda")
  public void searchNewSkodaTest(){
    // searching a new car
    RiaMainPage riaMain = openRiaMainPage();
    riaMain.searchCarQuickly();
    SkodaResultsPage skodaResults = new SkodaResultsPage(driver);
    skodaResults.chooseCarParameters();
  }

  @Test(description = "Login check")
  public void loginTest(){
    // navigation to login pages
    RiaMainPage riaMain = openRiaMainPage();
    Assert.assertFalse(riaMain.checkLoggedState());
    riaMain.navigateToLoginPage();

    //login
    LoginPage loginPage = new LoginPage(driver);
    loginPage.performLogin("+380630624774", "arygazupy");
    Assert.assertTrue(riaMain.checkLoggedState());
  }

  @Test(description = "Checking the breadcrumbs using top menu")
  public void breadcrumbsTest(){
    RiaMainPage riaMain = openRiaMainPage();
    riaMain.navToNewCarPage();
    NewAutoPage newAutoPage = new NewAutoPage(driver);
    Assert.assertEquals(newAutoPage.getLastBreadcrumb(), "новые авто");

    newAutoPage.navToBuCarPage();
    BuAutoPage buAutoPage = new BuAutoPage (driver);
    Assert.assertEquals(buAutoPage.getLastBreadcrumb(), "бу авто");
  }

  @Test(description = "Checking search form radio button state using top menu")
  public void checkRelationsMenuSeachFormTest(){
    RiaMainPage riaMain = openRiaMainPage();
    riaMain.navToNewCarPage();
    NewAutoPage newAutoPage = new NewAutoPage(driver);
    Assert.assertTrue(newAutoPage.getSearchForm().getNewCarRadioBut().isSelected());

    newAutoPage.navToBuCarPage();
    BuAutoPage buAutoPage = new BuAutoPage (driver);
    Assert.assertTrue(buAutoPage.getSearchForm().getBuCarRadioBut().isSelected());
  }

  @Test(description = "Checking list of transport categories")
  public void checkNumOfCarCategoryTest(){
    RiaMainPage riaMain = openRiaMainPage();
    riaMain.categoryCarSelect();
    Assert.assertEquals(riaMain.categoryCarSelect(), 10);
  }

  @Test (description = "Unauthorized user is redirected to login page on add auto action")
  public void redirectLoginTest(){
    RiaMainPage riaMain = openRiaMainPage();
    Assert.assertFalse(riaMain.checkLoggedState());
    riaMain.performSellCarButtonClick();
    AddAutoPage addAutoPage = new AddAutoPage(driver);
    Assert.assertTrue(addAutoPage.getLoginIframe().isDisplayed());
  }
}
