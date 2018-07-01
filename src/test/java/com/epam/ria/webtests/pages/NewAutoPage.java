package com.epam.ria.webtests.pages;

import com.epam.ria.webtests.pages.elements.BreadcrumbPage;
import com.epam.ria.webtests.pages.elements.Header;
import com.epam.ria.webtests.pages.elements.SearchForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAutoPage extends APage implements BreadcrumbPage {

  @FindBy(css = "div.breadcrumbs div:last-child")
  WebElement breadcrumb;
  private SearchForm searchForm;
  private Header header;

  public NewAutoPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
    searchForm = new SearchForm(driver);
    header = new Header(driver);
  }

  @Override
  public String getLastBreadcrumb() {
    return breadcrumb.getText().toLowerCase();
  }

  public BuAutoPage navToBuCarPage() {
    header.getBuCarMenuItem().click();
    return new BuAutoPage(driver);
  }

  public SearchForm getSearchForm() {
    return searchForm;
  }
}
