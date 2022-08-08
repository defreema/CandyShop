package com.revature.SpringBootDemo.controllers;



import com.revature.SpringBootDemo.models.ClientMessage;
import com.revature.SpringBootDemo.models.Shop;
import com.revature.SpringBootDemo.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.revature.SpringBootDemo.utils.ClientMessageUtil.*;

@RestController
@RequestMapping("/app")
public class ShopController {

    @Autowired
    private ShopService s_service;

    @GetMapping(value = "/shop",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Shop getById(@RequestParam int id){
        return s_service.getShopById(id);
    }

    @GetMapping("/shops")
    public @ResponseBody List<Shop> getAll(){

        return s_service.getAllShops();
    }

    @PostMapping("/shop")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createShop(@RequestBody Shop shop){

        return s_service.createShop(shop) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PutMapping("/shop")
    public @ResponseBody ClientMessage updateShop(@RequestBody Shop shop){

        return s_service.updateShop(shop)?UPDATE_SUCCESSFUL: UPDATE_FAILED;

    }

    @DeleteMapping("/shop")
    public @ResponseBody ClientMessage deleteShop(@RequestBody Shop shop){
        return s_service.deleteShop(shop) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }


}
