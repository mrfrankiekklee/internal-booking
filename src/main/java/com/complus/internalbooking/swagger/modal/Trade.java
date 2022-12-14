package com.complus.internalbooking.swagger.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Trade {

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
}
