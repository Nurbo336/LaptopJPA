package com.jdbc.jdbcspring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String model;
    private String brand;
    private BigDecimal price;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte [] laptopPhoto;
}
