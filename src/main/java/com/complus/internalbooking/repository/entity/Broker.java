package com.complus.internalbooking.repository.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Broker")
@Table(name = "broker")
public class Broker implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "created")
    private String created;

    @OneToMany(mappedBy = "broker", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "broker_id", referencedColumnName = "id")
    private Set<BrokerProduct> brokerProductSet = new HashSet<>();

    public Broker() {}
    public Broker(String id, String name, String created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Set<BrokerProduct> getBrokerProductSet() {
        return brokerProductSet;
    }

    public void setBrokerProductSet(Set<BrokerProduct> brokerProductSet) {
        this.brokerProductSet = brokerProductSet;
    }
}
