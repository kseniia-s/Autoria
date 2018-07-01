package com.epam.ria.webtests.pages;

import com.epam.ria.webtests.pages.elements.Header;
import com.epam.ria.webtests.pages.elements.SearchForm;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RiaMainPage extends APage {

  private WebElement searchingButton;
  private String selectedCategory;
  private Select carCategoriesDropDown;
  private SearchForm searchForm;
  private Header header;

  public RiaMainPage(WebDriver driver) {
    super(driver);
  }

  protected void initElements() {
    searchForm = new SearchForm(driver);
    searchForm.initElements();
    header = new Header(driver);
    header.initElements();
  }

// navigation to login pages
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

// searching the car
  public void searchCarQuickly() {
    if (searchForm.getBuCarRadioBut().isSelected()) {
      searchForm.performNewCarRadioButClick();
    }
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    carCategoriesDropDown = new Select(driver.findElement(By.xpath("//*[@id='categories']")));
    carCategoriesDropDown.selectByVisibleText("Легковые");
    selectedCategory = carCategoriesDropDown.getFirstSelectedOption().getText().trim();
    System.out.println(selectedCategory);
    selectDropDownOptionByText("marks", "Skoda");
    selectDropDownOptionByText("models", "Octavia");
    selectDropDownOptionByText("regionCenters", "Винница");
    searchingButton = driver.findElement(By.xpath("//*[@id='mainSearchForm']/div[3]/button"));
    searchingButton.click();
  }

// navigation to New car pages
  public void navToNewCarPage(){ header.getNewCarMenuItem().click(); }

  public int categoryCarSelect(){
    List<WebElement> categoriesList = driver.findElements(By.cssSelector("#categories > option:nth-child(n)"));
    return categoriesList.size();
  }

  public void performSellCarButtonClick(){ header.getSellCarButton().click(); }

}