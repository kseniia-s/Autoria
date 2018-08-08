package com.epam.ria.runners;

import com.epam.ria.webtests.config.Browser;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features = "src/test/resources/features",
    glue = "com.epam.ria.glue",
    plugin = {"pretty", "json:target/RedirectToLogin_Test.json"})
public class RedirectToLoginRunner extends AbstractTestNGCucumberTests {

  @BeforeClass
  public void setUp() {
    Browser.getInstance();
  }

  @AfterClass
  public void cleanup() {
    Browser.closeBrowser();
  }

}
