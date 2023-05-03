package com.shelly.coupons.entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "category")
    private List<Coupon> coupons;

    public Category() {
    }

    public Category(long id, String name) {
        this.id = id;
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
}
