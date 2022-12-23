package com.complus.internalbooking.repository.entity;

import com.complus.internalbooking.swagger.modal.BrokerProductKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "broker_product")
public class BrokerProduct implements Serializable {


    @EmbeddedId
    private BrokerProductKey id;

    @ManyToOne
    @MapsId("brokerId")
    @JoinColumn(name = "broker_id")
    private Broker broker;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    public BrokerProductKey getId() {
        return id;
    }

    public void setId(BrokerProductKey id) {
        this.id = id;
    }

    public Broker getBroker() {
        return broker;
    }

    public void setBroker(Broker broker) {
        this.broker = broker;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
