package com.revature.SpringBootDemo.services;

import com.revature.SpringBootDemo.models.Shop;
import com.revature.SpringBootDemo.repos.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@Transactional
public class ShopServiceImpl implements ShopService{

    @Autowired
    private ShopRepo sRepo;

    @Autowired
    public ShopServiceImpl(ShopRepo sRepo){
        this.sRepo =sRepo;
    }


    @Override
    public boolean createShop(Shop shop) {
        int pk = sRepo.save(shop).getId();

        return (pk > 0) ? true:false;
    }

    @Override
    public Shop getShopById(int id) {
        try {

            Optional<Shop> target = sRepo.findById(id);
            Shop shop = target.get();

            return shop;

        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }


        return null;
    }

    @Override
    public List<Shop> getAllShops() {
        return sRepo.findAll();
    }

    @Override
    public boolean updateShop(Shop shop) {
        return sRepo.update(shop.getShopName(), shop.getInventoryCount(), shop.getId());
    }

    @Override
    public boolean deleteShop(Shop shop) {
        sRepo.delete(shop);
        return true;
    }
}
