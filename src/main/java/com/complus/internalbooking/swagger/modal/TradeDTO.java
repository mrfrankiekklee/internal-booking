package com.complus.internalbooking.swagger.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TradeDTO {

    @JsonProperty("tradeRef")
    private String tradeRef;

    @JsonProperty("productId")
    private String productId;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("tradeDate")
    private String tradeDate;

    @JsonProperty("qty")
    private String qty;

    @JsonProperty("buySell")
    private String buySell;

    @JsonProperty("price")
    private String price;

    public TradeDTO(String tradeRef, String productId, String productName, String tradeDate, String qty, String buySell, String price) {
        this.tradeRef = tradeRef;
        this.productId = productId;
        this.productName = productName;
        this.tradeDate = tradeDate;
        this.qty = qty;
        this.buySell = buySell;
        this.price = price;
    }

    @Override
    public String toString() {
        return "TradeDTO{" +
                "tradeRef='" + tradeRef + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
                ", qty='" + qty + '\'' +
                ", buySell='" + buySell + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String[] toStringArray() {
        return new String[]{this.tradeRef, this.productId, this.productName, this.tradeDate, this.qty, this.buySell, this.price};
    }
}
