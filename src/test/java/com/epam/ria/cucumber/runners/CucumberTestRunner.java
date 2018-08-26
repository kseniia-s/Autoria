package com.epam.ria.cucumber.runners;

import com.epam.ria.webtests.config.Browser;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
    features = "classpath:features",
    plugin = {"pretty", "json:cucumber.json"},//, "html:target/site/cucumber-pretty"
    glue = "com.epam.ria.cucumber.glue")
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
  @BeforeClass
  public void setUp() {
    Browser.getInstance();
  }

  @AfterClass
  public void cleanup() {
    Browser.closeBrowser();
  }
}
