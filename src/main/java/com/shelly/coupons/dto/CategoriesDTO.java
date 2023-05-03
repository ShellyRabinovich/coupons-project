package com.shelly.coupons.dto;


public class CategoriesDTO {
    private long id;
    private String name;

    public CategoriesDTO() {
    }

    public CategoriesDTO(long id, String name) {
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
