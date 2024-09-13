package com.emanagement.stock.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "name", nullable = false)
    private String name;

    public Item() {}

    public Item(String code, int stock, String name) {
        this.code = code;
        this.stock = stock;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", stock=" + stock +
                ", name='" + name + '\'' +
                '}';
    }
}
