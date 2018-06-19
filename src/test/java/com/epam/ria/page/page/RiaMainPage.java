package com.epam.ria.page.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class RiaMainPage extends APage {

  private WebElement searchingButton;

  private WebElement typeUsedCar;
  private WebElement typeNewCar;
  private WebElement newCar;
  private String selectedCategory;
  private Select carCategoriesDropDown;

  public RiaMainPage(WebDriver driver) {
    super(driver);
  }

  protected void initElements() {
    webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    typeUsedCar = webDriver.findElement(By.id("buRadioType"));
    typeNewCar = webDriver.findElement(By.xpath("//*[@id='naRadioType']"));
    newCar = webDriver.findElement(By.cssSelector("#mainSearchForm > div.nav > label:nth-child(5)"));
  }

  public void searchCarQuickly() {
    if (typeUsedCar.isSelected()) {
      newCar.click();
    }
    // Select category
    carCategoriesDropDown = new Select(webDriver.findElement(By.xpath("//*[@id='categories']")));
    carCategoriesDropDown.selectByVisibleText("Легковые");
    selectedCategory = carCategoriesDropDown.getFirstSelectedOption().getText().trim();
    System.out.println(selectedCategory);

    // Select mark
    selectDropDownOptionByText("marks", "Skoda");

    // Select model
    selectDropDownOptionByText("models", "Octavia");

    // Select region
    selectDropDownOptionByText("regionCenters", "Винница");

    searchingButton = webDriver.findElement(By.xpath("//*[@id='mainSearchForm']/div[3]/button"));
    searchingButton.click();
  }


}