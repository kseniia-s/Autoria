package com.epam.ria.page.apitests;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApiTestSuite {

  private String apiKey = "lHcLTkMiRyGnzCtxFsXmE9G7VnGk7cSdL0ykwUs9";
  OkHttpClient client = new OkHttpClient();

  private HttpUrl.Builder getBaseHttpUrlBuilder() {
    return new HttpUrl.Builder()
        .scheme("https")
        .host("developers.ria.com")
        .addQueryParameter("api_key", apiKey);
  }

  @Test
  public void test() throws IOException {
    HttpUrl url = getBaseHttpUrlBuilder()
        .addPathSegments("/auto/categories/")
        .build();
    Request request = new Request.Builder()
        .url(url)
        .build();
    Response response = client.newCall(request).execute();
    Assert.assertEquals(response.code(), 200);

    JsonParser parser = new JsonParser();
    JsonElement jsonResponse = parser.parse(response.body().string());

    Assert.assertEquals(jsonResponse.getAsJsonArray().size(), 9);
    Assert.assertEquals(jsonResponse.getAsJsonArray().get(0).getAsJsonObject().get("name").getAsString(), "Легковые");
  }
}
