package com.codecool.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonManagedReference
    private Category category;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(
            name = "product_tag",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private Set<Tag> tags;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private Set<ProductBasket> productBaskets;

    protected Product() {}

    public Product(String name, BigDecimal price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<ProductBasket> getProductBaskets() {
        return productBaskets;
    }

    public void setProductBaskets(Set<ProductBasket> productBaskets) {
        this.productBaskets = productBaskets;
    }

    @Override
    public String toString() {
        return String.format("Product[id=%d, name='%s', price=%s, category=%s]",
                id, name, price, category);
    }
}
