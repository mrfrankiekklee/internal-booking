package com.complus.internalbooking.swagger.modal;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Report
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-13T14:53:02.931Z[GMT]")


public class Report   {
  @JsonProperty("tradeRef")
  private String tradeRef = null;

  @JsonProperty("productId")
  private String productId = null;

  @JsonProperty("productName")
  private String productName = null;

  @JsonProperty("tradeDate")
  private String tradeDate = null;

  @JsonProperty("qty")
  private String qty = null;

  @JsonProperty("buySell")
  private String buySell = null;

  @JsonProperty("price")
  private String price = null;

  public Report tradeRef(String tradeRef) {
    this.tradeRef = tradeRef;
    return this;
  }

  /**
   * Get tradeRef
   * @return tradeRef
   **/

    public String getTradeRef() {
    return tradeRef;
  }

  public void setTradeRef(String tradeRef) {
    this.tradeRef = tradeRef;
  }

  public Report productId(String productId) {
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

  public Report productName(String productName) {
    this.productName = productName;
    return this;
  }

  /**
   * Get productName
   * @return productName
   **/

    public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Report tradeDate(String tradeDate) {
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

  public Report qty(String qty) {
    this.qty = qty;
    return this;
  }

  /**
   * Get qty
   * @return qty
   **/

    public String getQty() {
    return qty;
  }

  public void setQty(String qty) {
    this.qty = qty;
  }

  public Report buySell(String buySell) {
    this.buySell = buySell;
    return this;
  }

  /**
   * Get buySell
   * @return buySell
   **/

    public String getBuySell() {
    return buySell;
  }

  public void setBuySell(String buySell) {
    this.buySell = buySell;
  }

  public Report price(String price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/

    public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Report report = (Report) o;
    return Objects.equals(this.tradeRef, report.tradeRef) &&
        Objects.equals(this.productId, report.productId) &&
        Objects.equals(this.productName, report.productName) &&
        Objects.equals(this.tradeDate, report.tradeDate) &&
        Objects.equals(this.qty, report.qty) &&
        Objects.equals(this.buySell, report.buySell) &&
        Objects.equals(this.price, report.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeRef, productId, productName, tradeDate, qty, buySell, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Report {\n");
    
    sb.append("    tradeRef: ").append(toIndentedString(tradeRef)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
    sb.append("    tradeDate: ").append(toIndentedString(tradeDate)).append("\n");
    sb.append("    qty: ").append(toIndentedString(qty)).append("\n");
    sb.append("    buySell: ").append(toIndentedString(buySell)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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
