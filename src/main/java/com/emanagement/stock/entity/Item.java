package com.emanagement.stock.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "items")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "name", nullable = false)
    private String name;

}
