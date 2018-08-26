package com.epam.ria.webtests.pages;

import com.epam.ria.webtests.pages.elements.Header;
import com.epam.ria.webtests.pages.elements.SearchForm;
import org.openqa.selenium.*;

import java.util.List;

public class RiaMainPage extends APage {

  private SearchForm searchForm;
  private Header header;

  public RiaMainPage() {
    searchForm = new SearchForm();
    header = new Header();
  }

  public RiaMainPage open(String pageUrl) {
    driver.manage().window().maximize();
    driver.get(pageUrl);
    return new RiaMainPage();
  }

  // set parameters for a car in the searching form
  public RiaMainPage clickNewCarRadioButton() {
    searchForm.clickNewCarRadioButton();
    return this;
  }

  public RiaMainPage chooseTransport(String name) {
    selectDropDownOptionByTextId("categories", name);
    return this;
  }

  public RiaMainPage chooseBrand(String brand) {
    WebElement brandSearch = driver.findElement(By.id("brandTooltipBrandAutocompleteInput-brand"));
    brandSearch.sendKeys(brand);
    WebElement brandElement = driver.findElement(By.xpath("//div[@id='brandTooltipBrandAutocomplete-brand']//a[contains(text(),\"" + brand + "\")]"));
    brandElement.click();
    return this;
  }

  public RiaMainPage chooseModel(String model) {
    WebElement modelSearch = driver.findElement(By.id("brandTooltipBrandAutocompleteInput-model"));
    modelSearch.sendKeys(model);
    WebElement modelElement = driver.findElement(By.xpath("//div[@id='brandTooltipBrandAutocomplete-model']//a[text()=\"" + model + "\"]"));
    modelElement.click();
    return this;
  }

  public RiaMainPage chooseCity(String city) {
    selectDropDownOptionByTextId("regionCenters", city);
    return this;
  }

  public SearchCarResultPage clickSearchCar() {
    driver.findElement(By.xpath("//*[@id='mainSearchForm']/div[3]/button")).click();
    return new SearchCarResultPage();
  }

  //login
  public void navigateToLoginPage() {
    header.getLoginLink().click();
  }

  public String getOwnCabinetText() {
    WebElement ownCabinetLink;
    try {
      ownCabinetLink = driver.findElement(By.cssSelector("#header div.item.user-menu span"));
    } catch (NoSuchElementException e) {
      ownCabinetLink = driver.findElement(By.xpath("//*[@id=\"header\"]/header[1]/div[1]/div/div/a[2]/span"));
    }
    return ownCabinetLink.getText();
  }

  public boolean checkLoggedState() {
    return getOwnCabinetText().contains("Личный кабинет");
//    try {
//      WebElement ownCabinetLink = driver.findElement(By.cssSelector("#header div.item.user-menu span"));
//      return ownCabinetLink.getText().contains("Личный кабинет");
//    } catch (NoSuchElementException e) {
//      System.out.println("Not Logged In");
//    }
//    return false;
  }

  public NewAutoPage navToNewCarPage() {
    header.getNewCarMenuItem().click();
    return new NewAutoPage();
  }

  public int categoryCarSelect() {
    List<WebElement> categoriesList = driver.findElements(By.cssSelector("#categories > option:nth-child(n)"));
    return categoriesList.size();
  }

  public void clickSellCarButton() {
    header.getSellCarButton().click();
  }


}