package com.epam.ria.webtests.pages;

import com.epam.ria.webtests.pages.elements.Header;
import com.epam.ria.webtests.pages.elements.SearchForm;
import org.openqa.selenium.*;

import java.util.List;

public class RiaMainPage extends APage {

  private SearchForm searchForm;
  private Header header;

  public RiaMainPage(WebDriver driver) {
    super(driver);
    searchForm = new SearchForm(driver);
    header = new Header(driver);
  }

  public RiaMainPage clickNewCarRadioButton() {
    searchForm.clickNewCarRadioButton();
    return this;
  }

  public RiaMainPage chooseTransport(String name) {
    selectDropDownOptionByText("categories", name);
    return this;
  }
  public RiaMainPage chooseBrand (String brand) {
    selectDropDownOptionByText("marks", brand);
    return this;
  }
  public RiaMainPage chooseModel (String model) {
    selectDropDownOptionByText("models", model);
    return this;
  }
  public RiaMainPage chooseCity (String city) {
    selectDropDownOptionByText("regionCenters", city);
    return this;
  }
  public SearchCarResultPage clickSearchCar () {
    driver.findElement(By.xpath("//*[@id='mainSearchForm']/div[3]/button")).click();
    return new SearchCarResultPage(driver);
  }

// navigation to login page
  public void navigateToLoginPage(){
    header.getLoginLink().click();
  }

  public boolean checkLoggedState() {
    try {
      WebElement ownCabinetLink = driver.findElement(By.cssSelector("#header div.item.user-menu span"));
      return ownCabinetLink.getText().toLowerCase().contains("Личный кабинет");
    } catch (NoSuchElementException e) {
      System.out.println("Not Logged In");
    }
    return false;
  }

// navigation to New car pages
  public NewAutoPage navToNewCarPage(){
    header.getNewCarMenuItem().click();
    return new NewAutoPage(driver);
  }

  public int categoryCarSelect(){
    List<WebElement> categoriesList = driver.findElements(By.cssSelector("#categories > option:nth-child(n)"));
    return categoriesList.size();
  }

  public void clickSellCarButton(){
    header.getSellCarButton().click();
  }
}