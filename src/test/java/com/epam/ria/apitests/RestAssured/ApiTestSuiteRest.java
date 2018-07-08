package com.epam.ria.apitests.RestAssured;

import com.epam.ria.apitests.models.Category;
import com.epam.ria.apitests.models.Mark;
import com.epam.ria.apitests.models.responses.AveragePriceResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;

public class ApiTestSuiteRest {

  private String apiKey = "lHcLTkMiRyGnzCtxFsXmE9G7VnGk7cSdL0ykwUs9";

  @Test
  public void makeSureThatAutoRiaIsUp() {
    given().when().get("http://auto.ria.com").then().statusCode(200);
  }

  @Test
  public void getCategoriesTest() {
    RestAssured.baseURI = "https://developers.ria.com";
//    RestAssured.get("/auto/categories/", "api_key", apiKey).then().assertThat().body(arrayWithSize(9));

    Response res = given()
        .queryParam("api_key", apiKey)
        .when()
        .get (baseURI + "/auto/categories/").then()
        .contentType(ContentType.JSON) // check that the content type return from the API is JSON
        .extract().response();

    List<Category> returnedCategories = Arrays.asList(res.getBody().as(Category[].class));

    for (Category category: returnedCategories) {
      System.out.println(category.getValue() +": "+ category.getName());
    }

    // Assert
  }

  @Test
  public void getMarksTest(){
    RestAssured.baseURI = "https://developers.ria.com";
    Response response = given()
        .queryParam("api_key", apiKey)
        .queryParam("category_id", 1)
        .when()
        .get("/auto/new/marks").then()
        .extract().response();

    List<Mark> returnedMarks = Arrays.asList(response.getBody().as(Mark[].class));

    for(Mark mark: returnedMarks){
      System.out.println(mark.getName() + ": " + mark.getValue());
    }

    // Assert
  }
  @Test
  public void getSkodaModelIdTest(){
    Response response = get("http://api.auto.ria.com/categories/{category}/marks/{mark}/models/_group", 1, 70);
    System.out.println(response.prettyPrint());

    // Assert
}
  @Test
  public void getAveragePriceTest(){
    RestAssured.baseURI = "http://api.auto.ria.com";

    Response response = given()
        .queryParam("api_key", apiKey)
        .queryParam("marka_id", 70)
        .queryParam("model_id", 652)
        .queryParam("city_id", 1)
//        .queryParam("color_id", 13)
        .when()
        .get("/average").then()
        .extract().response();

    System.out.println(response.prettyPrint());
    AveragePriceResponse averagePriceResponse = response.getBody().as(AveragePriceResponse.class);
    System.out.println(averagePriceResponse.getArithmeticMean());
  }
}
