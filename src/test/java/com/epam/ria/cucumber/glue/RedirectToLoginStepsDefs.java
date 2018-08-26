package com.epam.ria.cucumber.glue;

import com.epam.ria.webtests.config.Browser;
import com.epam.ria.webtests.config.ChromeConfig;
import com.epam.ria.webtests.pages.AddAutoPage;
import com.epam.ria.webtests.pages.RiaMainPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.epam.ria.cucumber.DataStorage.riaMainPage;

public class RedirectToLoginStepsDefs {
  protected WebDriver driver = Browser.getInstance();

  @Then("^Unauthorized user should see \"([^\"]*)\" link in the top of the page$")
  public void unauthorizedUserShouldSeeLinkInTheTopOfThePage(String linkText){
    boolean userState = riaMainPage.checkLoggedState();
    Assert.assertFalse(userState);
    String text = riaMainPage.getOwnCabinetText();
    Assert.assertTrue(text.contains(linkText));
  }

  @And("^Unauthorized user clicks on Sell Car button$")
  public void unauthorizedUserClicksOnSellCarButton(){
    riaMainPage.clickSellCarButton();
  }

  @Then("^Auto Page displays a Login Form$")
  public void autoPageDisplaysALoginForm(){
    AddAutoPage addAutoPage = new AddAutoPage();
    Assert.assertTrue(addAutoPage.getLoginIframe().isDisplayed());
  }


}
