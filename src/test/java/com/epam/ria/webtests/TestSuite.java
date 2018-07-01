package com.epam.ria.webtests;


import com.epam.ria.webtests.config.ChromeConfig;
import com.epam.ria.webtests.pages.*;
import com.epam.ria.webtests.pages.googlepages.GoogleHomePage;
import com.epam.ria.webtests.pages.googlepages.GoogleResultsPage;
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
    driver.manage().window().maximize();
    driver.get(baseUrl);
    return new RiaMainPage(driver);
  }

  protected GoogleHomePage openGoogleHomePage(){
    driver.manage().window().maximize();
    driver.get("https://google.com.ua");
    return new GoogleHomePage(driver);
  }

  @AfterClass
  public void cleanup() {
    System.out.println("Clean up");
    driver.close();
  }

  @Test(description = "Search on google pages")
  public void searchGoogleTest(){
    GoogleHomePage googleHomePage = openGoogleHomePage();
    LOG.debug("opened google page");
    googleHomePage.fillSearchRequest("autoria");
    LOG.warn("opened google result page");
    GoogleResultsPage googleResult = new GoogleResultsPage(driver);
    Assert.assertTrue(googleResult.isTextPresent("https://auto.ria.com"));
    googleResult.clickFirstLinkResults();
    LOG.error("opened first link");
  }

  @Test(description = "Search a new car Skoda")
  public void searchNewSkodaTest(){
    // searching a new car Skoda Octavia in Vinnitsya
    RiaMainPage riaMain = openRiaMainPage();
    riaMain.clickNewCarRadioButton()
      .chooseTransport("Легковые")
      .chooseBrand("Skoda")
      .chooseModel("Octavia")
      .chooseCity("Винница");
    SearchCarResultPage skodaResults = riaMain.clickSearchCar();
    skodaResults.chooseCarParameters();
    Assert.assertTrue(skodaResults.getMessageNotFoundCar().contains("К сожалению мы не смогли найти предложений подходящих Вашему запросу"));
  }

  @Test(enabled = false, description = "Login check")
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

    //nav to new car page and check breadcrumbs
    NewAutoPage newAutoPage = riaMain.navToNewCarPage();
    Assert.assertEquals(newAutoPage.getLastBreadcrumb(), "новые авто");

    //nav to used car page and check breadcrumbs
    BuAutoPage buAutoPage = newAutoPage.navToBuCarPage();
    Assert.assertEquals(buAutoPage.getLastBreadcrumb(), "бу авто");
  }

  @Test(description = "Checking search form radio button state using top menu")
  public void checkRelationsMenuSeachFormTest(){
    RiaMainPage riaMain = openRiaMainPage();

    //nav to new car page and check state of radio button
    NewAutoPage newAutoPage = riaMain.navToNewCarPage();
    Assert.assertTrue(newAutoPage.getSearchForm().getNewCarRadioBut().isSelected());

    //nav to used car page and check state of radio button
    BuAutoPage buAutoPage = newAutoPage.navToBuCarPage();
    Assert.assertTrue(buAutoPage.getSearchForm().getBuCarRadioBut().isSelected());
  }

  @Test(description = "Checking list of transport categories")
  public void checkNumOfCarCategoryTest(){
    RiaMainPage riaMain = openRiaMainPage();
    riaMain.categoryCarSelect();
    Assert.assertEquals(riaMain.categoryCarSelect(), 10);
  }

  @Test (description = "Unauthorized user is redirected to login page on Add Car action")
  public void redirectLoginTest(){
    RiaMainPage riaMain = openRiaMainPage();
    Assert.assertFalse(riaMain.checkLoggedState());
    riaMain.clickSellCarButton();
    AddAutoPage addAutoPage = new AddAutoPage(driver);
    Assert.assertTrue(addAutoPage.getLoginIframe().isDisplayed());
  }
}
