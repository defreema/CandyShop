package com.revature.SpringBootDemo.models;

import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;

@Entity
@Table(name = "shops")
@Data
public class Shop {

    @Id
    @Column(name = "s_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "s_name", unique = true, nullable = false)
    private String shopName;

    @Column(name = "s_inv_Count")
    private int inventoryCount;

    public Shop(int id, String shopName, int inventoryCount) {
        this.id = id;
        this.shopName = shopName;
        this.inventoryCount = inventoryCount;
    }

    public Shop(String shopName, int inventoryCount) {
        this.shopName = shopName;
        this.inventoryCount = inventoryCount;
    }

    public Shop() {
    }
}
