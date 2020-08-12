package com.example.service;

import com.example.model.Floor;
import com.example.repo.FloorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService {

    private final FloorRepo floorRepo;

    @Autowired
    public FloorService(FloorRepo floorRepo) {
        this.floorRepo = floorRepo;
    }

    public Floor findById(int id){
        return floorRepo.getOne(id);
    }

    public List<Floor> findAll(){
        return floorRepo.findAll();
    }

    public Floor saveFloor(Floor floor){
        return floorRepo.save(floor);
    }

    public void deleteById(int id){
        floorRepo.deleteById(id);
    }


}
