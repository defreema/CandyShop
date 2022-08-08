package com.revature.SpringBootDemo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "candy")
@Data
public class Candy {

    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candy_id;

    @Column(name = "c_name", unique = true, nullable = false)
    private String candyName;

    @Column(name = "c_flavor")
    private String candyFlavor;

    @Column(name = "c_price", nullable = false)
    private double price;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "c_shop", referencedColumnName = "s_id")
    private Shop shop;

    public Candy(int candy_id, String candyName, String candyFlavor, double price, Shop shop) {
        this.candy_id = candy_id;
        this.candyName = candyName;
        this.candyFlavor = candyFlavor;
        this.price = price;
        this.shop = shop;
    }

    public Candy() {
    }

    public Candy(String candyName, String candyFlavor, double price, Shop shop) {
        this.candyName = candyName;
        this.candyFlavor = candyFlavor;
        this.price = price;
        this.shop = shop;
    }

    public int getCandy_id() {
        return candy_id;
    }

    public void setCandy_id(int candy_id) {
        this.candy_id = candy_id;
    }

    public String getCandyName() {
        return candyName;
    }

    public void setCandyName(String candyName) {
        this.candyName = candyName;
    }

    public String getCandyFlavor() {
        return candyFlavor;
    }

    public void setCandyFlavor(String candyFlavor) {
        this.candyFlavor = candyFlavor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
