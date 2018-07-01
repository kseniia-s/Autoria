package com.epam.ria.webtests.pages;

import com.epam.ria.webtests.pages.elements.BreadcrumbPage;
import com.epam.ria.webtests.pages.elements.Header;
import com.epam.ria.webtests.pages.elements.SearchForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewAutoPage extends APage implements BreadcrumbPage {

  private WebElement breadcrumb;
  private SearchForm searchForm;
  private Header header;
  public NewAutoPage (WebDriver driver) {
    super(driver);
  }

  protected void initElements() {
    breadcrumb = driver.findElement(By.cssSelector("div.breadcrumbs div:last-child"));
    searchForm = new SearchForm(driver);
    searchForm.initElements();
    header = new Header(driver);
    header.initElements();
  }

  @Override
  public String getLastBreadcrumb() {
    return breadcrumb.getText().toLowerCase();
  }

  public void navToBuCarPage(){ header.getBuCarMenuItem().click(); }

  public SearchForm getSearchForm() {
    return searchForm;
  }
}
