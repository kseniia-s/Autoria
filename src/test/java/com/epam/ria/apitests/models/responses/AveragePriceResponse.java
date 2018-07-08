package com.epam.ria.apitests.models.responses;

public class AveragePriceResponse {
  private Integer total;
  private Float arithmeticMean;

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Float getArithmeticMean() {
    return arithmeticMean;
  }

  public void setArithmeticMean(Float arithmeticMean) {
    this.arithmeticMean = arithmeticMean;
  }
}
