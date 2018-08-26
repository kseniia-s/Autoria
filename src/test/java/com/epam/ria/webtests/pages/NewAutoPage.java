package com.epam.ria.webtests.pages;

import com.epam.ria.webtests.pages.elements.Header;
import com.epam.ria.webtests.pages.elements.SearchForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAutoPage extends APage {

  @FindBy(css = "section.panel-breadcrumbs.mhide div:last-child")
  private WebElement breadcrumb;
  private SearchForm searchForm;
  private Header header;

  public NewAutoPage() {
    PageFactory.initElements(driver, this);
    searchForm = new SearchForm();
    header = new Header();
  }

  public String getLastBreadcrumb() {
    return breadcrumb.getText().toLowerCase();
  }

  public BuAutoPage navToBuCarPage() {
    header.getBuCarMenuItem().click();
    return new BuAutoPage();
  }

  public SearchForm getSearchForm() {
    return searchForm;
  }
}
