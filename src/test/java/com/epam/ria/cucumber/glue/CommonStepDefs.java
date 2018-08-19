package com.epam.ria.cucumber.glue;

import com.epam.ria.cucumber.DataStorage;
import cucumber.api.java.en.Given;

public class CommonStepDefs {

  @Given("^User goes to the main page$")
  public void userGoesToTheMainPage() {
    DataStorage.riaMainPage.open(DataStorage.BASE_URL);
//    Assert.assertEquals(riaMainPage.getURL(), "https://auto.ria.com/");
  }
}
