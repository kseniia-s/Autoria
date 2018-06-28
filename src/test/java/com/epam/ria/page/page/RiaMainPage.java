package com.epam.ria.page.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class RiaMainPage extends APage {

  private WebElement searchingButton;

  private WebElement typeUsedCar;
  private WebElement newCar;
  private String selectedCategory;
  private Select carCategoriesDropDown;
  private WebElement loginLink;

  public RiaMainPage(WebDriver driver) {
    super(driver);
  }

  protected void initElements() {
//    webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    typeUsedCar = webDriver.findElement(By.id("buRadioType"));
    newCar = webDriver.findElement(By.cssSelector("#mainSearchForm > div.nav > label:nth-child(5)"));
    loginLink = webDriver.findElement(By.xpath("//header[@class='app-header']//a[@href='https://auto.ria.com/login.html']"));
  }

  public void navigateToLoginPage(){
    loginLink.click();
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

  public boolean checkLoggedState() {
    try {
      WebElement ownCabinetLink = webDriver.findElement(By.cssSelector("#header div.item.user-menu span"));
      return ownCabinetLink.getText().toLowerCase().contains("Личный кабинет");
    } catch (NoSuchElementException e) {
      System.out.println("Not Logged In");
    }
    return false;
  }
}