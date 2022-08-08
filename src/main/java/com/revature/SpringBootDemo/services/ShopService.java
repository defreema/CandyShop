package com.revature.SpringBootDemo.services;

import com.revature.SpringBootDemo.models.Candy;
import com.revature.SpringBootDemo.models.Shop;

import java.util.List;

public interface ShopService {


    //creates a new shop
    boolean createShop(Shop shop);

    //get shop by id
    Shop getShopById(int id);

    //get all Shops
    List<Shop> getAllShops();

    //update a Shop
    boolean updateShop(Shop shop);

    //delete a Shop
    boolean deleteShop(Shop shop);
}
