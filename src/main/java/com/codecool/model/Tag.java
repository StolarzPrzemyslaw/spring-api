package com.codecool.model;

import javax.persistence.*;


@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "order")
//    private Set<ProductBasket> productBaskets;

    protected Tag() {}

    public Tag(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<ProductBasket> getProductBaskets() {
//        return productBaskets;
//    }
//
//    public void setProductBaskets(Set<ProductBasket> productBaskets) {
//        this.productBaskets = productBaskets;
//    }

    @Override
    public String toString() {
        return String.format("Order[id=%d, date='%s']", id, name);
    }
}
