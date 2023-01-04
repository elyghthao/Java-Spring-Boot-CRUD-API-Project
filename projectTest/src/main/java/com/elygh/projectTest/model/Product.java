package com.elygh.projectTest.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_inventory")
@Data //this annotation makes it so that I don't have to create any getter or setter methods for my data variables
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private int price;

}
