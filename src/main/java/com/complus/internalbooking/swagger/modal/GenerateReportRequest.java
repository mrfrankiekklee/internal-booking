package com.complus.internalbooking.swagger.modal;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;


/**
 * GenerateReportRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-09T12:20:30.692Z[GMT]")


public class GenerateReportRequest   {
  @JsonProperty("productType")
  private String productType = null;

  @JsonProperty("productSubType")
  private String productSubType = null;

  @JsonProperty("brokerId")
  private String brokerId = null;

  @JsonProperty("tradeDate")
  private String tradeDate = null;

  public GenerateReportRequest productType(String productType) {
    this.productType = productType;
    return this;
  }

  /**
   * Get productType
   * @return productType
   **/

  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public GenerateReportRequest productSubType(String productSubType) {
    this.productSubType = productSubType;
    return this;
  }

  /**
   * Get productSubType
   * @return productSubType
   **/

  public String getProductSubType() {
    return productSubType;
  }

  public void setProductSubType(String productSubType) {
    this.productSubType = productSubType;
  }

  public GenerateReportRequest brokerId(String brokerId) {
    this.brokerId = brokerId;
    return this;
  }

  /**
   * Get brokerId
   * @return brokerId
   **/

  public String getBrokerId() {
    return brokerId;
  }

  public void setBrokerId(String brokerId) {
    this.brokerId = brokerId;
  }

  public GenerateReportRequest tradeDate(String tradeDate) {
    this.tradeDate = tradeDate;
    return this;
  }

  /**
   * Get tradeDate
   * @return tradeDate
   **/

  public String getTradeDate() {
    return tradeDate;
  }

  public void setTradeDate(String tradeDate) {
    this.tradeDate = tradeDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenerateReportRequest generateReportRequest = (GenerateReportRequest) o;
    return Objects.equals(this.productType, generateReportRequest.productType) &&
            Objects.equals(this.productSubType, generateReportRequest.productSubType) &&
            Objects.equals(this.brokerId, generateReportRequest.brokerId) &&
            Objects.equals(this.tradeDate, generateReportRequest.tradeDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productType, productSubType, brokerId, tradeDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenerateReportRequest {\n");

    sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
    sb.append("    productSubType: ").append(toIndentedString(productSubType)).append("\n");
    sb.append("    brokerId: ").append(toIndentedString(brokerId)).append("\n");
    sb.append("    tradeDate: ").append(toIndentedString(tradeDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
