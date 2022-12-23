package com.complus.internalbooking.swagger.modal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BrokerProductKey implements Serializable {
    @Column(name = "broker_id")
    String brokerId;

    @Column(name = "product_id")
    String productId;

    public BrokerProductKey() {
    }

    public BrokerProductKey(String brokerId, String productId) {
        this.brokerId = brokerId;
        this.productId = productId;
    }

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
