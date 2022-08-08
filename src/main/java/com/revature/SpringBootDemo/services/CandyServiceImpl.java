package com.revature.SpringBootDemo.services;

import com.revature.SpringBootDemo.models.Candy;
import com.revature.SpringBootDemo.repos.CandyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CandyServiceImpl implements CandyService{

    @Autowired
    private CandyRepo candyRepo;

    @Autowired
    public CandyServiceImpl(CandyRepo candyRepo){
        this.candyRepo =candyRepo;
    }

    @Override
    public boolean createCandy(Candy candy) {
        int pk = candyRepo.save(candy).getCandy_id();
        return (pk > 0)? true:false;
    }

    @Override
    public Candy getCandyById(int id) {


        return candyRepo.findById(id);
    }

    @Override
    public List<Candy> getAllCandies() {
        return candyRepo.findAll();
    }

    @Override
    public boolean updateCandy(Candy candy) {
        /*
        Candy target = candyRepo.find

        */
        return candyRepo.update(candy.getCandyName(),candy.getPrice(),candy.getCandy_id());

    }

    @Override
    public boolean deleteCandy(Candy candy) {
        candyRepo.delete(candy);
        return true;
    }
}
