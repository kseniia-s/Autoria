package com.epam.ria.page;


import com.epam.ria.page.config.ChromeConfig;
import com.epam.ria.page.pages.*;
import com.epam.ria.page.pages.googlepages.GoogleHomePage;
import com.epam.ria.page.pages.googlepages.GoogleResultsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners ({org.uncommons.reportng.HTMLReporter.class,
    org.uncommons.reportng.JUnitXMLReporter.class})
public class TestSuite {

  private WebDriver driver;

  @BeforeClass
  public void setup() {
    driver = ChromeConfig.config();
  }

  protected RiaMainPage openRiaMainPage(){
    driver.get("https://auto.ria.com");
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
    GoogleHomePage page = new GoogleHomePage(driver);
    page.fillSearchRequest("autoria");
    GoogleResultsPage googleResult = new GoogleResultsPage(driver);
    googleResult.isTextPresent("https://auto.ria.com");
    googleResult.firstLinkResults();
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
