package com.epam.ria.cucumber.glue;

import com.epam.ria.webtests.config.Browser;
import com.epam.ria.webtests.pages.BuAutoPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.epam.ria.cucumber.DataStorage.*;

public class SearchFormRadioButtonDefs {
  protected WebDriver driver = Browser.getInstance();

  @When("^User clicks on \"New auto\" from main menu$")
  public void userClicksToFromMainMenu() {
   newAutoPage = riaMainPage.navToNewCarPage();
//    Assert.assertTrue();
  }

  @Then("^Radio button \"New auto\" in search form is selected$")
  public void radioButtonNewInSearchFormIsSelected(){
    BuAutoPage buAutoPage = newAutoPage.navToBuCarPage();
    Assert.assertTrue(buAutoPage.getSearchForm().getBuCarRadioBut().isSelected());

  }

  @And("^User clicks on \"Auto B/u\" from main menu$")
  public void userClicksOnAutoBUFromMainMenu(){
    newAutoPage = riaMainPage.navToNewCarPage();
    buAutoPage = newAutoPage.navToBuCarPage();
    Assert.assertTrue(buAutoPage.getSearchForm().getBuCarRadioBut().isSelected());
  }

  @Then("^Radio button \"Auto B/u\" in search form is selected$")
  public void radioButtonBuInSearchFormIsSelected(){
    newAutoPage = riaMainPage.navToNewCarPage();
    buAutoPage = newAutoPage.navToBuCarPage();
    Assert.assertTrue(buAutoPage.getSearchForm().getBuCarRadioBut().isSelected());
  }
}
