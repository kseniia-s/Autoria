package com.epam.ria.webtests.pages;

import com.epam.ria.webtests.pages.elements.BreadcrumbPage;
import com.epam.ria.webtests.pages.elements.SearchForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuAutoPage extends APage implements BreadcrumbPage {

    @FindBy(css = "div.breadcrumbs div:last-child")
    WebElement breadcrumb;

    private SearchForm searchForm;

    public BuAutoPage(WebDriver driver) {
      super(driver);
      PageFactory.initElements(driver, this);
      searchForm = new SearchForm(driver);
    }

    @Override
    public String getLastBreadcrumb() {
      return breadcrumb.getText().toLowerCase();
    }

    public SearchForm getSearchForm() {
      return searchForm;
    }
  }
