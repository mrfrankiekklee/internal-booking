package com.complus.internalbooking.swagger.modal;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateTradeRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-09T12:20:30.692Z[GMT]")


public class CreateTradeRequest   {
  @JsonProperty("productId")
  private String productId = null;

  @JsonProperty("tradeDate")
  private String tradeDate = null;

  @JsonProperty("isBuy")
  private Boolean isBuy = null;

  @JsonProperty("qty")
  private Integer qty = null;

  @JsonProperty("price")
  private BigDecimal price = null;

  @JsonProperty("brokerId")
  private String brokerId = null;

  @JsonProperty("pairs")
  private String pairs = null;

  @JsonProperty("expiryDate")
  private String expiryDate = null;

  public CreateTradeRequest productId(String productId) {
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

  public CreateTradeRequest tradeDate(String tradeDate) {
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

  public CreateTradeRequest isBuy(Boolean isBuy) {
    this.isBuy = isBuy;
    return this;
  }

  /**
   * Get isBuy
   * @return isBuy
   **/

    public Boolean isIsBuy() {
    return isBuy;
  }

  public void setIsBuy(Boolean isBuy) {
    this.isBuy = isBuy;
  }

  public CreateTradeRequest qty(Integer qty) {
    this.qty = qty;
    return this;
  }

  /**
   * Get qty
   * @return qty
   **/

    public Integer getQty() {
    return qty;
  }

  public void setQty(Integer qty) {
    this.qty = qty;
  }

  public CreateTradeRequest price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/

    @Valid
    public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public CreateTradeRequest brokerId(String brokerId) {
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

  public CreateTradeRequest pairs(String pairs) {
    this.pairs = pairs;
    return this;
  }

  /**
   * Get pairs
   * @return pairs
   **/

    public String getPairs() {
    return pairs;
  }

  public void setPairs(String pairs) {
    this.pairs = pairs;
  }

  public CreateTradeRequest expiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  /**
   * Get expiryDate
   * @return expiryDate
   **/

    public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateTradeRequest createTradeRequest = (CreateTradeRequest) o;
    return Objects.equals(this.productId, createTradeRequest.productId) &&
        Objects.equals(this.tradeDate, createTradeRequest.tradeDate) &&
        Objects.equals(this.isBuy, createTradeRequest.isBuy) &&
        Objects.equals(this.qty, createTradeRequest.qty) &&
        Objects.equals(this.price, createTradeRequest.price) &&
        Objects.equals(this.brokerId, createTradeRequest.brokerId) &&
        Objects.equals(this.pairs, createTradeRequest.pairs) &&
        Objects.equals(this.expiryDate, createTradeRequest.expiryDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, tradeDate, isBuy, qty, price, brokerId, pairs, expiryDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateTradeRequest {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    tradeDate: ").append(toIndentedString(tradeDate)).append("\n");
    sb.append("    isBuy: ").append(toIndentedString(isBuy)).append("\n");
    sb.append("    qty: ").append(toIndentedString(qty)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    brokerId: ").append(toIndentedString(brokerId)).append("\n");
    sb.append("    pairs: ").append(toIndentedString(pairs)).append("\n");
    sb.append("    expiryDate: ").append(toIndentedString(expiryDate)).append("\n");
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
