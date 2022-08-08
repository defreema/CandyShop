package com.revature.SpringBootDemo.controllers;


import com.revature.SpringBootDemo.models.Candy;
import com.revature.SpringBootDemo.models.ClientMessage;
import com.revature.SpringBootDemo.models.Shop;
import com.revature.SpringBootDemo.services.CandyService;
import com.revature.SpringBootDemo.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.revature.SpringBootDemo.utils.ClientMessageUtil.*;
import static com.revature.SpringBootDemo.utils.ClientMessageUtil.DELETION_FAILED;


//Good practice for creating a RESTFULL app is using @RestController
//as well as maintaining the same 'base' url
@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/app")
public class CandyController {

    @Autowired
    private CandyService c_service;



    @GetMapping(value = "/candy",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Candy getById(@RequestParam int id){
        return c_service.getCandyById(id);
    }

    @GetMapping("/candies")
    public @ResponseBody List<Candy> getAll(){

        return c_service.getAllCandies();
    }

    @PostMapping("/candy")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createCandy(@RequestBody Candy candy){

        return c_service.createCandy(candy) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PutMapping("/candy")
    public @ResponseBody ClientMessage updateCandy(@RequestBody Candy candy){

        return c_service.updateCandy(candy)?UPDATE_SUCCESSFUL: UPDATE_FAILED;

    }

    @DeleteMapping("/candy")
    public @ResponseBody ClientMessage deleteCandy(@RequestBody Candy candy){
        return c_service.deleteCandy(candy) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }
}
