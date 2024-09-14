package com.emanagement.stock.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "items")
@Data
public class Item {

    @Id
    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "name", nullable = false)
    private String name;

}
