package com.shelly.coupons.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "id")
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private User user;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
    private List<Purchase> purchases;

    public Customer() {
    }

    public Customer(User user, String address, String phoneNumber, String fullName) {
        this.user = user;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
