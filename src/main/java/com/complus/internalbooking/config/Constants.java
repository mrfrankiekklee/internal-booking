package com.complus.internalbooking.config;

import java.util.Set;

public class Constants {

    public static final String[] productList = new String[]{"tradeRef","productId", "productName", "tradeDate", "qty", "buySell", "price"};

    public static final Set<String> filterCriteriaList = Set.of("productId", "brokerId", "tradeDate", "product", "type", "subType");


}
