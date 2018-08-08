package com.epam.ria.glue;

import com.epam.ria.webtests.config.Browser;
import com.epam.ria.webtests.config.ChromeConfig;
import com.epam.ria.webtests.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RedirectToLoginStepsDefs {
  private String baseUrl = ChromeConfig.properties.getProperty("baseUrl");
  private WebDriver driver = Browser.getInstance();

  @Given("^User goes to the main page$")
  public void userGoesToTheMainPage() {
    RiaMainPage riaMainPage = openRiaMainPage(baseUrl);
//    Assert.assertEquals(riaMainPage.getURL(), "https://auto.ria.com/");
  }

  @Then("^Unauthorized user should see \"([^\"]*)\" link in the top of the page$")
  public void unauthorizedUserShouldSeeLinkInTheTopOfThePage(String linkText){
    RiaMainPage riaMainPage = openRiaMainPage(baseUrl);
    boolean userState = riaMainPage.checkLoggedState();
    Assert.assertFalse(userState);
    String text = riaMainPage.getOwnCabinetText();
    Assert.assertTrue(text.contains(linkText));
  }

  @And("^Unauthorized user clicks on Sell Car button$")
  public void unauthorizedUserClicksOnSellCarButton(){
    RiaMainPage riaMainPage = openRiaMainPage(baseUrl);
    riaMainPage.clickSellCarButton();
  }

  @Then("^Auto Page displays a Login Form$")
  public void autoPageDisplaysALoginForm(){
    AddAutoPage addAutoPage = new AddAutoPage(driver);
    Assert.assertTrue(addAutoPage.getLoginIframe().isDisplayed());
  }

  private RiaMainPage openRiaMainPage(String pageUrl) {
    driver.manage().window().maximize();
    driver.get(pageUrl);
    return new RiaMainPage(driver);
  }


}
