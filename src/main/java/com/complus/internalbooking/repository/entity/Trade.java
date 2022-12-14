package com.complus.internalbooking.repository.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name="Trade")
@Table(name="trade")
public class Trade implements Serializable {
    public Trade(){}
    public Trade(Product product, String ref, String tradeDate, Integer qty, Boolean isBuy, Broker broker, String pairs, String price, String expiry) {
        this.product = product;
        this.ref = ref;
        this.tradeDate = tradeDate;
        this.qty = qty;
        this.isBuy = isBuy;
        this.broker = broker;
        this.pairs = pairs;
        this.price = price;
        this.expiry = expiry;
    }

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @ManyToOne
    private Product product;

    @Column(name = "ref")
    private String ref;

    @Column(name = "trade_date")
    private String tradeDate;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "is_buy")
    private Boolean isBuy;

    @ManyToOne
    private Broker broker;

    @Column(name = "price")
    private String price;

    @Column(name = "pairs")
    private String pairs;

    @Column(name = "expiry")
    private String expiry;

    @CreationTimestamp
    @Column(name = "created")
    private Date created;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Boolean getBuy() {
        return isBuy;
    }

    public void setBuy(Boolean buy) {
        isBuy = buy;
    }

    public Broker getBroker() {
        return broker;
    }

    public void setBroker(Broker broker) {
        this.broker = broker;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPairs() {
        return pairs;
    }

    public void setPairs(String pairs) {
        this.pairs = pairs;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id='" + id + '\'' +
                ", product=" + product +
                ", ref='" + ref + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
                ", qty=" + qty +
                ", isBuy=" + isBuy +
                ", broker=" + broker +
                ", price='" + price + '\'' +
                ", expiry='" + expiry + '\'' +
                ", created=" + created +
                '}';
    }
}
