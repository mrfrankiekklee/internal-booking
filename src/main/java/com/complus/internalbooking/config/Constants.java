package com.complus.internalbooking.config;

import java.util.Set;

public class Constants {

    public static final String[] productList = new String[]{"tradeRef","productId", "productName", "tradeDate", "qty", "buySell", "price"};

    public static final Set<String> productCriteriaSet = Set.of("type", "subType");

    public static final Set<String> brokerCriteriaSet = Set.of("brokerId");



}
