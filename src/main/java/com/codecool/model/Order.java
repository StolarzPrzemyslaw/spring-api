package com.codecool.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "order_date")
    private LocalDate date;

    @OneToMany(mappedBy = "orders")
    private Set<ProductBasket> productBaskets;

    protected Order() {}

    public Order(LocalDate date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<ProductBasket> getProductBaskets() {
        return productBaskets;
    }

    public void setProductBaskets(Set<ProductBasket> productBaskets) {
        this.productBaskets = productBaskets;
    }

    @Override
    public String toString() {
        return String.format("Order[id=%d, date='%s']", id, date);
    }
}
