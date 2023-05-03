package com.shelly.coupons.entities;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Coupon coupon;
    @ManyToOne
    private Customer customer;
    @Column(name = "amount",nullable = false)
    private int amount;
    @Column(name = "time_stamp", nullable = false)
    private Date timestamp;


    public Purchase(Long id, Coupon coupon, Customer customer) {
        this.id = id;
        this.coupon = coupon;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
