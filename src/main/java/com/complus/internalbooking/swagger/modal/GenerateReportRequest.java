package com.complus.internalbooking.swagger.modal;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GenerateReportRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-09T12:20:30.692Z[GMT]")


public class GenerateReportRequest   {
  @JsonProperty("productId")
  @NotEmpty
  private String productId;

  @JsonProperty("brokerId")
  @NotEmpty
  private String brokerId ;

  @JsonProperty("tradeDate")
  private String tradeDate = null;


  public GenerateReportRequest productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
   **/

    public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
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

  public GenerateReportRequest tradeDate(String startDate) {
    this.tradeDate = tradeDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
   **/

    public String getTradeDate() {
    return tradeDate;
  }

  public void setTradeDate(String tradeDate) {
    this.tradeDate = tradeDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenerateReportRequest generateReportRequest = (GenerateReportRequest) o;
    return Objects.equals(this.productId, generateReportRequest.productId) &&
        Objects.equals(this.brokerId, generateReportRequest.brokerId) &&
        Objects.equals(this.tradeDate, generateReportRequest.tradeDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, brokerId, tradeDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenerateReportRequest {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    brokerId: ").append(toIndentedString(brokerId)).append("\n");
    sb.append("    tradeDate: ").append(toIndentedString(tradeDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
